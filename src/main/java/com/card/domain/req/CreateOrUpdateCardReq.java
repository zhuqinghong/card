package com.card.domain.req;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
public class CreateOrUpdateCardReq {
    /**
     * 一卡通卡号
     */
    public Integer cardNumber;

    /**
     * 一卡通登录查询密码
     */
    public String cardPassword;

    /**
     * 一卡通状态
     */
    public String cardStatus;

    /**
     * 卡片类型
     */
    public String cardType;

    /**
     * 一卡通账户余额
     */
    public Integer balance;
}
