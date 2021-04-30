<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav style="position:fixed;z-index: 999;width: 100%;background-color: #25c6fc" class="navbar navbar-default"
     role="navigation">
    <div class="container-fluid">
        <div class="navbar-header" style="margin-left: 8%;margin-right: 1%">
            <a class="navbar-brand" href="admin_main.html" style="font-family: 华文行楷; font-size: 250%; color: white; margin-left:0px">一卡通管理系统</a>
        </div>
        <div class="collapse navbar-collapse" >
            <ul class="nav navbar-nav navbar-left">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        用户管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="admin_user_list.html">用户列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin_user_create.html">新增用户</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        卡片管理
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="admin_card_list.html">卡片列表</a></li>
                        <li class="divider"></li>
                        <li><a href="admin_card_log.html">卡片操作日志</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        卡片充值消费
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="card_charge.html">充值</a></li>
                        <li class="divider"></li>
                        <li><a href="card_consume.html">消费</a></li>
                        <li class="divider"></li>
                        <li><a href="card_bill_log.html">卡片流水</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color: white">
                        我的账户
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="admin_user_edit.html?userId=<c:out value="${userInfo.id}"></c:out>">个人信息修改</a></li>
                        <li class="divider"></li>
                        <li><a href="repasswd.html">密码修改</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="login.html" style="color: white">${userInfo.name}, 已登录</a>
                </li>
                <li><a href="logout.html" style="color: white">退出</a></li>
            </ul>
        </div>
    </div>
</nav>
