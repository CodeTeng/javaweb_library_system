<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>图书管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        function deleteBook(id) {
            //用户提示安全
            if (confirm("你确定要删除吗？")) {
                //访问路径
                location.href = "${pageContext.request.contextPath}/delBookServlet?id=" + id;
            }
        }

        window.onload = function () {
            //给删除选中按钮添加单击事件
            document.getElementById("delSelected").onclick = function () {
                if (confirm("你确定要删除选中条目吗？")) {
                    let flag = false;
                    //判断是否有选中条目
                    let cbs = document.getElementsByName("uid");
                    for (let i = 0; i < cbs.length; i++) {
                        if (cbs[i].checked) {
                            //有一个条目选中了
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {//有条目被选中
                        //表单提交
                        document.getElementById("form").submit();
                    }
                }
            }

            //1.获取第一个cb
            document.getElementById("firstCb").onclick = function () {
                //2.获取下边列表中所有的cb
                let cbs = document.getElementsByName("uid");
                //3.遍历
                for (let i = 0; i < cbs.length; i++) {
                    //设置这些cbs[i]的checked的状态 = firstCb.checked
                    cbs[i].checked = this.checked;
                }
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">书籍信息列表</h3>

    <div style="float:left;">
        <form class="form-inline" action="${pageContext.request.contextPath}/findBookByPageServlet" method="post">
            <div class="form-group">
                <label for="exampleInputName2">书名</label>
                <input type="text" class="form-control" name="name" value="${condition.name[0]}" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputName3">作者</label>
                <input type="text" name="author" value="${condition.author[0]}" class="form-control"
                       id="exampleInputName3">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">类别</label>
                <input type="text" name="type" value="${condition.type[0]}" class="form-control"
                       id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float:right; margin: 5px;">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加书籍</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="delSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/delSelectedServlet" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>书名</th>
                <th>图书价格</th>
                <th>图书作者</th>
                <th>图书类别</th>
                <th>图书生产日期</th>
                <th>图书简介</th>
                <th>图书详述</th>
                <th>图书生产编号</th>
            </tr>

            <c:forEach items="${pb.list}" var="book" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${book.id}"></td>
                    <td>${s.count}</td>
                    <td>${book.name}</td>
                    <td>${book.price}</td>
                    <td>${book.author}</td>
                    <td>${book.type}</td>
                    <td>${book.pdate}</td>
                    <td>${book.description}</td>
                    <td>${book.detail}</td>
                    <td>${book.address}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/findBookServlet?id=${book.id}">修改</a>&nbsp;&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteBook(${book.id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${pb.currentPage == 1}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != 1}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/findBookByPageServlet?currentPage=${pb.currentPage - 1}&rows=5&name=${condition.name[0]}&author=${condition.author[0]}&type=${condition.type[0]}"
                       aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>

                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <c:if test="${pb.currentPage == i}">
                        <li class="active"><a
                                href="${pageContext.request.contextPath}/findBookByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&author=${condition.author[0]}&type=${condition.type[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pb.currentPage != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/findBookByPageServlet?currentPage=${i}&rows=5&name=${condition.name[0]}&author=${condition.author[0]}&type=${condition.type[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>

                <c:if test="${pb.currentPage == pb.totalPage}">
                <li class="disabled">
                    </c:if>

                    <c:if test="${pb.currentPage != pb.totalPage}">
                <li>
                    </c:if>

                    <a href="${pageContext.request.contextPath}/findBookByPageServlet?currentPage=${pb.currentPage + 1}&rows=5&name=${condition.name[0]}&author=${condition.author[0]}&type=${condition.type[0]}"
                       aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px; margin-left: 5px;">
                    共${pb.totalCount}条记录，共${pb.totalPage}页
                </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
