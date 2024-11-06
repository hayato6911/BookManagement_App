package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookDeleteServlet")
public class BookDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 削除対象のインデックスを取得
        int index = Integer.parseInt(request.getParameter("index"));

        // セッションから登録情報を取得
        List<List<String>> allInfoList = (List<List<String>>) request.getSession().getAttribute("allInfoList");

        // 該当の書籍情報を削除
        if (allInfoList != null && index >= 0 && index < allInfoList.size()) {
            allInfoList.remove(index);
        }

        // 削除後の書籍一覧ページにリダイレクト
        response.sendRedirect("bookList.jsp");
    }
}
