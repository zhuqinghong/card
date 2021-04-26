package com.card.domain.req;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Created by qinghong.zhu on 2021/4/22.
 *
 * @author qinghong.zhu
 */
@Setter
@Getter
public class CreateOrUpdateUserReq {
    /**
     * 用户id
     */
    public Integer id;

    /**
     * 姓名
     */
    public String name;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date birth;

    /**
     * 性别
     */
    public String sex;

    /**
     * 手机号
     */
    public String phone;

    /**
     * 专业
     */
    public String department;

    /**
     * 银行卡账户
     */
    public String payAccountNumber;

    /**
     * 身份证号
     */
    public String identityCard;

    /**
     * 一卡通登录查询密码
     */
    public String cardPassword;

}
