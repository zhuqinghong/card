package com.card.domain.entity;

import java.util.Date;

/**
 * Created by qinghong.zhu on 2021/4/18.
 *
 * @author qinghong.zhu
 */
public class UserCard {
    private Integer id;

    private Integer cardNumber;

    private String cardPassword;

    private Integer cardStatus;

    private Integer cardType;

    private Integer name;

    private Date birth;

    private Short sex;

    private Integer phone;

    private Integer department;

    private Integer payAccountNumber;

    private String identityCard;

    public UserCard(UserAccountDTO userAccountDTO){
        this.id = userAccountDTO.getId();
        this.cardNumber = userAccountDTO.getCardNumber();
        this.cardPassword = userAccountDTO.getCardPassword();
        this.cardStatus = userAccountDTO.getCardStatus();
        this.cardType = userAccountDTO.getCardType();
        this.name = userAccountDTO.getName();
        this.birth = userAccountDTO.getBirth();
        this.sex = userAccountDTO.getSex();
        this.phone = userAccountDTO.getPhone();
        this.department = userAccountDTO.getDepartment();
        this.payAccountNumber = userAccountDTO.getPayAccountNumber();
        this.identityCard = userAccountDTO.getIdentityCard();
    }

   public boolean checkOutPassword(String password){
        return true;
    }

    public boolean isAdmin(){
      return false;
    }

}
