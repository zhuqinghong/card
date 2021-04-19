CREATE TABLE `user_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `card_number` int(11) DEFAULT NULL COMMENT '一卡通卡号',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `birth` datetime DEFAULT NULL COMMENT '生日',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `phone` int(11) DEFAULT NULL COMMENT '手机号',
  `department` varchar(20) DEFAULT NULL COMMENT '专业',
  `pay_account_number` int(11) DEFAULT NULL COMMENT '银行卡',
  `identity_card` char(11) DEFAULT NULL COMMENT '身份证号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户信息表';


CREATE TABLE `card_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `card_number` int(11) NOT NULL COMMENT '一卡通账号',
  `card_password` varchar(10) NOT NULL DEFAULT '' COMMENT '一卡通密码',
  `card_status` varchar(20) DEFAULT NULL COMMENT '卡片状态、挂失、补办、锁定、激活、注销卡片',
  `card_type` varchar(20) DEFAULT NULL COMMENT '卡片类型 admin、system user',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `balance` int(11) DEFAULT NULL COMMENT '账户余额',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发卡日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='一卡通信息表';

CREATE TABLE `card_bill_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `card_number` int(11) DEFAULT NULL COMMENT '一卡通卡号',
  `amount` int(11) DEFAULT NULL COMMENT '金额',
  `type` varchar(20) DEFAULT NULL COMMENT '流水类型',
  `after_amount` int(11) DEFAULT NULL COMMENT '账户余额',
  `detail` varchar(20) DEFAULT NULL COMMENT '流水详情',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '消费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='一卡通充值/消费流水';

CREATE TABLE `card_operate_record` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `card_number` int(11) DEFAULT NULL COMMENT '一卡通卡号',
  `operator_id` int(11) DEFAULT NULL COMMENT '操作用户id',
  `type` varchar(20) DEFAULT NULL COMMENT '操作类型',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='一卡通操作日志';
