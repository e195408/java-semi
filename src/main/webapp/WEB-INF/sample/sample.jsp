<%--
  Created by IntelliJ IDEA.
  User: narasakinayu
  Date: 2021/06/11
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Servletのデータ受け取り
    request.setCharacterEncoding("UTF-8");
    String human = (String) request.getAttribute("human");
%>

<html>
<head>
    <title>RESULT</title>
</head>
<body>
<h1>出力結果</h1>
<%=human%>
</body>
</html>