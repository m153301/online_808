
package servlet;

/*****************************************************************************/
//		商品を登録するservlet
/*****************************************************************************/

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import validator.ItemValidator;
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

		List<String> itemInfo = new ArrayList<String>();

		itemInfo.add(request.getParameter("item_name"));
		itemInfo.add(request.getParameter("item_price"));
		itemInfo.add(request.getParameter("item_stock"));

		ItemValidator itemValidator = new ItemValidator();

		List<String> errors = itemValidator.validator(itemInfo);
		request.setAttribute("errors", errors);

		if(errors.isEmpty()){

		//まず商品をItemテーブルに格納。最初は発注した数が在庫になる。
		//item_idを返すようにする
		String itemName = StringEscapeUtils.escapeHtml4(request.getParameter("item_name"));
		String itemPriceString = StringEscapeUtils.escapeHtml4(request.getParameter("item_price"));
		String itemStockString = StringEscapeUtils.escapeHtml4(request.getParameter("item_stock"));

		int itemPrice = Integer.parseInt(itemPriceString);
		int itemStock = Integer.parseInt(itemStockString);


		ItemInfoRegistManager itemInfoRegistManager = new ItemInfoRegistManager();
		int itemId = itemInfoRegistManager.insertItem(itemName, itemPrice, itemStock);

		//次に、いつ誰が何をいくつ登録・発注したかを記録する。
		Date date = new Date();

		//セッションを実装したらここを使う
		//セッションからユーザIDを取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("worker");
		itemInfoRegistManager.insertOrderHistory(user.getUserId(), itemId, itemStock, date);

		/*
		//セッションを実装していないときは、user_idは指定
		itemInfoRegistManager.insertOrderHistory(0, "worker", itemId, itemStock, date);
		*/

		response.sendRedirect(response.encodeRedirectURL("./ItemInfoRegistDone.jsp"));
		}
		else{
			getServletContext().getRequestDispatcher("/jsp/worker/ItemInfoRegist.jsp").forward(request, response);
		}
	}

}
