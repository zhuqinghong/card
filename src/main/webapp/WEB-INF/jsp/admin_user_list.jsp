<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息列表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <jsp:include page="admin_header.jsp"></jsp:include>
</head>
<body background="img/book1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>

<div>
    <div style="padding-top: 70px; padding-bottom: 30px;width: 90%;margin-left: 5%">
        <form method="post" action="admin_user_list.html" id="queryUserInfoReq">
            <div style="display: flex; width: inherit; float:left ">
                <div>
                    <input type="text" placeholder="输入用户id" class="form-control" id="id" name="id">
                </div>
                <div>
                    <input type="text" placeholder="输入一卡通卡号" class="form-control" id="cardNumber" name="cardNumber">
                </div>
                <div>
                    <input type="text" placeholder="输入用户名称" class="form-control" id="userName" name="userName">
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
                全部用户
            </h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>用户ID</th>
                    <th>一卡通号</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>出生日期</th>
                    <th>专业</th>
                    <th>手机号</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${userInfos}" var="user">
                    <tr>
                        <td><c:out value="${user.id}"></c:out></td>
                        <td><c:out value="${user.cardNumber}"></c:out></td>
                        <td><c:out value="${user.name}"></c:out></td>
                        <td>
                            <c:if test="${user.sex.equals('male')}">
                                男
                            </c:if>
                            <c:if test="${user.sex.equals('female')}">
                                女
                            </c:if>
                        </td>
                        <td><c:out value="${user.birth}"></c:out></td>
                        <td><c:out value="${user.department}"></c:out></td>
                        <td><c:out value="${user.phone}"></c:out></td>
                        <td><a href="admin_user_edit.html?userId=<c:out value="${user.id}"></c:out>">
                            <button type="button" class="btn btn-info btn-xs">编辑</button>
                        </a></td>
                        <td><a href="admin_user_delete.html?userId=<c:out value="${user.id}"></c:out>">
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
