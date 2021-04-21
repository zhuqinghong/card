package com.card.domain.repository;

import com.card.dao.dto.CardInfoDTO;
import com.card.dao.generatedMapper.CardInfoDTOMapper;
import com.card.domain.entity.CardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        CardInfoDTO cardInfoDTO = cardInfoDTOMapper.selectByPrimaryKey(cardNumber);
        return cardInfoDTO != null ? new CardInfo(cardInfoDTO) : null;
    }
}
