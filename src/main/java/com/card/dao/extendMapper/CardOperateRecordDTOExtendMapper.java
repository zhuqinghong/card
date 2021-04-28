package com.card.dao.extendMapper;

import java.util.List;

import com.card.dao.dto.CardOperateRecordDTO;
import com.card.domain.req.QueryCardOperateLogReq;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
public interface CardOperateRecordDTOExtendMapper {
    List<CardOperateRecordDTO> queryByCondition(@Param("queryCardOperateLogReq") QueryCardOperateLogReq queryCardOperateLogReq);
}
