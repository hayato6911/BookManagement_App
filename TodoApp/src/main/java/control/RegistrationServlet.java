package control;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");

        response.sendRedirect("bookList.jsp");

        // ユーザー登録情報を一定時間保持し、その後削除する
        // Timerクラス。スケジュール実行するためのクラス
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                timer.cancel(); //
                try {  //正常系
                	String encodedMessage = URLEncoder.encode("ユーザー登録情報が削除されました", "UTF-8");
                	response.sendRedirect("Register.jsp?message=" + encodedMessage);
                } catch (IOException e) { //例外の詳細出力
                    e.printStackTrace();
                }
            }
        }, 60 * 60 * 1000);
    }
}
