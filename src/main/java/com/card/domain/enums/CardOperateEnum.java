package com.card.domain.enums;

/**
 * Created by qinghong.zhu on 2021/4/28.
 *
 * @author qinghong.zhu
 */
public enum CardOperateEnum {
    UPDATE_CARD("更新卡片信息"),
    ACTIVE_CARD("激活卡片"),
    MISSING_CARD("挂失卡片"),
    SUSPEND_CARD("锁定卡片"),
    DELETED_CARD("删除卡片"),
    RE_PASSWORD("重置密码");

    public String desc;

    CardOperateEnum(String desc) {
        this.desc = desc;
    }

    public static String getDesc(String cardOperateEnum) {
        return valueOf(cardOperateEnum).desc;
    }
}
