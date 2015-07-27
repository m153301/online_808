
package servlet;

/*****************************************************************************/
//		商品を登録するservlet
/*****************************************************************************/

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import beans.Item;
import beans.OrderHistory;
import beans.User;
import controller.ItemInfoRegistManager;


public class ItemInfoRegistServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
												throws ServletException, IOException{


		request.setCharacterEncoding("UTF-8");

		//まず商品をItemテーブルに格納。最初は発注した数が在庫になる。
		//item_idを返すようにする
		String item_name = StringEscapeUtils.escapeHtml4(request.getParameter("item_name"));
		String item_priceString = StringEscapeUtils.escapeHtml4(request.getParameter("item_price"));
		String item_stockString = StringEscapeUtils.escapeHtml4(request.getParameter("item_stock"));

		int item_price = Integer.parseInt(item_priceString);
		int item_stock = Integer.parseInt(item_stockString);

		//コンストラクタ
		Item item = new Item( 0, item_name, item_price, item_stock);

		ItemInfoRegistManager manager = new ItemInfoRegistManager();
		int item_id = manager.registItemInfo(item);

		//次に、いつ誰が何をいくつ登録・発注したかを記録する。

		Date date = new Date();

		/*
		//セッションを実装したらここを使う
		//セッションからユーザIDを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("worker");
		OrderHistory orderHistory = new OrderHistory(0, user.getUserId(), item_id, item_stock, date);
		 */

		//セッションを実装していないときは、user_idは指定
		OrderHistory orderHistory = new OrderHistory(0, "worker", item_id, item_stock, date);

		ItemInfoRegistManager manager2 = new ItemInfoRegistManager();
		manager2.registItemLog(orderHistory);

		response.sendRedirect(response.encodeRedirectURL("./ItemInfoRegistDone.jsp"));
	}

}
