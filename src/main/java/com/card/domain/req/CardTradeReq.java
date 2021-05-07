package com.card.domain.req;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qinghong.zhu on 2021/4/30.
 *
 * @author qinghong.zhu
 */
@Setter
@Getter
public class CardTradeReq {
    /**
     * 卡号
     */
    public Integer cardNumber;
    /**
     * 充值/消费金额
     */
    public Integer amount;

    /**
     * 卡片交易类型 充值/消费
     */
    public String type;

    /**
     * 交易详情
     */
    public String detail;

    /**
     * 一卡通密码
     */
    public String cardPassword;

}
