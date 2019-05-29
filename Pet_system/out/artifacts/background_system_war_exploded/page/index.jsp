<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/5/6
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page language="java" import="Bean.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Order</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <%--<script type="text/javascript">--%>

        <%--function validate()--%>
        <%--{--%>
            <%--var page = document.getElementsByName("page")[0].value;--%>

            <%--if(page <s:property value="#request.pageBean.totalPage"/>)--%>
            <%--{--%>
                <%--alert("你输入的页数大于最大页数，页面将跳转到首页！");--%>

                <%--window.document.location.href = "personAction";--%>

                <%--return false;--%>
            <%--}--%>

            <%--return true;--%>
        <%--}--%>

    <%--</script>--%>
</head>
<body>
<%--<% User user=(User)session.getAttribute("User");if(user!=null){%>--%>
<%--<%}else{ %><%response.sendRedirect("log.jsp"); %><%}%>--%>
    <jsp:include page="top.jsp" flush="true"/>
    <div class="index_menu">
            <h2>预约时间</h2>

            <div class="wrap">
                <form action="orderAction_search.action" name="orderAction" method="post" >
                    <input placeholder="起始时间" name="start">
                    <input  placeholder="截止时间" name="end">
                    <input type="submit" >
                </form>
                <form action="orderAction_serach.action" name="orderAction" method="post">
                    <input type="submit" value="查询">
                </form>
        </div>

        <table align="center" width="100%">
            <tr bgcolor="#CCFFFF">
                <td>订单号</td>
                <td>联系人</td>
                <td>地址</td>
                <td>电话</td>
                <td>套餐类型</td>
                <td>时间段</td>
                <td>日期</td>

            </tr>
            <s:iterator value="#request.pageBean.list" id="order">

                <tr>
                    <th><s:property value="#order.ID"/></th>
                    <th><s:property value="#order.Contractor"/></th>
                    <th><s:property value="#order.Address"/></th>
                    <th><s:property value="#order.Phone"/></th>
                    <th><s:property value="#order.Set_category"/></th>
                    <th><s:property value="#order.schedule"/></th>
                    <th><s:property value="#order.order_date"/></th>
                </tr>

            </s:iterator>

        </table>

        <div style="text-align: center;">

            <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
            <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>

            <s:if test="#request.pageBean.currentPage == 1">
                首页&nbsp;&nbsp;&nbsp;上一页
            </s:if>

            <s:else>
                <a href="orderAction.action">首页</a>
                &nbsp;&nbsp;&nbsp;
                <a href="orderAction.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
            </s:else>

            <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
                <a href="orderAction.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
                &nbsp;&nbsp;&nbsp;
                <a href="orderAction.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
            </s:if>

            <s:else>
                下一页&nbsp;&nbsp;&nbsp;尾页
            </s:else>

        </div><br>

        <%--<center>--%>

            <%--<form action="orderAction" onsubmit="return validate();">--%>
                <%--<font size="4">跳转至</font>--%>
                <%--<input type="text" size="2" name="page">页--%>
                <%--<input type="submit" value="跳转" class="index_submit">--%>
            <%--</form>--%>

        <%--</center>--%>
    </div>
</body>
</html>
