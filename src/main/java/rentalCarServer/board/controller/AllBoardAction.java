package rentalCarServer.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import rentalCarServer.board.model.BoardDao;
import rentalCarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class AllBoardAction
 */

public class AllBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllBoardAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> list = boardDao.viewAllBoard();

		JSONArray oArray = new JSONArray();
		for (int i = 0; i < list.size(); i++) {
			BoardResponseDto temp = list.get(i);
			int postNumber = temp.getPostNumber();
			String userId = temp.getUserId();
			String title = temp.getTitle();
			String contents = temp.getContents();
			String adminComment = temp.getAdminComment();
			boolean isCommented = temp.isCommented();
			Timestamp postDate = temp.getPostDate();
			Timestamp modDate = temp.getModDate();
			boolean isNotice = temp.isNotice();
			
			JSONObject object = new JSONObject();
			object.put("post_no", postNumber);
			object.put("user_id", userId);
			object.put("title", title);
			object.put("contents", contents);
			object.put("admin_comment", adminComment);
			object.put("is_commented", isCommented);
			object.put("post_date", postDate);
			object.put("mod_date", modDate);
			object.put("is_notice", isNotice);
			oArray.put(object);
		}
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.append(oArray.toString());
	}

}
