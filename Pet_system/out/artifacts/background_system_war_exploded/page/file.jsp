<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/5/7
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page language="java" import="Bean.User" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#add").click(function () {
                if($("#items").css("display")=="none"){
                    $("#items").show(100);
                }else{
                    $("#items").hide(100);
                }
            })
        })
    </script>
</head>
<body>
<%--<% User user=(User)session.getAttribute("User");if(user!=null){%>--%>
<%--<%}else{ %><%response.sendRedirect("log.jsp"); %><%}%>--%>
        <jsp:include page="top.jsp" flush="true"/>
                <div class="index_menu">
                    <h2>员工信息</h2>
                    <div class="wrap">
                        <form action="employeeAction_search.action" name="employeeAction" >
                            <input type="submit" value="查询  ">
                        </form>
                        <div class="delete add_items" id="add">添加</div>
                    </div>

                    <table align="center" width="100%">
                        <tr bgcolor="#CCFFFF">
                            <td width:="50">员工编号</td>
                            <td width:="50">员工姓名</td>
                            <td width:="50">员工年龄</td>
                            <td width:="100" >照片</td>
                            <td class="delete" width:="50">选项</td>
                            <td width:="150">添加照片</td>
                        </tr>
                        <s:iterator value="#request.pageBean.list" id="employee">

                            <tr>
                                <th width:="50"><s:property value="#employee.ID"/></th>
                                <th width:="50"><s:property value="#employee.name"/></th>
                                <th width:="50"><s:property value="#employee.age"/></th>
                                <th width:="50"><image src="..\employee\<s:property value="#employee.photo"/>" style="width: 70px; height: 70px;"></image></th>
                                <th width:="50"><a href="employeeAction_delete.action?id=<s:property value="#employee.ID"/>">点击删除</a></th>
                                <th width:="150">
                                    <%--<s:form action="UploadPicture?id=${employee.ID}" enctype="multipart/form-data">--%>
                                        <%--<s:file name="image" label="选择照片"/>--%>
                                        <%--<s:submit value="上传"/>--%>
                                    <%--</s:form>--%>
                                        <form action="upload?id=${employee.ID}.action " method="post" enctype="multipart/form-data">
                                            <label for="myFile">Upload your file</label>
                                            <input type="file" name="myFile" id="myFile"/>
                                            <input type="submit" value="Upload"/>
                                        </form>
                                </th>
                            </tr>

                        </s:iterator>
                        <form action="employeeAction_add.action"  method="post" >
                            <tr bgcolor="#CCFFFF"  id="items" class="tianjia">
                                  <th><input type="text" name="employee.ID"  value="0"></th>
                                  <th><input type="text" name="employee.name" value=""></th>
                                  <th><input type="text" name="employee.age"  value="0"></th>
                                  <th></th>
                                  <th><input type="submit" ></th>
                              </tr>
                        </form>

                    </table>


                    <div style="text-align: center;">

                        <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
                        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>

                        <s:if test="#request.pageBean.currentPage == 1">
                            首页&nbsp;&nbsp;&nbsp;上一页
                        </s:if>

                        <s:else>
                            <a href="employeeAction_execute.action">首页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="employeeAction_execute.action?page=<s:property value="#request.pageBean.currentPage - 1"/>">上一页</a>
                        </s:else>

                        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
                            <a href="employeeAction_execute.action?page=<s:property value="#request.pageBean.currentPage + 1"/>">下一页</a>
                            &nbsp;&nbsp;&nbsp;
                            <a href="employeeAction_execute.action?page=<s:property value="#request.pageBean.totalPage"/>">尾页</a>
                        </s:if>

                        <s:else>
                            下一页&nbsp;&nbsp;&nbsp;尾页
                        </s:else>

                    </div><br>
        </div>
</body>
</html>
