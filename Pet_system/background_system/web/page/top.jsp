<%@ page import="Bean.User" %><%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/5/7
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>top</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
    <link rel="stylesheet" type="text/css" href="../../static/all.css">
    <link rel="stylesheet" type="text/css" href="../../static/iconfont.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
    <script src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
</head>
<body>
    <nav class="top-bar" data-topbar>
        <ul class="title-area">
            <li class="name">
                <!-- 如果你不需要标题或图标可以删掉它 -->
                <h1><a href="#">WebSiteName</a></h1>
            </li>
            <!-- 小屏幕上折叠按钮: 去掉 .menu-icon 类，可以去除图标。
            如果需要只显示图片，可以删除 "Menu" 文本 -->
            <li class="toggle-topbar menu-icon"><a href="orderAction_execute.action"><span>Menu</span></a></li>
        </ul>

        <section class="top-bar-section">
            <ul class="left">
                <li class="active"><a href="orderAction_execute.action">Home</a></li>
                <li><a href="orderAction_execute.action">订单</a></li>
                <li><a href="orderAction_file.action">员工档案</a></li>
            </ul>
        </section>
    </nav>

</body>
</html>
