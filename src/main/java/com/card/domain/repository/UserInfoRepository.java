package com.card.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.card.dao.dto.CardInfoDTO;
import com.card.dao.dto.UserInfoDTO;
import com.card.dao.extendMapper.UserInfoDTOExtendMapper;
import com.card.dao.generatedMapper.CardInfoDTOMapper;
import com.card.dao.generatedMapper.UserInfoDTOMapper;
import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserCard;
import com.card.domain.entity.UserInfo;
import com.card.domain.enums.CardStatusEnum;
import com.card.domain.enums.CardTypeEnum;
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
    @Autowired
    private CardInfoDTOMapper cardInfoDTOMapper;

    /**
     * 创建用户，创建卡片，并建立关联关系
     */
    public UserCard createUserInfoAndCard(CreateOrUpdateUserReq createOrUpdateUserReq) {
        // 创建用户
        UserInfoDTO userInfoDTO = createUserInfo(createOrUpdateUserReq);
        // 创建卡片
        CardInfoDTO cardInfoDTO = createCardInfo(createOrUpdateUserReq, userInfoDTO);
        // 用户信息中冗余卡片号
        userInfoDTO.setCardNumber(cardInfoDTO.getCardNumber());
        userInfoDTOMapper.updateByPrimaryKeySelective(userInfoDTO);
        return new UserCard(new UserInfo(userInfoDTO), new CardInfo(cardInfoDTO));
    }

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
    private UserInfoDTO createUserInfo(CreateOrUpdateUserReq createOrUpdateUserReq) {
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        //userInfoDTO.setId();
        //userInfoDTO.setCardNumber();
        userInfoDTO.setName(createOrUpdateUserReq.name);
        userInfoDTO.setBirth(createOrUpdateUserReq.birth);
        userInfoDTO.setSex(createOrUpdateUserReq.sex);
        userInfoDTO.setPhone(createOrUpdateUserReq.phone);
        userInfoDTO.setDepartment(createOrUpdateUserReq.department);
        userInfoDTO.setPayAccountNumber(createOrUpdateUserReq.payAccountNumber);
        userInfoDTO.setIdentityCard(createOrUpdateUserReq.identityCard);
        //userInfoDTO.setCreateTime();
        userInfoDTOMapper.insertSelective(userInfoDTO);
        return userInfoDTO;
    }

    /**
     * 创建用户卡片
     */
    private CardInfoDTO createCardInfo(CreateOrUpdateUserReq createOrUpdateUserReq, UserInfoDTO userInfoDTO) {
        CardInfoDTO cardInfoDTO = new CardInfoDTO();
        //cardInfoDTO.setCardNumber();
        cardInfoDTO.setCardPassword(createOrUpdateUserReq.cardPassword);
        cardInfoDTO.setCardStatus(CardStatusEnum.INIT.name());
        cardInfoDTO.setCardType(CardTypeEnum.SYSTEM_USER.name());
        cardInfoDTO.setUserId(userInfoDTO.getId());
        cardInfoDTO.setBalance(0);
        //cardInfoDTO.setCreateTime();
        cardInfoDTOMapper.insertSelective(cardInfoDTO);
        return cardInfoDTO;
    }
}
