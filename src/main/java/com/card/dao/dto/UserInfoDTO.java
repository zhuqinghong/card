package com.card.dao.dto;

import java.io.Serializable;
import java.util.Date;

public class UserInfoDTO implements Serializable {
    private Integer id;

    private Integer cardNumber;

    private String name;

    private Date birth;

    private String sex;

    private Integer phone;

    private String department;

    private Integer payAccountNumber;

    private String identityCard;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public Integer getPayAccountNumber() {
        return payAccountNumber;
    }

    public void setPayAccountNumber(Integer payAccountNumber) {
        this.payAccountNumber = payAccountNumber;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard == null ? null : identityCard.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cardNumber=").append(cardNumber);
        sb.append(", name=").append(name);
        sb.append(", birth=").append(birth);
        sb.append(", sex=").append(sex);
        sb.append(", phone=").append(phone);
        sb.append(", department=").append(department);
        sb.append(", payAccountNumber=").append(payAccountNumber);
        sb.append(", identityCard=").append(identityCard);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}