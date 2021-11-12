<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加图书页面</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        window.onload = function () {
            document.getElementById("form").onclick = function () {
                return checkName() && checkPrice() && checkAuthor() && checkType() && checkPdate() && checkAddress();
            }

            document.getElementById("name").onblur = checkName;
            document.getElementById("price").onblur = checkPrice;
            document.getElementById("author").onblur = checkAuthor;
            document.getElementById("type").onblur = checkType;
            document.getElementById("pdate").onblur = checkPdate;
            document.getElementById("address").onblur = checkAddress;

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

        function checkName() {
            let name = document.getElementById("name").value;
            let reg_name = /[\u4e00-\u9fa5_a-zA-Z0-9_]{1,100}/;
            let flag = reg_name.test(name);
            if (flag) {
                s_name.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_name.innerHTML = "图书名格式错误";
            }
            return flag;
        }

        function checkPrice() {
            let price = document.getElementById("price").value;
            let reg_price = /^\d{1,10}$/;
            let flag = reg_price.test(price);
            if (flag) {
                s_price.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_price.innerHTML = "图书价格格式错误";
            }
            return flag;
        }

        function checkAuthor() {
            let author = document.getElementById("author").value;
            let reg_author = /[\u4e00-\u9fa5_a-zA-Z0-9_]{1,100}/;
            let flag = reg_author.test(author);
            if (flag) {
                s_author.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_author.innerHTML = "图书作者格式错误";
            }
            return flag;
        }

        function checkType() {
            let type = document.getElementById("type").value;
            let reg_type = /[\u4e00-\u9fa5]{1,20}/;
            let flag = reg_type.test(type);
            if (flag) {
                s_type.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_type.innerHTML = "图书类型格式错误";
            }
            return flag;
        }

        function checkPdate() {
            let pdate = document.getElementById("pdate").value;
            //日期格式为yyyy-MM-dd
            let reg_pdate = /(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)/;
            let flag = reg_pdate.test(pdate);
            if (flag) {
                s_pdate.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_pdate.innerHTML = "图书生产日期格式错误";
            }
            return flag;
        }

        function checkAddress() {
            let addres = document.getElementById("address").value;
            //图书生产编号格式为(eg)：LT823-0823;
            let reg_address = /^[a-zA-Z]{2}[0-9]{3}-[0-9]{4}$/;
            let flag = reg_address.test(addres);
            if (flag) {
                s_address.innerHTML = "<img src='img/gou.png' width='35' height='25'>";
            } else {
                s_address.innerHTML = "图书生产编号格式错误";
            }
            return flag;
        }

    </script>

    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <center><h3>添加图书</h3></center>
    <form action="${pageContext.request.contextPath}/addBookServlet" id="form" method="post">
        <div class="form-group">
            <label for="name">书名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入书籍名">
            <span id="s_name" class="error"></span>
        </div>

        <div class="form-group">
            <label for="price">图书价格：</label>
            <input type="text" class="form-control" name="price" id="price" placeholder="请输入价格"/>
            <span id="s_price" class="error"></span>
        </div>

        <div class="form-group">
            <label for="author">图书作者：</label>
            <input type="text" class="form-control" id="author" name="author" placeholder="请输入书籍作者">
            <span id="s_author" class="error"></span>
        </div>

        <div class="form-group">
            <label for="type">图书类别：</label>
            <input type="text" class="form-control" id="type" name="type" placeholder="请输入书籍类别">
            <span id="s_type" class="error"></span>
        </div>

        <div class="form-group">
            <label for="pdate">图书生产日期：</label>
            <input type="text" class="form-control" id="pdate" name="pdate" placeholder="请输入图书日期"/>
            <span id="s_pdate" class="error"></span>
        </div>

        <div class="form-group">
            <label for="description">图书简介：</label>
            <input type="text" class="form-control" name="description" id="description" placeholder="请输入图书简介"/>
        </div>

        <div class="form-group">
            <label for="detail">图书详述：</label>
            <input type="text" class="form-control" name="detail" id="detail" placeholder="请输入图书详述"/>
        </div>

        <div class="form-group">
            <label for="address">图书生产编号：</label>
            <input type="text" class="form-control" name="address" id="address" placeholder="请输入图书生产编号"/>
            <span id="s_address" class="error"></span>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" id="reset" value="重置" />
            <input class="btn btn-default" type="button" id="back" value="返回" />
        </div>
    </form>
</div>
</body>
</html>
