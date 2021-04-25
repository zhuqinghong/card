package com.card.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.card.dao.dto.UserInfoDTO;
import com.card.dao.extendMapper.UserInfoDTOExtendMapper;
import com.card.dao.generatedMapper.UserInfoDTOMapper;
import com.card.domain.entity.UserInfo;
import com.card.domain.req.CreateOrUpdateUserReq;
import com.card.domain.req.QueryUserInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by qinghong.zhu on 2021/4/20.
 *
 * @author qinghong.zhu
 */
@Repository
public class UserInfoRepository {
    @Autowired
    private UserInfoDTOMapper userInfoDTOMapper;
    @Autowired
    private UserInfoDTOExtendMapper userInfoDTOExtendMapper;

    /**
     * 根据用户id 查询 用户信息
     */
    public UserInfo getUserInfoById(Integer userId) {
        UserInfoDTO userInfoDTO = userInfoDTOMapper.selectByPrimaryKey(userId);
        return userInfoDTO != null ? new UserInfo(userInfoDTO) : null;
    }

    /**
     * 根据条件查询用户信息
     */
    public List<UserInfo> queryUserInfoByCondition(QueryUserInfoReq queryUserInfoReq) {
        List<UserInfoDTO> userInfoDTOList = userInfoDTOExtendMapper.queryUserInfoByCondition(queryUserInfoReq);
        return userInfoDTOList.stream().map(UserInfo::new).collect(Collectors.toList());
    }

    /**
     * 根据用户ID删除用户信息
     */
    public void deleteUserInfoByUserId(Integer userId) {
        userInfoDTOMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 更新用户信息
     */
    public void updateUserInfo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        UserInfo userInfo = getUserInfoById(createOrUpdateUserReq.id);
        userInfo.updateUserInfo(createOrUpdateUserReq);
        UserInfoDTO userInfoDTO = userInfo.getUserInfoDTO();
        userInfoDTOMapper.updateByPrimaryKeySelective(userInfoDTO);
    }

    /**
     * 创建用户
     */
    public UserInfo createUserInfo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName(createOrUpdateUserReq.name);
        userInfoDTO.setBirth(createOrUpdateUserReq.birth);
        userInfoDTO.setSex(createOrUpdateUserReq.sex);
        userInfoDTO.setPhone(createOrUpdateUserReq.phone);
        userInfoDTO.setDepartment(createOrUpdateUserReq.department);
        userInfoDTO.setPayAccountNumber(createOrUpdateUserReq.payAccountNumber);
        userInfoDTO.setIdentityCard(createOrUpdateUserReq.identityCard);
        userInfoDTOMapper.insertSelective(userInfoDTO);
        return new UserInfo(userInfoDTO);
    }

    public void saveUserInfo(UserInfo userInfo) {
        userInfoDTOMapper.updateByPrimaryKeySelective(userInfo.getUserInfoDTO());
    }
}
