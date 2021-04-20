package com.card.domain.repository;

import java.util.List;

import com.card.dao.dto.CardInfoDTO;
import com.card.dao.dto.CardInfoDTOExample;
import com.card.dao.generatedMapper.CardInfoDTOMapper;
import com.card.domain.entity.CardInfo;
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

    /**
     * 根据一卡通卡号查询卡片信息
     */
    public CardInfo findCardByNumber(Integer cardNumber) {
        CardInfoDTOExample example = new CardInfoDTOExample();
        example.createCriteria().andCardNumberEqualTo(cardNumber);
        List<CardInfoDTO> cardInfoDTOList = cardInfoDTOMapper.selectByExample(example);
        return CollectionUtils.isEmpty(cardInfoDTOList) ? null : new CardInfo(cardInfoDTOList.get(0));
    }
}
