<%--
  Created by IntelliJ IDEA.
  User: jemmy
  Date: 2019/4/13
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 引入Struts2标签库   -->
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />

  <style type="text/css">*{font-size:12px;}</style>
    <link rel="stylesheet" type="text/css" href="../../static/all.css">
    <link rel="stylesheet" type="text/css" href="../../static/iconfont.css">
  <title>    登陆页面 </title>
</head>

<body>

            <div class="login" >
                      <h1 >欢迎登录</h1>
                          <div >
                            <s:form action="checkLogin" namespace="/login">
                                <s:textfield name="username" cssClass="log_input" placeholder="登陆名称" />
                                <s:password name="password"  cssClass="log_input"  placeholder="登陆密码" />
                                <s:submit value="登陆" cssClass="log_submit"/>
                            </s:form>
                          </div>
            </div>
</body>
</html>
