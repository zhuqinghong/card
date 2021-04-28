<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑卡片信息</title>
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
            <h3 class="panel-title">编辑卡片</h3>
        </div>
        <div class="panel-body">
            <form action="admin_card_edit_do.html" method="post" id="createOrUpdateCardReq">
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">用户Id</span>
                    <input type="text" class="form-control" name="id" id="id" value="${cardInfo.userId}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">卡片号</span>
                    <input type="text" class="form-control" name="cardNumber" id="cardNumber" value="${cardInfo.cardNumber}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">卡密码</span>
                    <input type="text" class="form-control" name="cardPassword" id="cardPassword" value="${cardInfo.cardPassword}">
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">卡片状态</span>
                    <select id="cardStatus" name="cardStatus" class="form-control">
                        <option value="INIT">创建</option>
                        <option value="ACTIVE">激活</option>
                        <option value="MISSING">挂失</option>
                        <option value="SUSPEND">锁定</option>
                    </select>
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">卡片类型</span>
                    <select id="cardType" name="cardType" class="form-control">
                        <option value="ADMIN">管理员</option>
                        <option value="SYSTEM_USER">普通用户</option>
                    </select>
                </div>
                <div class="input-group" style="padding-top: 20px;">
                    <span class="input-group-addon">账户余额</span>
                    <input type="text" class="form-control" name="balance" id="balance" value="${cardInfo.balance}">
                </div>
                <input style="float: right" type="submit" value="添加" class="btn btn-success btn-sm"
                       class="text-left">
                <script>
                    document.getElementById("cardStatus").value = "${cardInfo.cardStatus}";
                    document.getElementById("cardType").value = "${cardInfo.cardTypeEnum.name()}";
                </script>
                <script>
                    function mySubmit(flag) {
                        return flag;
                    }
                </script>
            </form>
        </div>
    </div>

</div>


</body>
</html>
