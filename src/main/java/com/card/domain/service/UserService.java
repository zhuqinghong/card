package com.card.domain.service;

import java.util.List;

import com.card.domain.entity.UserInfo;
import com.card.domain.repository.UserInfoRepository;
import com.card.domain.req.CreateOrUpdateUserReq;
import com.card.domain.req.QueryUserInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
@Service
public class UserService {
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 根据条件查询 UserInfo
     */
    public List<UserInfo> queryUserInfoByCondition(QueryUserInfoReq queryUserInfoReq) {
        return userInfoRepository.queryUserInfoByCondition(queryUserInfoReq);
    }

    /**
     * 创建用户，创建卡片，并建立关联关系
     */
    public UserInfo createUserInfo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        return userInfoRepository.createUserInfo(createOrUpdateUserReq);
    }

    /**
     * 保存用户信息
     */
    public void saveUserInfo(UserInfo userInfo) {
        userInfoRepository.saveUserInfo(userInfo);
    }

    /**
     * 更新用户信息
     */
    public void updateUserInfo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        userInfoRepository.updateUserInfo(createOrUpdateUserReq);
    }

    /**
     * 根据用户id 查询 用户信息
     */
    public UserInfo getUserInfoById(Integer userId) {
        return userInfoRepository.getUserInfoById(userId);
    }

    /**
     * 删除用户
     */
    public void deleteUserInfoByUserId(Integer userId) {
        userInfoRepository.deleteUserInfoByUserId(userId);
    }
}
