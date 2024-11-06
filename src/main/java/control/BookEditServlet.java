package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookEditServlet")
public class BookEditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 編集画面に転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("bookEdit.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // リクエストパラメータの取得
        int index = Integer.parseInt(request.getParameter("index"));
        String genle = request.getParameter("genle");
        String title = request.getParameter("title");

        // セッションから登録情報を取得
        List<List<String>> allInfoList = (List<List<String>>) request.getSession().getAttribute("allInfoList");

        // 該当の書籍情報を更新
        if (allInfoList != null && index >= 0 && index < allInfoList.size()) {
            List<String> infoList = allInfoList.get(index);
            infoList.set(0, genle);
            infoList.set(1, title);
        }

        // 更新後の書籍一覧ページに転送
        response.sendRedirect("bookList.jsp");
    }
}
