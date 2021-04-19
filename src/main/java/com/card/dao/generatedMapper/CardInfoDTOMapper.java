package com.card.dao.generatedMapper;

import com.card.dao.dto.CardInfoDTO;
import com.card.dao.dto.CardInfoDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CardInfoDTOMapper {
    int countByExample(CardInfoDTOExample example);

    int deleteByExample(CardInfoDTOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CardInfoDTO record);

    int insertSelective(CardInfoDTO record);

    List<CardInfoDTO> selectByExampleWithRowbounds(CardInfoDTOExample example, RowBounds rowBounds);

    List<CardInfoDTO> selectByExample(CardInfoDTOExample example);

    CardInfoDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CardInfoDTO record, @Param("example") CardInfoDTOExample example);

    int updateByExample(@Param("record") CardInfoDTO record, @Param("example") CardInfoDTOExample example);

    int updateByPrimaryKeySelective(CardInfoDTO record);

    int updateByPrimaryKey(CardInfoDTO record);
}