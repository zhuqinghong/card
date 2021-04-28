package com.card.domain.enums;

/**
 * Created by qinghong.zhu on 2021/4/20. 卡片类型
 *
 * @author qinghong.zhu
 */
public enum CardTypeEnum {
    ADMIN("管理员"),
    SYSTEM_USER("系统用户");
    public String desc;

    CardTypeEnum(String desc) {
        this.desc = desc;
    }

    public boolean isAdmin() {
        return this.equals(ADMIN);
    }

    public String getDesc() {
        return this.desc;
    }
}
