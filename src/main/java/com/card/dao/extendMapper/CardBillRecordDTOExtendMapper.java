package com.card.dao.extendMapper;

import java.util.List;

import com.card.dao.dto.CardBillRecordDTO;
import com.card.domain.req.QueryCardBillLogReq;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qinghong.zhu on 2021/4/30.
 *
 * @author qinghong.zhu
 */
public interface CardBillRecordDTOExtendMapper {

    List<CardBillRecordDTO> queryByCondition(@Param("queryCardBillLogReq") QueryCardBillLogReq queryCardBillLogReq);
}
