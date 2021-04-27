<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${userInfo.name}的主页</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <c:if test="${cardInfo.isAdmin()}">
        <jsp:include page="admin_header.jsp"></jsp:include>
    </c:if>
    <c:if test="${!cardInfo.isAdmin()}">
        <jsp:include page="user_header.jsp"></jsp:include>
    </c:if>
</head>
<body background="img/lizhi.jpg" style=" background-repeat:no-repeat ;
background-size:100% 100%;
background-attachment: fixed;">
<%--<div id="header"></div>--%>
<div style="padding-top: 100px;">
<div class="col-xs-6 col-md-offset-3" style="position: relative;">
    <div class="panel panel-primary ">
        <div class="panel-heading ">
            <h3 class="panel-title">密码修改</h3>
        </div>
        <div class="panel-body">
            <form method="post" action="repasswd_do.html" class="form-inline" id="repasswd">
                <div class="input-group">
                    <input type="password" id="cardPassword" name="cardPassword" placeholder="输入旧密码" class="form-control"
                           class="form-control">
                    <input type="password" id="newCardPassword" name="newCardPassword" placeholder="输入新密码" class="form-control"
                           class="form-control">
                    <input type="password" id="reNewCardPassword" name="reNewCardPassword" placeholder="再次输入新密码"
                           class="form-control" class="form-control">
                    <em id="tishi" style="color: red"></em>
                    <br/>
                    <span><input type="submit" value="提交" class="btn btn-default"></span>
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
            </form>
        </div>
        </div>
    </div>
</div>

<script>
    $(document).keyup(function () {
        if ($("#newCardPassword").val() != $("#reNewCardPassword").val() && $("#newCardPassword").val() != "" && $("#reNewCardPassword").val() != "" && $("#newCardPassword").val().length == $("#reNewCardPassword").val().length) {
            $("#tishi").text("提示:两次输入的新密码不同，请检查!");
        } else {
            $("#tishi").text("");
        }
    })

    $("#repasswd").submit(function () {
        if ($("#oldPasswd").val() == '' || $("#newCardPassword").val() == '' || $("#reNewCardPassword").val() == '') {
            $("#tishi").text("提示:请填写完整!");
            return false;
        } else if ($("#newCardPassword").val() != $("#reNewCardPassword").val()) {
            $("#tishi").text("提示:两次输入的新密码不同，请检查!");
            return false;
        }
    })
</script>


</body>
</html>
