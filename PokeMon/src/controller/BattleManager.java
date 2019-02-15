package controller;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import model.dao.PokemonDao;
import model.dao.SkillDao;
import model.vo.Pokemon;
import model.vo.User;
import view.PInfoPage;

public class BattleManager {


   private PInfoPage pip;
   private PokemonDao pd = new PokemonDao();
   private SkillDao sd = new SkillDao();
   private Pokemon poke;     //���� ���ϸ�
   private Pokemon mypoke;   //�� ���ϸ�
   private int num;
   
   
   public Pokemon getPoke() {
      return poke;
   }
   public void setPoke(Pokemon poke) {
      this.poke = poke;
   }

   public void getpUser(User user) {
	   
	   user.getUp_list().set(0, new Pokemon());

   }
   

   //���� ���ϸ� �����ִ� �κ�
   public void showP(PInfoPage pip, User user) {

	   
	   user.getUp_list().set(0, new Pokemon());
	   
      this.pip = pip;
      

      JTextArea[] jta = new JTextArea[4];
      JLabel[] jl = new JLabel[4];
      

      for(int i=0; i<4; i++) {
    	  
    	  if(user.getUp_list().get(i) == null) {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
    		  jta[i].setText("\t���ϸ� �̸� : "+ " " + "\n"
   	               +"\t��    �� : " + " " + "\n"
   	               +"\t��    �� : " + " " + "\n"
   	               +"\t�� �� �� : " + " " + "\n"
   	               +"\tü    ��  : " +" " + "\n");
   	         jta[i].setEditable(false);
    		  jl[i].setIcon(new ImageIcon("images/userMenuImages/pInfo4.png"));
    	  }else {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
        	  
    	         num = user.getUp_list().get(i).getpNo();
    	         jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+num+".png"));


    	         jta[i].setText("\t���ϸ� �̸� : "+ user.getUp_list().get(i).getpName() + "\n"
    	               +"\t��    �� : " + user.getUp_list().get(i).getpLevel() + "\n"
    	               +"\t��    �� : " + user.getUp_list().get(i).getGrade() + "\n"
    	               +"\t�� �� �� : " + user.getUp_list().get(i).getpSpeed() + "\n"
    	               +"\tü    ��  : " +user.getUp_list().get(i).getpHp() + "\n");
    	         jta[i].setEditable(false);
    	  }
    	
         
        

      }

      pip.setpInfoText(jta);
      pip.setpInfo(jl);

   }
   
   
   
   public void showS() {

   }


   //���ϸ� ���� ���
   public void randomP(User user) {

	   //System.out.println(user.getuName());
	   
      int randomIndex = new Random().nextInt(3);
      int randomLevel = new Random().nextInt(10)+1;
      user.getEp_list().set(0, pd.getpList().get(randomIndex));


      //���ϸ� �Ӽ� ����
      user.getEp_list().get(0).setpLevel(randomLevel);
      user.getEp_list().get(0).setExp(randomLevel);
      user.getEp_list().get(0).setpHp(randomLevel);
      user.getEp_list().get(0).setpSpeed(randomLevel);
      user.getEp_list().get(0).setExp(randomLevel);
      
   
      
      //���ϸ� ��ų ����
     /* for(int i=0; i<4; i++) {
         int random = new Random().nextInt(18);
         int ctn = new Random().nextInt(2);
         if(  user.getEp_list().get(0).getpType() == 0 && sd.getsList().get(random).getsType()==0) {
        	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
         }
         if( user.getEp_list().get(0).getpType() == 1 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==1)) {
            if(ctn == 0) {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
         if( user.getEp_list().get(0).getpType() == 2 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==2)) {
            if(ctn == 0) {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
         if( user.getEp_list().get(0).getpType() == 3 && (sd.getsList().get(random).getsType()==0 || sd.getsList().get(random).getsType()==3)) {
            if(ctn == 0) {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }else {
            	 user.getEp_list().get(0).getpSkill().add(sd.getsList().get(random));
            }
         }
      }*/
      System.out.println(user.getEp_list().get(0).getpName());
   }

   public void battle(User user) {
      System.out.println("��Ʋ");
      if(mypoke.getpSpeed()>poke.getpSpeed()) {
         atkMP();
         atkEP(user);
      }else {
         atkEP(user);
         atkMP();
      }
   }
   

   //�� ���ϸ��� ����
   public void atkMP() {



   }

   //��� ���ϸ��� ����
   public void atkEP(User user) {
      
      int random = new Random().nextInt(4);
      //���� ���ϸ��� �븻
      if(poke.getpType() == 0 ) {
         user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(user.getUp_list().get(0).getpHp());
      }
      if(poke.getpType() == user.getUp_list().get(0).getpType()) {
    	  user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(user.getUp_list().get(0).getpHp());
      }
      //���� ���ϸ��� �ҼӼ�
      if(poke.getpType() == 1) {
         //���� ���� ��
         if(user.getUp_list().get(0).getpType() == 2) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //���� Ǯ�� ��
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }
      //���� ���ϸ��� ���Ӽ�
      if(poke.getpType() == 2) {
         //���� ���� ��
         if(user.getUp_list().get(0).getpType() == 1) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //���� Ǯ�� ��
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }
      //���� ���ϸ��� Ǯ�Ӽ�
      if(poke.getpType() == 2) {
         //���� ���� ��
         if(user.getUp_list().get(0).getpType() == 1) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //���� Ǯ�� ��
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }      
   }
   
   
   






   //���ϸ� ĳġ ���
   public void catchP(User user) {

      for(int i=0; i<user.getUi_list().size(); i++) {
         if(user.getUi_list().get(i).getiType() == 0) {

         }
      }
   }

   public void selectS() {

   }



}