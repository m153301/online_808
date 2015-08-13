package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import beans.Item;
import controller.RecommendManager;

public class ItemInfoGetServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
				doPost(request,response);
		}

		public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			request.setCharacterEncoding("UTF-8");
			
			//商品一覧のリストを取得
			List<Item> items = new ArrayList<Item>();
			RecommendManager manager = new RecommendManager();
			items = manager.selectItemAll();
			
			request.setAttribute("items", items); 
			getServletContext().getRequestDispatcher("/jsp/worker/RecommendRegist.jsp").forward(request, response); 

		}
}