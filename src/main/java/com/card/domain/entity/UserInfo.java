package com.card.domain.entity;

import java.util.Date;

import com.card.dao.dto.UserInfoDTO;

/**
 * Created by qinghong.zhu on 2021/4/20.
 * 用户信息
 * @author qinghong.zhu
 */
public class UserInfo {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 卡号
     */
    private Integer cardNumber;

    /**
     * 姓名
     */
    private String name;

    /**
     * 出生日期
     */
    private Date birth;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private Integer phone;

    /**
     * 专业
     */
    private String department;

    /**
     * 银行卡账户
     */
    private Integer payAccountNumber;

    /**
     * 身份证号
     */
    private String identityCard;

    /**
     * 创建时间
     */
    private Date createTime;

    public UserInfo(UserInfoDTO userInfoDTO) {
        this.id = userInfoDTO.getId();
        this.cardNumber = userInfoDTO.getCardNumber();
        this.name = userInfoDTO.getName();
        this.birth = userInfoDTO.getBirth();
        this.sex = userInfoDTO.getSex();
        this.phone = userInfoDTO.getPhone();
        this.department = userInfoDTO.getDepartment();
        this.payAccountNumber = userInfoDTO.getPayAccountNumber();
        this.identityCard = userInfoDTO.getIdentityCard();
        this.createTime = userInfoDTO.getCreateTime();
    }
}