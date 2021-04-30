package com.card.domain.req;

/**
 * Created by qinghong.zhu on 2021/4/30.
 *
 * @author qinghong.zhu
 */
public class CardTradeReq {
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

}
