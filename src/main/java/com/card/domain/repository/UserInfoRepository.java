package com.card.domain.repository;

import com.card.dao.generatedMapper.UserInfoDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by qinghong.zhu on 2021/4/20.
 *
 * @author qinghong.zhu
 */
@Repository
public class UserInfoRepository {
    @Autowired
    private UserInfoDTOMapper userInfoDTOMapper;

}
