package com.card.domain.entity;

import java.util.Date;

import com.card.dao.dto.CardInfoDTO;
import com.card.domain.enums.CardTypeEnum;

/**
 * Created by qinghong.zhu on 2021/4/20. 一卡通信息
 *
 * @author qinghong.zhu
 */
public class CardInfo {
    /**
     * 一卡通卡号
     */
    private Integer cardNumber;

    /**
     * 一卡通登录查询密码
     */
    private String cardPassword;

    /**
     * 一卡通状态
     */
    private String cardStatus;

    /**
     * 卡片类型
     */
    private CardTypeEnum cardTypeEnum;

    /**
     * 一卡通用户id
     */
    private Integer userId;

    /**
     * 一卡通账户余额
     */
    private Integer balance;

    /**
     * 卡片创建日期
     */
    private Date createTime;

    public CardInfo(CardInfoDTO cardInfoDTO) {
        this.cardNumber = cardInfoDTO.getCardNumber();
        this.cardPassword = cardInfoDTO.getCardPassword();
        this.cardStatus = cardInfoDTO.getCardStatus();
        this.cardTypeEnum = CardTypeEnum.valueOf(cardInfoDTO.getCardType());
        this.userId = cardInfoDTO.getUserId();
        this.balance = cardInfoDTO.getBalance();
        this.createTime = cardInfoDTO.getCreateTime();
    }

    /**
     * 校验密码是否正确
     */
    public boolean checkOutPassword(String passwd) {
        return this.cardPassword.equals(passwd);
    }

    /**
     * 是否是管理员
     */
    public boolean isAdmin() {
        return this.cardTypeEnum.isAdmin();
    }
}
