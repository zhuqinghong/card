package com.card.domain.enums;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
public enum CardTradeEnum {
    CHARGE("充值"),
    CONSUMING("消费");

    public String desc;

    CardTradeEnum(String desc) {
        this.desc = desc;
    }

    public static String getDesc(String cardTradeEnum) {
        return valueOf(cardTradeEnum).desc;
    }
}
