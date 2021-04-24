<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息列表</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $('#header').load('admin_header.html');
        })
    </script>
</head>
<body background="img/book1.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>

<div style="padding: 70px 550px 10px">
    <form method="post" action="queryUserByCondition.html" class="form-inline" id="searchform">
        <div class="input-group">
            <input type="text" placeholder="输入一卡通卡号" class="form-control" id="cardNumber" name="cardNumber" class="form-control">
            <input type="text" placeholder="输入用户id" class="form-control" id="userId" name="userId" class="form-control">
            <input type="text" placeholder="输入用户名称" class="form-control" id="userName" name="userName" class="form-control">
            <span class="input-group-btn">
                            <input type="submit" value="搜索" class="btn btn-default">
            </span>
        </div>
    </form>
    <script>
        // $("#searchform").submit(function () {
        //     var val = $("#search").val();
        //     if (val == '') {
        //         alert("请输入关键字");
        //         return false;
        //     }
        // })
    </script>
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
                <%--                <th>专业</th>--%>
                <%--                <th>详情</th>--%>
                <%--                <th>删除</th>--%>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${userInfos}" var="user">
                <tr>
                    <td><c:out value="${user.id}"></c:out></td>
                    <td><c:out value="${user.cardNumber}"></c:out></td>
                    <td><c:out value="${user.name}"></c:out></td>
                    <td><c:out value="${user.sex}"></c:out></td>
                    <td><c:out value="${user.birth}"></c:out></td>
                    <td><c:out value="${user.department}"></c:out></td>
                    <td><c:out value="${user.phone}"></c:out></td>
                        <%--                    <td><a href="admin_book_detail.html?bookId=<c:out value="${book.bookId}"></c:out>">--%>
                        <%--                        <button type="button" class="btn btn-success btn-xs">详情</button>--%>
                        <%--                    </a></td>--%>
                        <%--                    <td><a href="updatebook.html?bookId=<c:out value="${book.bookId}"></c:out>">--%>
                        <%--                        <button type="button" class="btn btn-info btn-xs">编辑</button>--%>
                        <%--                    </a></td>--%>
                        <%--                    <td><a href="deletebook.html?bookId=<c:out value="${book.bookId}"></c:out>">--%>
                        <%--                        <button type="button" class="btn btn-danger btn-xs">删除</button>--%>
                        <%--                    </a></td>--%>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
