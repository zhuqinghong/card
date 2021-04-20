package com.card.domain.entity;

/**
 * Created by qinghong.zhu on 2021/4/18.
 * 用户卡片领域实体
 * @author qinghong.zhu
 */
public class UserCard {
    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 卡片信息
     */
    private CardInfo cardInfo;

    public UserCard(UserInfo userInfo, CardInfo cardInfo) {
        this.userInfo = userInfo;
        this.cardInfo = cardInfo;
    }
}
