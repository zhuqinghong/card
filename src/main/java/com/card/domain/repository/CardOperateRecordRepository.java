package com.card.domain.repository;

import java.util.List;

import com.card.dao.dto.CardOperateRecordDTO;
import com.card.dao.extendMapper.CardOperateRecordDTOExtendMapper;
import com.card.dao.generatedMapper.CardOperateRecordDTOMapper;
import com.card.domain.req.QueryCardOperateLogReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
@Repository
public class CardOperateRecordRepository {
    @Autowired
    private CardOperateRecordDTOMapper cardOperateRecordDTOMapper;
    @Autowired
    private CardOperateRecordDTOExtendMapper cardOperateRecordDTOExtendMapper;

    /**
     * 根据日志id删除日志
     */
    public void deleteRecord(Integer id) {
        cardOperateRecordDTOMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据条件查询日志
     */
    public List<CardOperateRecordDTO> queryByCondition(QueryCardOperateLogReq queryCardOperateLogReq) {
        return cardOperateRecordDTOExtendMapper.queryByCondition(queryCardOperateLogReq);
    }
}
