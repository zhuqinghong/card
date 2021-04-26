package com.card.domain.service;

import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserCard;
import com.card.domain.entity.UserInfo;
import com.card.domain.req.CreateOrUpdateUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
@Service
public class UserCardService {
    @Autowired
    private UserService userService;
    @Autowired
    private CardService cardService;

    /**
     * 1.创建用户 2.创建卡片 3.下发卡片
     */
    @Transactional(rollbackFor = Exception.class)
    public UserCard createUserInfoAndCard(CreateOrUpdateUserReq createOrUpdateUserReq) {
        // 创建用户
        UserInfo userInfo = userService.createUserInfo(createOrUpdateUserReq);
        // 创建卡片
        CardInfo cardInfo = cardService.createCardInfo(createOrUpdateUserReq, userInfo);
        // 下发卡片
        return giveCardToUser(userInfo, cardInfo);
    }

    /**
     * 下发卡片给用户
     */
    @Transactional(rollbackFor = Exception.class)
    public UserCard giveCardToUser(UserInfo userInfo, CardInfo cardInfo) {
        userInfo.receiveCard(cardInfo.getCardNumber());
        cardInfo.sendCard(userInfo.getId());
        userService.saveUserInfo(userInfo);
        cardService.saveCardInfo(cardInfo);
        return new UserCard(userInfo, cardInfo);
    }

    /**
     * 查询UserCard
     */
    public UserCard findUserCardByUserId(Integer userId) {
        UserInfo userInfo = userService.getUserInfoById(userId);
        CardInfo cardInfo = cardService.findCardByNumber(userInfo.getCardNumber());
        return new UserCard(userInfo, cardInfo);
    }

    /**
     * 删除用户和卡片
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserCard(int userId, int operatorId) {
        userService.deleteUserInfoByUserId(userId);
        cardService.deleteCardInfoByUserId(userId, operatorId);
    }

}
