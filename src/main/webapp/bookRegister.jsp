<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>書籍情報登録</h1>
  <form action="BookregistrarionServlet" method="post" onsubmit="return confirmSubmit();">
        <label for="genle">ジャンル:</label>
        <input type="text" name="genle" required><br><br>
        <label for="title">タイトル:</label>
        <input type="text" name="title" required><br><br>
        <input type="submit" value="登録">
        <button onclick="location.href='bookList.jsp'">キャンセル</button>
    </form>
    <script>
function confirmSubmit() {
    var confirmation = confirm("確定してよろしいですか？");
    return confirmation;
}
</script>
</body>
</html>