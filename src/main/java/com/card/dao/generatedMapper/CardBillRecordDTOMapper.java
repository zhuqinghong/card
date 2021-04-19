package com.card.dao.generatedMapper;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.dao.dto.CardBillRecordDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardBillRecordDTOMapper {
    int countByExample(CardBillRecordDTOExample example);

    int deleteByExample(CardBillRecordDTOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardBillRecordDTO record);

    int insertSelective(CardBillRecordDTO record);

    List<CardBillRecordDTO> selectByExampleWithRowbounds(CardBillRecordDTOExample example, RowBounds rowBounds);

    List<CardBillRecordDTO> selectByExample(CardBillRecordDTOExample example);

    CardBillRecordDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardBillRecordDTO record, @Param("example") CardBillRecordDTOExample example);

    int updateByExample(@Param("record") CardBillRecordDTO record, @Param("example") CardBillRecordDTOExample example);

    int updateByPrimaryKeySelective(CardBillRecordDTO record);

    int updateByPrimaryKey(CardBillRecordDTO record);
}