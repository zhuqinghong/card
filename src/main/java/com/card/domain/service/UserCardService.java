package com.card.domain.service;

import com.card.domain.entity.UserCard;
import com.card.domain.repository.UserCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qinghong.zhu on 2021/4/18.
 *
 * @author qinghong.zhu
 */
@Service
public class UserCardService {
    @Autowired
    private UserCardRepository userCartRepository;

    /**
     * 根据一卡通卡号获取,用户一卡通信息
     */
    public UserCard getUserCardByNumber(int cardNumber){
        return userCartRepository.getUserCardByNumber(cardNumber);
    }
}
