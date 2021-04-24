<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <jsp:include page="admin_header.jsp"></jsp:include>
    <%--    <script>--%>
    <%--        $(function () {--%>
    <%--            $('#header').load('admin_header.html');--%>
    <%--        })--%>
    <%--    </script>--%>
</head>
<body background="img/school.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">

<div id="header"></div>
<div class="col-xs-6 col-md-offset-3" style="padding-top: 100px;position: relative">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">添加用户</h3>
        </div>
        <div class="panel-body">
            <form action="admin_user_create_do.html" method="post" id="createOrUpdateUserReq">
                <div class="input-group" style="padding-top: 20px; display: none ">
                    <span class="input-group-addon">ID</span>
                    <input type="text" class="form-control" id="id" name="id" value="0">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">姓名</span>
                    <input type="text" class="form-control" id="name" name="name" placeholder="必填">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">出生日期</span>
                    <input type="date" class="form-control" id="birth" name="birth" placeholder="必填">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">性别</span>
                    <%-- <input type="text" class="form-control" id="sex" name="sex" placeholder="必填">--%>
                    <select id="sex" name="sex" class="form-control">
                        <option value="male">男</option>
                        <option value="female">女</option>
                    </select>

                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">电话</span>
                    <input type="text" class="form-control" id="phone" name="phone">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">专业</span>
                    <input type="text" class="form-control" id="department" name="department" placeholder="必填">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">银行卡</span>
                    <input type="text" class="form-control" id="payAccountNumber" name="payAccountNumber">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">身份证</span>
                    <input type="text" class="form-control" id="identityCard" name="identityCard">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">密码</span>
                    <input type="text" class="form-control" id="cardPassword" name="cardPassword" value="111111">
                </div>
                <input style="float: right" type="submit" value="添加" class="btn btn-success btn-sm"
                       class="text-left">
                <script>
                    function mySubmit(flag) {
                        return flag;
                    }

                    $("#useredit").submit(function () {
                        if ($("#name").val() == '' || $("#sex").val() == '' || $("#department").val() == '' || $("#birth").val() == null) {
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
