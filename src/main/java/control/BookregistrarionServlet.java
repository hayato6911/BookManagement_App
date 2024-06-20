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
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストのエンコーディングを指定
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータ取得
		String genle = request.getParameter("genle");
		String title = request.getParameter("title");
		
		//Listクラスは可変（数が決まっていない）ため文字列のリストを作成し、infoListに格納。
		List<String> infoList = new ArrayList<String>();
		infoList.add(genle);
		infoList.add(title);
		
		// request.getSession()でセッションを取得
		// getAttribute("allinfoList)でセッションの中から情報を取り出す
	    List<List<String>> attribute = (List<List<String>>) request.getSession().getAttribute("allInfoList");
		List<List<String>> allInfoList = attribute;
		// 初回アクセス時にはallinfoList空だから、真になる。
		// 初回は空のリスト作成してあげるようにする
		// 2回目から偽になる
	    if(allInfoList == null) {
	        allInfoList = new ArrayList<List<String>>();
	    }
	    
	    // 新しい登録情報を追加
	    //2回目以降はリストが作成されているから、これで追加していく
	    allInfoList.add(infoList);
	    
	    // リクエストスコープへのデータ格納
	    request.getSession().setAttribute("allInfoList", allInfoList);
	    
	    // 転送オブジェクト取得
	    RequestDispatcher dispatcher = request.getRequestDispatcher("bookList.jsp");
	    
	    // 転送
	    dispatcher.forward(request, response);
	}

}
