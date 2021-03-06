package model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.vo.Ball;
import model.vo.Item;
import model.vo.Recovery;
import model.vo.Stone;

public class ItemDao {
   
   private List<Item> iList = new ArrayList<Item>();
   
   public ItemDao() {
      /*iList.add(new Ball("마스터 볼", 0, 50, 0, 0, 70, 0));
      iList.add(new Ball("슈퍼 볼", 1, 30, 0, 0, 50, 1));
      iList.add(new Ball("몬스터 볼", 2, 10, 0, 0, 20, 2));
      iList.add(new Recovery("고급 상처약", 3, 30, 1, 0, 0, 100));
      iList.add(new Recovery("중급 상처약", 4, 20, 1, 0, 1, 50));
      iList.add(new Recovery("초급 상처약", 5, 10, 1, 0, 2, 30));
      iList.add(new Stone("화염의 돌", 6, 200, 2, 0));
      iList.add(new Stone("바다의 돌", 7, 200, 2, 0));
      iList.add(new Stone("나무의 돌", 8, 200, 2, 0));*/
	   outputItem();
   }
   
   public void inputItem() {
      try {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("item.dat", true));
         oos.writeObject(iList);
         
      } catch (IOException e) {}
   }
   
   public void outputItem() {
      
      ObjectInputStream ois;
      try {
         ois = new ObjectInputStream(new FileInputStream("item.dat"));
         iList = (List<Item>) ois.readObject();
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

   }
   
   public List<Item> getIList() {
      return iList;
   }
   
   public void setIList(List<Item> iList) {
      this.iList = iList;
   }
}