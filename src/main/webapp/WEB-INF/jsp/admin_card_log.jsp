<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>卡片操作日志</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <jsp:include page="admin_header.jsp"></jsp:include>
    <%@ page import="com.card.domain.enums.CardOperateEnum" %>
</head>
<body background="img/book1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>

<div>
    <div style="padding-top: 70px; padding-bottom: 30px;width: 90%;margin-left: 5%">
        <form method="post" action="admin_card_log.html" id="queryCardOperateLogReq">
            <div style="display: flex; width: inherit; float:left ">
                <div>
                    <input type="text" placeholder="输入卡号" class="form-control" id="cardNumber" name="cardNumber">
                </div>
                <div>
                    <select id="cardOperateEnum" name="cardOperateEnum" class="form-control">
                        <option value="">选择卡片操作类型</option>
                        <option value="UPDATE_CARD">更新卡片信息</option>
                        <option value="ACTIVE_CARD">激活卡片</option>
                        <option value="MISSING_CARD">挂失卡片</option>
                        <option value="SUSPEND_CARD">锁定卡片</option>
                        <option value="DELETED_CARD">删除卡片</option>
                        <option value="RE_PASSWORD">重置密码</option>
                    </select>

                </div>
                <div>
                    <input type="text" placeholder="操作人ID" class="form-control" id="operateId" name="operateId">
                </div>

                <div style="float:right">
                    <input type="submit" value="搜索" class="btn btn-default">
                </div>
            </div>
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
                卡片日志
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>卡片号</th>
                    <th>操作人ID</th>
                    <th>操作类型</th>
                    <th>操作时间</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cardOperateRecordDTOList}" var="log">
                    <tr>
                        <td><c:out value="${log.id}"></c:out></td>
                        <td><c:out value="${log.cardNumber}"></c:out></td>
                        <td><c:out value="${log.operatorId}"></c:out></td>
                        <td><c:out value="${CardOperateEnum.getDesc(log.type)}"></c:out></td>
                        <td><c:out value="${log.createTime}"></c:out></td>
                        <td><a href="admin_card_log_delete.html?id=<c:out value="${log.id}"></c:out>">
                            <button type="button" class="btn btn-danger btn-xs">删除</button>
                        </a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
