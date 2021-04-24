package com.card.dao.extendMapper;

import java.util.List;

import com.card.dao.dto.UserInfoDTO;
import com.card.domain.req.QueryUserInfoReq;
import org.apache.ibatis.annotations.Param;

/**
 * Created by qinghong.zhu on 2021/4/22.
 *
 * @author qinghong.zhu
 */
public interface UserInfoDTOExtendMapper {

    List<UserInfoDTO> queryUserInfoByCondition(@Param("queryUserInfoReq") QueryUserInfoReq queryUserInfoReq);
}
