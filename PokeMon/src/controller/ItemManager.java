package controller;

import model.dao.ItemDao;
import model.vo.Ball;
import model.vo.Item;
import model.vo.Pokemon;
import model.vo.Recovery;
import model.vo.Stone;
import model.vo.User;

public class ItemManager {
   
   private ItemDao id = new ItemDao();
   private User user;
   private Pokemon p = new Pokemon();
   
   public ItemManager(User user) {
	   this.user = user;
   }
   
   public void decreaseGold(int check) {
      System.out.println("ItemMamager로 옴");
      //구매 총액, 현재 유저 소지 금액을 가져와서 돈 깍아주는
      System.out.println("구매총액 : " + check);
      
      user.setuGold(user.getuGold() - check);
      
      System.out.println("현재 금액 : " + user.getuGold());
   }
   
   public void addInven(int iNo, int iAmount) {
      
      System.out.println("유저 인벤토리 추가 실행");
      System.out.println("선택한 아이템 번호 : " + iNo + " / 수량 : " + iAmount);
      
      Item item = new Item();
      item = id.getIList().get(iNo);
      
      if(user.getUi_list().get(iNo) != null) {
    	  iAmount = iAmount + user.getUi_list().get(iNo).getiAmount();
      }
      
      user.getUi_list().set(iNo, item);
      user.getUi_list().get(iNo).setiAmount(iAmount);
      
      System.out.println(user.getUi_list());
      System.out.println(user.getUi_list().get(iNo).getiAmount());
      
      for(int i = 0; i < user.getUi_list().size(); i++) {
    	  if(user.getUi_list().get(i) == null) {
    		  System.out.print(i + " : 빈칸 | ");
    	  }else {
    		  System.out.print(" " + i + " : " + user.getUi_list().get(i).getiName() + " / "
    				  + user.getUi_list().get(i).getiAmount() + "개 |");
    		  useBall(i);
    	  }
      }
   }
   
   
   //배틀에서 받아와야 됨
   public void useStone(int iNo, int useStone) {
	      //진화의 돌 사용시
	      if(iNo>=6&&iNo<=8) {
	         
	         System.out.println("돌 사용");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("현재 돌 수량 : "+item.getiAmount());
	         useStone = user.getUi_list().get(iNo).getiAmount()-useStone;
	         
	         user.getUi_list().get(iNo).setiAmount(useStone);
	         
	         System.out.println("남은 진화의 돌 : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("돌 사용 끝");
	         
	         //진화 클래스도 만들어야 함
	         
	      }else {
	         System.out.println("돌이 아님");
	      }
	      
	   }
	   /*public void useBall(int iNo, int useBall) {
	      if(iNo>=0&&iNo<=2) {
	         
	         System.out.println("볼 사용");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("현재 볼 수량 : "+item.getiAmount());
	         useBall = user.getUi_list().get(iNo).getiAmount()-useBall;
	         
	         user.getUi_list().get(iNo).setiAmount(useBall);
	         
	         System.out.println("남은 볼 수량 : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("볼 사용 끝");
	         
	         //진화 클래스도 만들어야 함
	         
	      }else {
	         System.out.println("볼이 아님");
	      }
	   }*/
	   public void Recovery(int iNo, int useRecovery) {
	      if(iNo>=3&&iNo<=5) {
	         
	         System.out.println("회복약 사용");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("현재 회복약 수량 : "+item.getiAmount());
	         useRecovery = user.getUi_list().get(iNo).getiAmount()-useRecovery;
	         
	         user.getUi_list().get(iNo).setiAmount(useRecovery);
	         
	         System.out.println("남은 회복약 수량 : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("볼 사용 회복약");
	         
	         //진화 클래스도 만들어야 함
	         
	      }else {
	         System.out.println("회복약이 아님");
	      }      
	   }
	   public int useBall(int iNo) {
		   Item item = id.getIList().get(iNo);
		   int prob=2;
		   if(item instanceof Ball) {
			   item = (Ball)id.getIList().get(iNo);
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(i==iNo) {
					   id.getIList().get(i).setiAmount(id.getIList().get(i).getiAmount()-1);
					   System.out.println("사용 아이템 : "+id.getIList().get(i).getiName());
					   System.out.println("남은 수량 : "+id.getIList().get(i).getiAmount());
					   System.out.println("포획  : "+((Ball)item).getcProb());
					   return ((Ball)item).getcProb();
				   }
			   }
		   }else if(id.getIList().get(iNo) instanceof Stone) {
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(i==iNo) {
					   id.getIList().get(i).setiAmount(id.getIList().get(i).getiAmount()-1);
					   System.out.println("사용 아이템 : "+id.getIList().get(i).getiName());
					   System.out.println("남은 수량 : "+id.getIList().get(i).getiAmount());
					   //return Evolution으로 보내줌;
				   }
			   }
		   }else if(id.getIList().get(iNo) instanceof Recovery) {
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(i==iNo) {
					   id.getIList().get(i).setiAmount(id.getIList().get(i).getiAmount()-1);
					   System.out.println("사용 아이템 : "+id.getIList().get(i).getiName());
					   System.out.println("남은 수량 : "+id.getIList().get(i).getiAmount());
					   return ((Ball)item).getcProb();
				   }
			   }
		   }
		   return prob;
	   }
	   public boolean useStone(int iNo) {
		   if(id.getIList().get(iNo) instanceof Stone) {
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(user.getUp_list().get(iNo).getpType()==1) {
					   
				   }else if(user.getUp_list().get(iNo).getpType()==2) {
					   
				   }else if(user.getUp_list().get(iNo).getpType()==3) {
					   
				   }else {
					   System.out.println("진화의 돌을 사용할 수 없는 객체 입니다.");
				   }
			   }
			   
		   }
		   
		   return false;
	   }
	   
}