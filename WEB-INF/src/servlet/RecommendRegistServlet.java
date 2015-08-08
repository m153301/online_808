
package servlet;

/*****************************************************************************/
//		おすすめを登録するservlet
/*****************************************************************************/

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Recommend;
import beans.User;
import controller.RecommendManager;


public class RecommendRegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");
		
		//セッションを実装したらここを使う
		//セッションからユーザIDを取得
		HttpSession session = request.getSession();

		//jspから値を取得 dateはここを実行した時点での時刻を取る
		int item_id = Integer.parseInt( request.getParameter("item_id") );
		User user = (User)session.getAttribute("worker");
		Date date = new Date();
		
		System.out.println("@Servlet---------------------");
		System.out.println(item_id);
		System.out.println(user.getUserId());
		System.out.println(date);
		System.out.println("-----------------------------");

		Recommend recommend = new Recommend( item_id, user.getUserId(), date );

		RecommendManager manager = new RecommendManager();
		String recommendRegistResult = manager.insertRecommend(recommend);
		
		request.setAttribute("recommendRegistResult", recommendRegistResult + "");
		getServletContext().getRequestDispatcher("/jsp/worker/RecommendDone.jsp").forward(request, response);
	}
}
