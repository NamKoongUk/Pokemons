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

   
   

   //현재 포켓몬 보여주는 부분
   public void showP(PInfoPage pip, User user) {

	   user.getUp_list().add(new Pokemon());
	   user.getUp_list().add(new Pokemon());
	   user.getUp_list().add(new Pokemon());
	   user.getUp_list().add(new Pokemon()); 
      this.pip = pip;
      
      

      JTextArea[] jta = new JTextArea[4];
      JLabel[] jl = new JLabel[4];

      for(int i=0; i<user.getUp_list().size(); i++) {
         
    	  if(user.getUp_list().get(i) ==null) {
    		  
    	  }else {
    		  
    		  jl[i] = new JLabel();
    	         num = user.getUp_list().get(i).getpNo();
    	         jl[i].setIcon(new ImageIcon("images/userMenuImages/pBook/"+num+".png"));


    	         jta[i] = new JTextArea();
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
   public static void showS() {

   }


   //포켓몬 생성 기능
   public void randomP() {

      int randomIndex = new Random().nextInt(4);
      int randomLevel = new Random().nextInt(10)+1;
      poke = pd.getpList().get(randomIndex);


      //포켓몬 속성 정의
      poke.setpLevel(randomLevel);
      poke.setExp(randomLevel);
      poke.setpHp(randomLevel);
      poke.setpSpeed(randomLevel);
      poke.setExp(randomLevel);

   
      
      //포켓몬 스킬 정의
      for(int i=0; i<4; i++) {
         int random = new Random().nextInt(4);
         int ctn = new Random().nextInt(2);
         if(poke.getpType() == 0) {
            poke.getpSkill().add(sd.getNs_list().get(random));
         }
         if(poke.getpType() == 1) {
            if(ctn == 0) {
               poke.getpSkill().add(sd.getNs_list().get(random));
            }else {
            poke.getpSkill().add(sd.getFs_list().get(random));
            }
         }
         if(poke.getpType() == 2) {
            if(ctn == 0) {
               poke.getpSkill().add(sd.getNs_list().get(random));
            }else {
            poke.getpSkill().add(sd.getWs_list().get(random));
            }
         }
         if(poke.getpType() == 3) {
            if(ctn == 0) {
               poke.getpSkill().add(sd.getNs_list().get(random));
            }else {
            poke.getpSkill().add(sd.getGs_list().get(random));
            }
         }
      }
      System.out.println(poke.getpName());
   }

   public void battle() {
      System.out.println("배틀");
      if(mypoke.getpSpeed()>poke.getpSpeed()) {
         atkMP();
         atkEP();
      }else {
         atkEP();
         atkMP();
      }
   }
   

   //내 포켓몬이 공격
   public void atkMP() {



   }

   //상대 포켓몬이 공격
   public void atkEP() {
      
      int random = new Random().nextInt(4);
      //랜덤 포켓몬이 노말
      if(poke.getpType() == 0 ) {
         mypoke.setpHp(mypoke.getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(mypoke.getpHp());
      }
      if(poke.getpType() == mypoke.getpType()) {
         mypoke.setpHp(mypoke.getpHp() - poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3);
         System.out.println(mypoke.getpHp());
      }
      //랜덤 포켓몬이 불속성
      if(poke.getpType() == 1) {
         //내가 물일 때
         if(mypoke.getpType() == 2) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(mypoke.getpHp());
         }
         //내가 풀일 때
         if(mypoke.getpType() == 3) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(mypoke.getpHp());
         }
      }
      //랜덤 포켓몬이 물속성
      if(poke.getpType() == 2) {
         //내가 불일 때
         if(mypoke.getpType() == 1) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(mypoke.getpHp());
         }
         //내가 풀일 때
         if(mypoke.getpType() == 3) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(mypoke.getpHp());
         }
      }
      //랜덤 포켓몬이 풀속성
      if(poke.getpType() == 2) {
         //내가 불일 때
         if(mypoke.getpType() == 1) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)/2);
            System.out.println(mypoke.getpHp());
         }
         //내가 풀일 때
         if(mypoke.getpType() == 3) {
            mypoke.setpHp(mypoke.getpHp() - (poke.getpSkill().get(random).getsAtt()+ poke.getpLevel()*3)*2);
            System.out.println(mypoke.getpHp());
         }
      }      
   }
   
   
   






   //포켓몬 캐치 기능
   public void catchP() {

      for(int i=0; i<User.getUi_list().size(); i++) {
         if(User.getUi_list().get(i).getiType() == 0) {

         }
      }
   }

   public void selectS() {

   }



}