package com.card.domain.repository;

import java.util.List;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.dao.extendMapper.CardBillRecordDTOExtendMapper;
import com.card.dao.generatedMapper.CardBillRecordDTOMapper;
import com.card.domain.req.QueryCardBillLogReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by qinghong.zhu on 2021/4/30.
 *
 * @author qinghong.zhu
 */
@Repository
public class CardBillRecordRepository {
    @Autowired
    private CardBillRecordDTOMapper cardBillRecordDTOMapper;
    @Autowired
    private CardBillRecordDTOExtendMapper cardBillRecordDTOExtendMapper;

    /**
     * 创建消费流水
     */
    public void addCardBillRecord(CardBillRecordDTO cardBillRecordDTO) {
        cardBillRecordDTOMapper.insertSelective(cardBillRecordDTO);
    }

    /**
     * 根据条件查询账单流水
     */
    public List<CardBillRecordDTO> queryByCondition(QueryCardBillLogReq queryCardBillLogReq) {
        return cardBillRecordDTOExtendMapper.queryByCondition(queryCardBillLogReq);
    }

    /**
     * 删除流水
     */
    public void delCardBillRecord(int id) {
        cardBillRecordDTOMapper.deleteByPrimaryKey(id);
    }
}
