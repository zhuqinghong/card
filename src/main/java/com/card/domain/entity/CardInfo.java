package com.card.domain.entity;

import java.util.Date;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.dao.dto.CardInfoDTO;
import com.card.dao.dto.CardOperateRecordDTO;
import com.card.domain.enums.CardOperateEnum;
import com.card.domain.enums.CardStatusEnum;
import com.card.domain.enums.CardTypeEnum;
import com.card.domain.req.CardTradeReq;
import com.card.domain.req.CreateOrUpdateCardReq;
import lombok.Getter;

/**
 * Created by qinghong.zhu on 2021/4/20. 一卡通信息
 *
 */
@Getter
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
    /**
     * 卡片下发给用户
     */
    public void sendCard(Integer userId) {
        this.userId = userId;
    }
    /**
     * 修改卡片信息
     */
    public CardOperateRecordDTO updateCardInfo(CreateOrUpdateCardReq createOrUpdateCardReq, int operateId) {
        this.cardNumber = createOrUpdateCardReq.cardNumber;
        this.cardPassword = createOrUpdateCardReq.cardPassword;
        this.cardStatus = createOrUpdateCardReq.cardStatus;
        this.cardTypeEnum = CardTypeEnum.valueOf(createOrUpdateCardReq.cardType);
        this.balance = createOrUpdateCardReq.balance;
        return generateOperateRecord(operateId, CardOperateEnum.UPDATE_CARD.name());
    }
    /**
     * 卡片挂失
     */
    public CardOperateRecordDTO missCard(int operateId) {
        this.cardStatus = CardStatusEnum.MISSING.name();
        return generateOperateRecord(operateId, CardOperateEnum.MISSING_CARD.name());
    }
    /**
     * 卡片激活
     */
    public CardOperateRecordDTO activeCard(int operateId) {
        this.cardStatus = CardStatusEnum.ACTIVE.name();
        return generateOperateRecord(operateId, CardOperateEnum.ACTIVE_CARD.name());
    }
    /**
     * 卡片锁定
     */
    public CardOperateRecordDTO suspendCard(int operateId) {
        this.cardStatus = CardStatusEnum.SUSPEND.name();
        return generateOperateRecord(operateId, CardOperateEnum.SUSPEND_CARD.name());
    }
    /**
     * 卡片删除
     */
    public CardOperateRecordDTO deleteCard(int operateId) {
        return generateOperateRecord(operateId, CardOperateEnum.DELETED_CARD.name());
    }
    /**
     * 密码修改
     */
    public CardOperateRecordDTO rePassword(int operateId, String newCardPassword) {
        this.cardPassword = newCardPassword;
        return generateOperateRecord(operateId, CardOperateEnum.RE_PASSWORD.name());
    }
    /**
     * 卡片消费/充值
     */
    public CardBillRecordDTO trade(CardTradeReq cardTradeReq) {
        if (this.balance + cardTradeReq.amount < 0) {
            throw new RuntimeException("卡片余额不足够");
        }
        // trade
        this.balance = this.balance + cardTradeReq.amount;
        CardBillRecordDTO cardBillRecordDTO = new CardBillRecordDTO();
        cardBillRecordDTO.setCardNumber(cardNumber);
        cardBillRecordDTO.setAmount(cardTradeReq.amount);
        cardBillRecordDTO.setAfterAmount(this.balance);
        cardBillRecordDTO.setType(cardTradeReq.type);
        cardBillRecordDTO.setDetail(cardTradeReq.detail);
        return cardBillRecordDTO;
    }

    /**
     * 生成卡片操作日志
     */
    public CardOperateRecordDTO generateOperateRecord(int operateId, String type) {
        CardOperateRecordDTO cardOperateRecordDTO = new CardOperateRecordDTO();
        cardOperateRecordDTO.setCardNumber(cardNumber);
        cardOperateRecordDTO.setOperatorId(operateId);
        cardOperateRecordDTO.setType(type);
        return cardOperateRecordDTO;
    }
    /**
     * 获取卡片信息CardInfoDTO
     */
    public CardInfoDTO getCardInfoDTO() {
        CardInfoDTO cardInfoDTO = new CardInfoDTO();
        cardInfoDTO.setCardNumber(cardNumber);
        cardInfoDTO.setCardPassword(cardPassword);
        cardInfoDTO.setCardStatus(cardStatus);
        cardInfoDTO.setCardType(cardTypeEnum.name());
        cardInfoDTO.setUserId(userId);
        cardInfoDTO.setBalance(balance);
        return cardInfoDTO;
    }
}
