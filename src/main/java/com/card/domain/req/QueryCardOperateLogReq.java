package com.card.domain.req;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
@Getter
@Setter
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
