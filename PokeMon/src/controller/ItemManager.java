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
      System.out.println("ItemMamager�� ��");
      //���� �Ѿ�, ���� ���� ���� �ݾ��� �����ͼ� �� ����ִ�
      System.out.println("�����Ѿ� : " + check);
      
      user.setuGold(user.getuGold() - check);
      
      System.out.println("���� �ݾ� : " + user.getuGold());
   }
   
   public void addInven(int iNo, int iAmount) {
      
      System.out.println("���� �κ��丮 �߰� ����");
      System.out.println("������ ������ ��ȣ : " + iNo + " / ���� : " + iAmount);
      
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
    		  System.out.print(i + " : ��ĭ | ");
    	  }else {
    		  System.out.print(" " + i + " : " + user.getUi_list().get(i).getiName() + " / "
    				  + user.getUi_list().get(i).getiAmount() + "�� |");
    		  useBall(i);
    	  }
      }
   }
   
   
   //��Ʋ���� �޾ƿ;� ��
   public void useStone(int iNo, int useStone) {
	      //��ȭ�� �� ����
	      if(iNo>=6&&iNo<=8) {
	         
	         System.out.println("�� ���");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("���� �� ���� : "+item.getiAmount());
	         useStone = user.getUi_list().get(iNo).getiAmount()-useStone;
	         
	         user.getUi_list().get(iNo).setiAmount(useStone);
	         
	         System.out.println("���� ��ȭ�� �� : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("�� ��� ��");
	         
	         //��ȭ Ŭ������ ������ ��
	         
	      }else {
	         System.out.println("���� �ƴ�");
	      }
	      
	   }
	   /*public void useBall(int iNo, int useBall) {
	      if(iNo>=0&&iNo<=2) {
	         
	         System.out.println("�� ���");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("���� �� ���� : "+item.getiAmount());
	         useBall = user.getUi_list().get(iNo).getiAmount()-useBall;
	         
	         user.getUi_list().get(iNo).setiAmount(useBall);
	         
	         System.out.println("���� �� ���� : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("�� ��� ��");
	         
	         //��ȭ Ŭ������ ������ ��
	         
	      }else {
	         System.out.println("���� �ƴ�");
	      }
	   }*/
	   public void Recovery(int iNo, int useRecovery) {
	      if(iNo>=3&&iNo<=5) {
	         
	         System.out.println("ȸ���� ���");
	         Item item = new Item();
	         item = id.getIList().get(iNo);
	         System.out.println("���� ȸ���� ���� : "+item.getiAmount());
	         useRecovery = user.getUi_list().get(iNo).getiAmount()-useRecovery;
	         
	         user.getUi_list().get(iNo).setiAmount(useRecovery);
	         
	         System.out.println("���� ȸ���� ���� : "+user.getUi_list().get(iNo).getiAmount());
	         System.out.println("�� ��� ȸ����");
	         
	         //��ȭ Ŭ������ ������ ��
	         
	      }else {
	         System.out.println("ȸ������ �ƴ�");
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
					   System.out.println("��� ������ : "+id.getIList().get(i).getiName());
					   System.out.println("���� ���� : "+id.getIList().get(i).getiAmount());
					   System.out.println("��ȹ  : "+((Ball)item).getcProb());
					   return ((Ball)item).getcProb();
				   }
			   }
		   }else if(id.getIList().get(iNo) instanceof Stone) {
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(i==iNo) {
					   id.getIList().get(i).setiAmount(id.getIList().get(i).getiAmount()-1);
					   System.out.println("��� ������ : "+id.getIList().get(i).getiName());
					   System.out.println("���� ���� : "+id.getIList().get(i).getiAmount());
					   //return Evolution���� ������;
				   }
			   }
		   }else if(id.getIList().get(iNo) instanceof Recovery) {
			   for(int i=0; i<id.getIList().size() ; i++) {
				   if(i==iNo) {
					   id.getIList().get(i).setiAmount(id.getIList().get(i).getiAmount()-1);
					   System.out.println("��� ������ : "+id.getIList().get(i).getiName());
					   System.out.println("���� ���� : "+id.getIList().get(i).getiAmount());
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
					   System.out.println("��ȭ�� ���� ����� �� ���� ��ü �Դϴ�.");
				   }
			   }
			   
		   }
		   
		   return false;
	   }
	   
}