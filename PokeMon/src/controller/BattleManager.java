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
   private Pokemon poke;     //랜덤 포켓몬
   private Pokemon mypoke;   //내 포켓몬
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
   

   //현재 포켓몬 보여주는 부분
   public void showP(PInfoPage pip, User user) {

	   
	   user.getUp_list().set(0, new Pokemon());
	   
      this.pip = pip;
      

      JTextArea[] jta = new JTextArea[4];
      JLabel[] jl = new JLabel[4];
      

      for(int i=0; i<4; i++) {
    	  
    	  if(user.getUp_list().get(i) == null) {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
    		  jta[i].setText("\t포켓몬 이름 : "+ " " + "\n"
   	               +"\t레    벨 : " + " " + "\n"
   	               +"\t등    급 : " + " " + "\n"
   	               +"\t스 피 드 : " + " " + "\n"
   	               +"\t체    력  : " +" " + "\n");
   	         jta[i].setEditable(false);
    		  jl[i].setIcon(new ImageIcon("images/userMenuImages/pInfo4.png"));
    	  }else {
    		  jl[i] = new JLabel();
        	  jta[i] = new JTextArea();
        	  
    	         num = user.getUp_list().get(i).getpNo();
    	         jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+num+".png"));


    	         jta[i].setText("\t포켓몬 이름 : "+ user.getUp_list().get(i).getpName() + "\n"
    	               +"\t레    벨 : " + user.getUp_list().get(i).getpLevel() + "\n"
    	               +"\t등    급 : " + user.getUp_list().get(i).getGrade() + "\n"
    	               +"\t스 피 드 : " + user.getUp_list().get(i).getpSpeed() + "\n"
    	               +"\t체    력  : " +user.getUp_list().get(i).getpHp() + "\n");
    	         jta[i].setEditable(false);
    	  }
    	
         
        

      }

      pip.setpInfoText(jta);
      pip.setpInfo(jl);

   }
   
   
   
   public void showS() {

   }


   //포켓몬 생성 기능
   public void randomP(User user) {

	   //System.out.println(user.getuName());
	   
      int randomIndex = new Random().nextInt(3);
      int randomLevel = new Random().nextInt(10)+1;
      user.getEp_list().set(0, pd.getpList().get(randomIndex));


      //포켓몬 속성 정의
      user.getEp_list().get(0).setpLevel(randomLevel);
      user.getEp_list().get(0).setExp(randomLevel);
      user.getEp_list().get(0).setpHp(randomLevel);
      user.getEp_list().get(0).setpSpeed(randomLevel);
      user.getEp_list().get(0).setExp(randomLevel);
      
   
      
      //포켓몬 스킬 정의
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
      System.out.println("배틀");
      if(mypoke.getpSpeed()>poke.getpSpeed()) {
         atkMP();
         atkEP(user);
      }else {
         atkEP(user);
         atkMP();
      }
   }
   

   //내 포켓몬이 공격
   public void atkMP() {



   }

   //상대 포켓몬이 공격
   public void atkEP(User user) {
      
      int random = new Random().nextInt(4);
      //랜덤 포켓몬이 노말
      if(poke.getpType() == 0 ) {
         user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(user.getUp_list().get(0).getpHp());
      }
      if(poke.getpType() == user.getUp_list().get(0).getpType()) {
    	  user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(user.getUp_list().get(0).getpHp());
      }
      //랜덤 포켓몬이 불속성
      if(poke.getpType() == 1) {
         //내가 물일 때
         if(user.getUp_list().get(0).getpType() == 2) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //내가 풀일 때
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }
      //랜덤 포켓몬이 물속성
      if(poke.getpType() == 2) {
         //내가 불일 때
         if(user.getUp_list().get(0).getpType() == 1) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //내가 풀일 때
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }
      //랜덤 포켓몬이 풀속성
      if(poke.getpType() == 2) {
         //내가 불일 때
         if(user.getUp_list().get(0).getpType() == 1) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
         //내가 풀일 때
         if(user.getUp_list().get(0).getpType() == 3) {
        	 user.getUp_list().get(0).setpHp(user.getUp_list().get(0).getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(user.getUp_list().get(0).getpHp());
         }
      }      
   }
   
   
   






   //포켓몬 캐치 기능
   public void catchP(User user) {

      for(int i=0; i<user.getUi_list().size(); i++) {
         if(user.getUi_list().get(i).getiType() == 0) {

         }
      }
   }

   public void selectS() {

   }



}