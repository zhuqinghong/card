package com.card.dao.extendMapper;

import java.util.List;

import com.card.dao.dto.CardInfoDTO;
import com.card.domain.req.QueryCardInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qinghong.zhu on 2021/4/25.
 *
 * @author qinghong.zhu
 */
public interface CardInfoDTOExtendMapper {

    List<CardInfoDTO> queryCardInfoByCondition(@Param("queryCardInfoReq") QueryCardInfoReq queryCardInfoReq);

}
