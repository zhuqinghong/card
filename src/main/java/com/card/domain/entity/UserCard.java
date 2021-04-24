package com.card.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by qinghong.zhu on 2021/4/18.
 * 用户卡片领域实体
 * @author qinghong.zhu
 */
@Getter
@Setter
public class UserCard {
    /**
     * 用户信息
     */
    public UserInfo userInfo;
    /**
     * 卡片信息
     */
    public CardInfo cardInfo;

    public UserCard(UserInfo userInfo, CardInfo cardInfo) {
        this.userInfo = userInfo;
        this.cardInfo = cardInfo;
    }
}
