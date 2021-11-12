<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改图书页面</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        window.onload = function () {
            document.getElementById("back").onclick = function () {
                location.href = "list.jsp";
            }

            document.getElementById("reset").onclick = function () {
                let flag = false;
                let inputs = document.getElementsByTagName("input");

                if (confirm("你确定要重置吗？")) {
                    flag = true;
                }
                if (flag) {
                    for (let i = 0; i < inputs.length; i++) {
                        if (inputs[i].type == "text") {
                            inputs[i].value = "";
                        }
                    }
                }
            }
        }

    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改图书信息</h3>
    <form action="${pageContext.request.contextPath}/updateBookServlet" method="post">
        <%--隐藏域 提交id--%>
        <input type="hidden" name="id" value="${book.id}">

        <div class="form-group">
            <label for="name">图书名字：</label>
            <input type="text" class="form-control" id="name" name="name" value="${book.name}" readonly="readonly" placeholder="请输入图书名字" />
        </div>

        <div class="form-group">
            <label for="price">图书价格：</label>
            <input type="text" class="form-control" name="price" value="${book.price}" id="price" placeholder="请输入图书价格"/>
        </div>

        <div class="form-group">
            <label for="author">图书作者：</label>
            <input type="text" class="form-control" id="author" name="author" value="${book.author}" placeholder="请输入图书作者">
        </div>

        <div class="form-group">
            <label for="type">图书类别：</label>
            <input type="text" class="form-control" id="type" name="type" value="${book.type}" placeholder="请输入图书类别">
        </div>

        <div class="form-group">
            <label for="pdate">图书生产日期：</label>
            <input type="text" class="form-control" id="pdate" name="pdate" value="${book.pdate}" placeholder="请输入图书日期"/>
        </div>

        <div class="form-group">
            <label for="description">图书简介：</label>
            <input type="text" class="form-control" name="description" value="${book.description}" id="description" placeholder="请输入图书简介"/>
        </div>

        <div class="form-group">
            <label for="detail">图书详述：</label>
            <input type="text" class="form-control" name="detail" id="detail" value="${book.detail}" placeholder="请输入图书详述"/>
        </div>

        <div class="form-group">
            <label for="address">图书生产编号：</label>
            <input type="text" class="form-control" name="address" id="address" value="${book.address}" placeholder="请输入图书生产编号"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" id="reset" value="重置" />
            <input class="btn btn-default" type="button" id="back" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
