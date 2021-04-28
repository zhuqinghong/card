package com.card.domain.req;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
public class QueryCardOperateLogReq {
    /**
     * 一卡通卡号
     */
    public Integer cardNumber;

    /**
     * 操作类型
     */
    public String cardOperateEnum;

    /**
     * 操作人
     */
    public Integer operateId;

}
