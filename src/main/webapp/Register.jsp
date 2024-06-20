<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
    <title>ユーザー登録</title>
</head>
<body>
    <h2>ユーザー登録</h2>
    <form action="RegistrationServlet" method="post">
        <label for="username">ユーザー名:</label>
        <input type="text" name="username" required><br><br>
        <label for="password">パスワード:</label>
        <input type="password" name="password" minlength="4" required><br><br>
        <input type="submit" value="登録">
    </form>
    <% String message = request.getParameter("message");
if (message != null) {
    String decodedMessage = URLDecoder.decode(message, "UTF-8");
%>
    <p><%= decodedMessage %></p>
<% } %>
</body>
</html>
