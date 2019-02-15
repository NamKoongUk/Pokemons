package view;

import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.vo.User;


public class BattlePage extends JPanel {
   private JPanel bp;
   private MainFrame mf;
   private Map m;
   private BattleSkillPage bsp;
   private PInfoPage pip;
   private JPanel uivp;
   private User user;

   //버튼 이미지 올리기
   private Image fightButtonImage = new ImageIcon("images/싸운다버튼.png").getImage();
   private Image changeButtonImage = new ImageIcon("images/포켓몬버튼.png").getImage();
   private Image invenButtonImage = new ImageIcon("images/가방버튼.png").getImage();
   private Image runButtonImage = new ImageIcon("images/도망간다버튼.png").getImage();
   private JButton mes = new JButton("도망칠 수 없다.  싸워라.");
   private Dialog blockrun = new Dialog(mf);



   //삭제할 백버튼
   private Image backButtonImage = new ImageIcon("images/back.png").getImage();
   private JButton backButton = new JButton(new ImageIcon(backButtonImage));

   //이미지 버튼화
   private JButton fightButton = new JButton(new ImageIcon(fightButtonImage));
   private JButton changeButton = new JButton(new ImageIcon(changeButtonImage));
   private JButton invenButton = new JButton(new ImageIcon(invenButtonImage));
   private JButton runButton = new JButton(new ImageIcon(runButtonImage));

   //Graphics
   //전투 배경 이미지
   Image background = Toolkit.getDefaultToolkit().getImage("images/background1.PNG");
   //내 포켓몬 이미지
   Image mypokemon = Toolkit.getDefaultToolkit().getImage("images/pikachu.PNG");
   //적 포켓몬 이미지
   Image enpokemon =  Toolkit.getDefaultToolkit().getImage("images/kkobugi.PNG");


   public BattlePage(MainFrame mf, JPanel panel, User user) {
      this.bp = this;
      this.mf = mf;
      this.m = (Map)panel;
      this.pip = new PInfoPage(mf,this,user);
      this.bsp = new BattleSkillPage(mf, this);
      this.user = user;

      //버튼을 맘대로 배치하기 위해
      bp.setLayout(null);
      //this.pip = new PInfoPage(mf, this);


      fightButton.setBounds(180, 500, 300, 80);
      this.add(fightButton);
      settingButton(fightButton);
      fightButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            bp.setVisible(false);
            bsp.setVisible(true);
            mf.add(bsp);
         }
      });
      this.add(fightButton);


      changeButton.setBounds(550, 500, 300, 80);
      settingButton(changeButton);
      changeButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            bp.setVisible(false);
            mf.add(pip);
         }
      });
      this.add(changeButton);



      invenButton.setBounds(180, 600, 300, 80);
      settingButton(invenButton);
      invenButton.addMouseListener(new MouseAdapter() {

         @Override
         public void mousePressed(MouseEvent e) {
            bp.setVisible(false);
            uivp.setVisible(true);   
            mf.add(uivp);

         }
      });
      this.add(invenButton);


      //m.setNum(4);
      if(m.getNum() == 4) {
         runButton.setBounds(550, 600, 300, 80);
         settingButton(runButton);
         runButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               blockrun.setBounds(600, 300, 200, 100 );
               blockrun.add(mes);

               blockrun.setVisible(true);

            }
         });
         this.add(runButton);      

         //다이얼로그 메세지 클릭시 이벤트
         settingButton(mes);
         mes.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               blockrun.dispose();

            }
         });
         this.add(mes);      
      }else {
         runButton.setBounds(550, 600, 300, 80);
         settingButton(runButton);
         runButton.setBorderPainted(false);
         runButton.setFocusPainted(false);
         runButton.setContentAreaFilled(false);
         runButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               mf.remove(bp);
               m.setVisible(true);
               mf.requestFocus();
               //((Map) m).start();
            }
         });
         this.add(runButton);
      }
      //삭제할 이벤트
      backButton.setBounds(780, 650, 300, 80);
      settingButton(backButton);
      backButton.setBorderPainted(false);
      backButton.setFocusPainted(false);
      backButton.setContentAreaFilled(false);
      backButton.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
         }
         @Override
         public void mouseExited(MouseEvent e) {
         }
         @Override
         public void mousePressed(MouseEvent e) {
            mf.remove(bp);
            m.setVisible(true);
            mf.requestFocus();
            //((Map) m).start();
         }
      });
      this.add(backButton);   
   }


   //라벨 대신 배경, 포켓몬 불러오는 그래픽스
   public void paintComponent(Graphics g) {
      g.drawImage(background, 0, 0, 1024, 768, this);
      g.drawImage(mypokemon, 210, 150, 250, 250, this);
      g.drawImage(enpokemon, 570, 150, 250, 250, this);
   }


   public void settingButton(JButton jb) {
      jb.setBorderPainted(false);
      jb.setFocusPainted(false);
      jb.setContentAreaFilled(false);
   }


}
