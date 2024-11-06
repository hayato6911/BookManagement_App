package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookregistrarionServlet
 */
@WebServlet("/BookregistrarionServlet")
public class BookregistrarionServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディングを指定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータ取得
		String genle = request.getParameter("genle");
		String title = request.getParameter("title");
		
		List<String> infoList = new ArrayList<String>();
		infoList.add(genle);
		infoList.add(title);
		
	    List<List<String>> allInfoList = (List<List<String>>) request.getSession().getAttribute("allInfoList");
	    
	    if(allInfoList == null) {
	        allInfoList = new ArrayList<List<String>>();
	    }
	    
	    //2回目以降は追加
	    allInfoList.add(infoList);
	    
	    // リクエストスコープへのデータ格納
	    request.getSession().setAttribute("allInfoList", allInfoList);
	    
	    // 転送オブジェクト取得
	    RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
	    
	    // 転送
	    dispatcher.forward(request, response);
	}

}
