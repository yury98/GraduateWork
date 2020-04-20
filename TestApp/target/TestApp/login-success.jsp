<%--
  Created by IntelliJ IDEA.
  User: yury
  Date: 18.04.2020
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <h1>You have logined successfully</h1>
    <%
        String sessionID = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
            }
        }
    %>
    <%= sessionID %>
</div>
</body>
</html>
