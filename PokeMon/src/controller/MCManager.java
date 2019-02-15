package controller;

import java.util.Date;

import model.dao.ItemDao;
import model.dao.UserDao;
import model.vo.User;

//센터
//체력회복
public class MCManager {
   //마켓
   //구매수량체크->소유금액체크->구매가능여부 체크
   private String resultNo;
   private User user;
   private ItemDao id = new ItemDao(); 
   
   public void useMarket(String iName, int iAmount, User user) {
      this.user = user;
      //->MarketView에서 쓸 것
      //최소수량, 최대수량
      
      int check = 0;//구매 하고 싶은 아이템의 총 가격
      
      ItemManager im = new ItemManager();
      resultNo=null;
      for(int i=0 ; i<id.getIList().size() ; i++) {
         //아이템 고른 것을 비교하여 아이템리스트의 몇번째 인덱스에 있는 지 확인
         if(id.getIList().get(i).getiName().equals(iName)) {
            //구매 하고 싶은 아이템의 총 금액
            check=(id.getIList().get(i).getiPrice()) * iAmount;
            //유저인벤에 있는 소지금액과 비교 후   
            //소지금액<check : 소지금액이 적어 구매가 불가능 합니다 출력 : MarketView에서 바로 출력함
            if(iAmount > 100) {
               //구매 불가
               resultNo="최대 구매 수량은 100개 입니다.";
            }else if(iAmount < 1){
               resultNo="최소 구매 수량은 1개 입니다.";
            }else if(user.getuGold() < check){
               resultNo="골드가 부족합니다.";
            }else {
               
            	//user.setuGold(/*ud.getUserList().get(0)*/user.getuGold() - check);
               
               //구매 가능
               //중복 아이템이 있으면 수량을 증가시켜야
               //System.out.println("아이템 : "+itemName+", 수량 : "+itemAmount);
               im.decreaseGold(check,user);
            }
            //소지금액>check : 구매 가능 : itemManager 로 구매 목록과 구매총액을 보내줌
         }
      }
      
      
   }
   public String getResultNo() {
      return resultNo;
   }
   public void setResultNo(String resultNo) {
      this.resultNo = resultNo;
   }
   public void useCenter() {
      //회복 시켜주기
	   System.out.println(user);
      
   }

}