<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户消费</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <%--    <jsp:include page="admin_header.jsp"></jsp:include>--%>
    <%--</head>--%>
    <%--<body background="img/admin_img.jpeg" style=" background-repeat:no-repeat ;--%>
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
</c:if>
<c:if test="${!cardInfo.isAdmin()}">
<body background="img/system_user.jpeg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
</c:if>

<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">消费</h3>
        </div>
        <div class="panel-body">

            <div class="input-group" style="padding-top: 20px;">
                <span class="input-group-addon">卡号</span>
                <input type="text" readonly="readonly" class="form-control" name="cardNumber" id="cardNumber" value="${cardNumber}">
            </div>
            <div class="input-group" style="padding-top: 20px;">
                <span class="input-group-addon">金额</span>
                <input type="text" class="form-control" name="amount" id="amount">
            </div>
            <div class="input-group" style="padding-top: 20px;">
                <span class="input-group-addon">交易类型</span>
                <input type="text" readonly="readonly" class="form-control" name="type" id="type" value="CONSUMING">
            </div>
            <div class="input-group" style="padding-top: 20px;">
                <span class="input-group-addon">交易详情</span>
                <input type="text" class="form-control" name="detail" id="detail">
            </div>
            <div class="input-group" style="padding-top: 20px;">
                <span class="input-group-addon">密码</span>
                <input type="text" class="form-control" name="cardPassword" id="cardPassword">
            </div>
            <input id="consumeButton" style="float: right" type="submit" value="充值" class="btn btn-success btn-sm" class="text-left">
            <p style="text-align: right;color: red;position: absolute" id="info"></p><br/>
            <script>
                $("#consumeButton").click(function () {
                    var cardNumber = $("#cardNumber").val();
                    var amount = $("#amount").val();
                    var type = $("#type").val();
                    var detail = $("#detail").val();
                    var cardPassword = $("#cardPassword").val();
                    $.ajax({
                        type: "POST",
                        url: "card_consume_do",
                        data: {
                            cardNumber: cardNumber,
                            amount: amount,
                            type: type,
                            detail: detail,
                            cardPassword: cardPassword
                        },
                        dataType: "json",
                        success: function (data) {
                            $("#info").text(data.msg);
                        }
                    });
                })
            </script>
        </div>
    </div>

</div>


</body>
</html>
