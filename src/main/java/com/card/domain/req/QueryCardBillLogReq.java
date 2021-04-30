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
public class QueryCardBillLogReq {
    /**
     * 账单id
     */
    public Integer id;
    /**
     * 消费卡号
     */
    public Integer cardNumber;
    /**
     * 最小消费
     */
    public Integer minAmount;
    /**
     * 最小消费
     */
    public Integer maxAmount;
    /**
     * 账单类型 充值消费
     */
    public String type;
}
