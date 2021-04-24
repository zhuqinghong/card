<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑用户信息</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <jsp:include page="admin_header.jsp"></jsp:include>
</head>
<body background="img/school.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">编辑用户</h3>
        </div>
        <div class="panel-body">
            <form action="admin_user_edit_do.html" method="post" id="createOrUpdateUserReq">
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">用户Id</span>
                    <input type="text" class="form-control" name="id" id="id" value="${userCard.userInfo.id}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" name="name" id="name" value="${userCard.userInfo.name}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">出生日期</span>
                    <input type="date" class="form-control" name="birth" id="birth" value="${userCard.userInfo.birth}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">性别</span>
                    <select id="sex" name="sex" class="form-control">
                        <option value="male">男</option>
                        <option value="female">女</option>
                    </select>
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" name="phone" id="phone" value="${userCard.userInfo.phone}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">专业</span>
                    <input type="text" class="form-control" name="department" id="department" value="${userCard.userInfo.department}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">银行卡</span>
                    <input type="text" class="form-control" name="payAccountNumber" id="payAccountNumber" value="${userCard.userInfo.payAccountNumber}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">身份证</span>
                    <input type="text" class="form-control" name="identityCard" id="identityCard" value="${userCard.userInfo.identityCard}">
                </div>
                <%--                <div class="input-group" style="padding-top: 20px;">--%>
                <%--                    <span class="input-group-addon">卡号</span>--%>
                <%--                    <input type="text" class="form-control" name="cardNumber" id="cardNumber" value="${userCard.cardInfo.cardNumber}">--%>
                <%--                </div>--%>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">密码</span>
                    <input type="text" readonly="readonly" class="form-control" value="${userCard.cardInfo.cardPassword}">
                </div>
                <input style="float: right" type="submit" value="添加" class="btn btn-success btn-sm"
                       class="text-left">
                <script>
                    $("#sex option[value='" + userCard.userInfo.sex + "']").attr("selected", "selected");

                    function mySubmit(flag) {
                        return flag;
                    }

                    $("#useredit").submit(function () {
                        if ($("#name").val() == '' || $("#sex").val() == '' || $("#department").val() == '' || $("#birth").val() == '') {
                            alert("请输入必填项！");
                            return mySubmit(false);
                        }
                    })
                </script>
            </form>
        </div>
    </div>

</div>


</body>
</html>
