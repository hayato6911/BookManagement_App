<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍情報編集</title>
</head>
<body>
  <h1>書籍情報編集</h1>

  <%-- 編集する書籍情報を取得 --%>
  <% int index = Integer.parseInt(request.getParameter("index")); %>
  <% List<List<String>> allInfoList = (List<List<String>>) request.getSession().getAttribute("allInfoList"); %>
  <% List<String> infoList = allInfoList.get(index); %>

  <form action="BookEditServlet" method="post">
      <input type="hidden" name="index" value="<%= index %>">
      <label for="genle">ジャンル:</label>
      <input type="text" name="genle" value="<%= infoList.get(0) %>" required><br><br>
      <label for="title">タイトル:</label>
      <input type="text" name="title" value="<%= infoList.get(1) %>" required><br><br>
      <input type="submit" value="更新">
      <button type="button" onclick="window.location.href='bookList.jsp'">キャンセル</button>
  </form>
</body>
</html>
