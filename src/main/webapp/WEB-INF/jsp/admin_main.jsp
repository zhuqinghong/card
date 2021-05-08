<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <%--    <jsp:include page="admin_header.jsp"></jsp:include>--%>
    <%--</head>--%>
    <%--<body background="img/book2.jpg" style=" background-repeat:no-repeat ;--%>
    <%--background-size:100% 100%;--%>
    <%--background-attachment: fixed;">--%>

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
<script>
    $(function () {
        $.ajax({
            type: "POST",
            url: "admin_card_list",
            data: {
                id: id,
                passwd: passwd
            },
            dataType: "json",
            success: function (data) {
            }
        });
    })
</script>
</c:if>
<c:if test="${!cardInfo.isAdmin()}">
<body background="img/system_user.jpeg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<script>
    $(function () {
        $.ajax({
            type: "POST",
            url: "admin_card_list",
            data: {
                id: id,
                passwd: passwd
            },
            dataType: "json",
            success: function (data) {
            }
        });
    })
</script>
</c:if>
<div id="header"></div>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    温馨提示
                </h4>
            </div>
            <div class="modal-body">
                使用结束后请安全退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" data-dismiss="modal">知道了
                </button>
            </div>
        </div>
    </div>
</div>

</body>
</html>
