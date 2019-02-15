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
	   public void useBall(int iNo, int useBall) {
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
	   }
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
}