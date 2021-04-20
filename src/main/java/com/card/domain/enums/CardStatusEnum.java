package com.card.domain.enums;

/**
 * Created by qinghong.zhu on 2021/4/20. 卡片状态
 *
 * @author qinghong.zhu
 */
public enum CardStatusEnum {
    INIT("初始状态: 管理员创建卡片，用户首次登陆系统自动激活，才能正常使用"),
    ACTIVE("激活状态: 可以 充值、消费、修改信息、修改密码、查看流水等一系列操作"),
    MISSING("挂失: 不能充值、消费"),
    SUSPEND("锁定: 禁止一些行为包括登陆");

    public String desc;

    CardStatusEnum(String desc) {
        this.desc = desc;
    }
}
