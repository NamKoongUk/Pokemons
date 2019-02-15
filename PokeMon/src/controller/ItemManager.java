package controller;

import model.dao.ItemDao;
import model.vo.Item;
import model.vo.User;

public class ItemManager {
   
   private ItemDao id = new ItemDao();
   private User user;
   
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
	   public void useBall(int iNo, int useBall) {
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
	   }
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
}