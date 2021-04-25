package com.card.domain.req;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
@Getter
@Setter
public class QueryCardInfoReq {
    /**
     * 一卡通卡号
     */
    public int cardNumber;

    /**
     * 一卡通状态
     */
    public String cardStatus;

    /**
     * 卡片类型
     */
    public String cardType;

    /**
     * 一卡通用户id
     */
    public int userId;
}
