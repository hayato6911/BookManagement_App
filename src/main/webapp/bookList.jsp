<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍情報一覧</title>
</head>
<body>
  <h1>書籍情報一覧</h1>
  
  <%-- 登録情報を取得 --%>
  <% List<List<String>> allInfoList = (List<List<String>>) request.getSession().getAttribute("allInfoList"); %>
  
  <%-- 登録情報を表示 --%>
  <% if(allInfoList != null && !allInfoList.isEmpty()) { %>
      <table border="1">
        <tr>
            <th>ジャンル</th>
            <th>タイトル</th>
            <th>編集</th>
        </tr>
        <% for(int i = 0; i < allInfoList.size(); i++) { 
            List<String> infoList = allInfoList.get(i); %>
            <tr>
                <td><%= infoList.get(0) %></td>
                <td><%= infoList.get(1) %></td>
                <td>
                    <form action="BookEditServlet" method="get" style="display:inline;">
                        <input type="hidden" name="index" value="<%= i %>">
                        <input type="submit" value="編集">
                    </form>
                    <form action="BookDeleteServlet" method="post" style="display:inline;">
                        <input type="hidden" name="index" value="<%= i %>">
                        <input type="submit" value="削除" onclick="return confirm('本当に削除しますか？');">
                    </form>
                </td>
            </tr>
        <% } %>
      </table>
  <% } else { %>
      <p>登録情報がありません。</p>
  <% } %>
  <button onclick="location.href='bookRegister.jsp'">書籍新規登録</button>
</body>
</html>
