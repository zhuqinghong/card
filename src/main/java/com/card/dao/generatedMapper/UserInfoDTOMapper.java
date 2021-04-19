package com.card.dao.generatedMapper;

import com.card.dao.dto.UserInfoDTO;
import com.card.dao.dto.UserInfoDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserInfoDTOMapper {
    int countByExample(UserInfoDTOExample example);

    int deleteByExample(UserInfoDTOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfoDTO record);

    int insertSelective(UserInfoDTO record);

    List<UserInfoDTO> selectByExampleWithRowbounds(UserInfoDTOExample example, RowBounds rowBounds);

    List<UserInfoDTO> selectByExample(UserInfoDTOExample example);

    UserInfoDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserInfoDTO record, @Param("example") UserInfoDTOExample example);

    int updateByExample(@Param("record") UserInfoDTO record, @Param("example") UserInfoDTOExample example);

    int updateByPrimaryKeySelective(UserInfoDTO record);

    int updateByPrimaryKey(UserInfoDTO record);
}