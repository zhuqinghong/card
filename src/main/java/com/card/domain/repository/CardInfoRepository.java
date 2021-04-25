package com.card.domain.repository;

import java.util.List;
import java.util.stream.Collectors;

import com.card.dao.dto.CardInfoDTO;
import com.card.dao.dto.CardInfoDTOExample;
import com.card.dao.extendMapper.CardInfoDTOExtendMapper;
import com.card.dao.generatedMapper.CardInfoDTOMapper;
import com.card.domain.entity.CardInfo;
import com.card.domain.entity.UserInfo;
import com.card.domain.enums.CardStatusEnum;
import com.card.domain.enums.CardTypeEnum;
import com.card.domain.req.CreateOrUpdateUserReq;
import com.card.domain.req.QueryCardInfoReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

/**
 * Created by qinghong.zhu on 2021/4/20.
 *
 * @author qinghong.zhu
 */
@Repository
public class CardInfoRepository {
    @Autowired
    private CardInfoDTOMapper cardInfoDTOMapper;
    @Autowired
    private CardInfoDTOExtendMapper cardInfoDTOExtendMapper;
    /**
     * 根据一卡通卡号查询卡片信息
     */
    public CardInfo findCardByNumber(Integer cardNumber) {
        CardInfoDTO cardInfoDTO = cardInfoDTOMapper.selectByPrimaryKey(cardNumber);
        return cardInfoDTO != null ? new CardInfo(cardInfoDTO) : null;
    }

    /**
     * 根据用户id
     */
    public CardInfo findCardByUserId(Integer userId) {
        CardInfoDTOExample example = new CardInfoDTOExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<CardInfoDTO> cardInfoDTOList = cardInfoDTOMapper.selectByExample(example);
        return CollectionUtils.isEmpty(cardInfoDTOList) ? null : new CardInfo(cardInfoDTOList.get(0));
    }

    /**
     * 根据用户id删除卡片信息
     */
    public void deleteCardInfoByUserId(Integer userId) {
        CardInfoDTOExample example = new CardInfoDTOExample();
        example.createCriteria().andUserIdEqualTo(userId);
        cardInfoDTOMapper.deleteByExample(example);
    }

    /**
     * 根据条件查询卡片信息
     */
    public List<CardInfo> queryCardInfoByCondition(QueryCardInfoReq queryCardInfoReq) {
        List<CardInfoDTO> cardInfoDTOList = cardInfoDTOExtendMapper.queryCardInfoByCondition(queryCardInfoReq);
        return cardInfoDTOList.stream().map(CardInfo::new).collect(Collectors.toList());
    }

    /**
     * 保存卡片信息
     */
    public void saveCardInfo(CardInfo cardInfo) {
        cardInfoDTOMapper.updateByPrimaryKeySelective(cardInfo.getCardInfoDTO());

    }

    public CardInfo createCardInfo(CreateOrUpdateUserReq createOrUpdateUserReq, UserInfo userInfo) {
        CardInfoDTO cardInfoDTO = new CardInfoDTO();
        cardInfoDTO.setCardPassword(createOrUpdateUserReq.cardPassword);
        cardInfoDTO.setCardStatus(CardStatusEnum.INIT.name());
        cardInfoDTO.setCardType(CardTypeEnum.SYSTEM_USER.name());
        cardInfoDTO.setUserId(userInfo.getId());
        cardInfoDTO.setBalance(0);
        cardInfoDTOMapper.insertSelective(cardInfoDTO);
        return new CardInfo(cardInfoDTO);
    }
}
