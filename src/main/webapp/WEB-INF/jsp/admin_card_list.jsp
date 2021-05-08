<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>卡片信息列表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%@ page import="com.card.domain.enums.CardStatusEnum" %>
    <c:if test="${cardInfo.isAdmin()}">
        <jsp:include page="admin_header.jsp"></jsp:include>
    </c:if>
    <c:if test="${!cardInfo.isAdmin()}">
        <jsp:include page="user_header.jsp"></jsp:include>
    </c:if>
</head>
<c:if test="${cardInfo.isAdmin()}">
<body background="img/admin_img.jpeg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
</c:if>
<c:if test="${!cardInfo.isAdmin()}">
<body background="img/system_user.jpeg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
</c:if>
<div id="header"></div>

<div>
    <div style="padding-top: 70px; padding-bottom: 30px;width: 90%;margin-left: 5%">
        <form method="post" action="admin_card_list.html" id="queryCardInfoReq">
            <c:if test="${cardInfo.isAdmin()}">
                <div style="display: flex; width: inherit; float:left ">
                    <div>
                            <%--                    <span class="input-group-addon">卡号:</span>--%>
                        <input type="text" placeholder="输入卡号" class="form-control" id="cardNumber" name="cardNumber">
                    </div>
                    <div>
                            <%--                    <span class="input-group-addon">卡片状态:</span>--%>
                        <select id="cardStatus" name="cardStatus" class="form-control">
                            <option value="">选择卡片状态</option>
                            <option value="INIT">初始化</option>
                            <option value="ACTIVE">激活</option>
                            <option value="MISSING">挂失</option>
                            <option value="SUSPEND">锁定</option>
                        </select>

                    </div>
                    <div>
                            <%--                    <span class="input-group-addon">卡片类型:</span>--%>
                        <select id="cardType" name="cardType" class="form-control">
                            <option value="">选择卡片类型</option>
                            <option value="ADMIN">系统管理员</option>
                            <option value="SYSTEM_USER">普通用户</option>
                        </select>
                    </div>
                    <div>
                            <%--                    <span class="input-group-addon">用户ID:</span>--%>
                        <input type="text" placeholder="输入用户id" class="form-control" id="userId" name="userId">
                    </div>

                    <div style="float:right">
                        <input type="submit" value="搜索" class="btn btn-default">
                    </div>
                </div>
            </c:if>
        </form>
    </div>
    <div style="position: relative;top: 10%">
        <c:if test="${!empty succ}">
            <div class="alert alert-success alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                    ${succ}
            </div>
        </c:if>
        <c:if test="${!empty error}">
            <div class="alert alert-danger alert-dismissable">
                <button type="button" class="close" data-dismiss="alert"
                        aria-hidden="true">
                    &times;
                </button>
                    ${error}
            </div>
        </c:if>
    </div>
    <div class="panel panel-default" style="width: 90%;margin-left: 5%">
        <div class="panel-heading" style="background-color: #fff">
            <h3 class="panel-title">
                全部卡片
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>卡片号</th>
                    <th>用户ID</th>
                    <th>卡片状态</th>
                    <th>卡片类型</th>
                    <th>账户余额</th>
                    <th>创建时间</th>
                    <th>编辑</th>
                    <c:if test="${cardInfo.isAdmin()}">
                        <th>删除</th>
                    </c:if>
                    <th>挂失</th>
                    <th>激活</th>
                    <c:if test="${cardInfo.isAdmin()}">
                        <td>锁定</td>
                    </c:if>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cardInfoList}" var="card">
                    <tr>
                        <td><c:out value="${card.cardNumber}"></c:out></td>
                        <td><c:out value="${card.userId}"></c:out></td>
                        <td><c:out value="${CardStatusEnum.getType(card.cardStatus)}"></c:out></td>
                        <td><c:out value="${card.cardTypeEnum.desc}"></c:out></td>
                        <td><c:out value="${card.balance}"></c:out></td>
                        <td><c:out value="${card.createTime}"></c:out></td>
                        <td><a href="admin_card_edit.html?cardNumber=<c:out value="${card.cardNumber}"></c:out>">
                            <button type="button" class="btn btn-info btn-xs">编辑</button>
                        </a></td>
                        <c:if test="${cardInfo.isAdmin()}">
                            <td>
                                <a href="admin_card_delete.html?userId=<c:out value="${card.userId}"></c:out>">
                                    <button type="button" class="btn btn-danger btn-xs">删除</button>
                                </a>
                            </td>
                        </c:if>
                        <td>
                            <a href="card_missing.html?cardNumber=<c:out value="${card.cardNumber}"></c:out>">
                                <button type="button" class="btn btn-danger btn-xs">挂失</button>
                            </a>
                        </td>
                        <td>
                            <a href="card_active.html?cardNumber=<c:out value="${card.cardNumber}"></c:out>">
                                <button type="button" class="btn btn-danger btn-xs">激活</button>
                            </a>
                        </td>
                        <c:if test="${cardInfo.isAdmin()}">
                            <td>
                                <a href="card_suspend.html?cardNumber=<c:out value="${card.cardNumber}"></c:out>">
                                    <button type="button" class="btn btn-danger btn-xs">锁定</button>
                                </a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
