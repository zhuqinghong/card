package com.card.domain.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户卡片领域实体
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
