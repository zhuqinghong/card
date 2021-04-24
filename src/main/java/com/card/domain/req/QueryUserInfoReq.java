package com.card.domain.req;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qinghong.zhu on 2021/4/21.
 *
 * @author qinghong.zhu
 */
@Getter
@Setter
public class QueryUserInfoReq {
    /**
     * 用户Id
     */
    public Integer id;
    /**
     * 卡号
     */
    public Integer cardNumber;
    /**
     * 用户名称
     */
    public String userName;
}
