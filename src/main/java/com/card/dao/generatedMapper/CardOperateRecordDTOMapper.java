package com.card.dao.generatedMapper;

import com.card.dao.dto.CardOperateRecordDTO;
import com.card.dao.dto.CardOperateRecordDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardOperateRecordDTOMapper {
    int countByExample(CardOperateRecordDTOExample example);

    int deleteByExample(CardOperateRecordDTOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardOperateRecordDTO record);

    int insertSelective(CardOperateRecordDTO record);

    List<CardOperateRecordDTO> selectByExampleWithRowbounds(CardOperateRecordDTOExample example, RowBounds rowBounds);

    List<CardOperateRecordDTO> selectByExample(CardOperateRecordDTOExample example);

    CardOperateRecordDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardOperateRecordDTO record, @Param("example") CardOperateRecordDTOExample example);

    int updateByExample(@Param("record") CardOperateRecordDTO record, @Param("example") CardOperateRecordDTOExample example);

    int updateByPrimaryKeySelective(CardOperateRecordDTO record);

    int updateByPrimaryKey(CardOperateRecordDTO record);
}