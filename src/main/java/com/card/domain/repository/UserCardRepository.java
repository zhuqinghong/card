package com.card.domain.repository;

import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserCard;
import com.card.domain.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by qinghong.zhu on 2021/4/18.
 *
 * @author qinghong.zhu
 */
@Repository
public class UserCardRepository {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private CardInfoRepository cardInfoRepository;

    /**
     * 根据用户id获取用户一卡通实体
     */
    public UserCard getUserCardByUserId(int userId) {
        UserInfo userInfo = userInfoRepository.getUserInfoById(userId);
        CardInfo cardInfo = cardInfoRepository.findCardByUserId(userId);
        return userInfo != null && cardInfo != null ? new UserCard(userInfo, cardInfo) : null;
    }

    /**
     * 根据用户Id 删除用户信息 卡片信息
     */
    public void deleteUserCardByUserId(int userId) {
        userInfoRepository.deleteUserInfoByUserId(userId);
        cardInfoRepository.deleteCardInfoByUserId(userId);
    }
}
