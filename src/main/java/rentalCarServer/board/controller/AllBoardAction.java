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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> list = boardDao.viewAllBoard();
		
		request.setAttribute("boardlist", list);
		
		// JSP 내장 객체를 활용한 페이지 이동처리
		// 1) response.sendRedirect(패스)	 : 순수 페이지 이동 
		// 2) request.getRequestDispatcher(패스).forward(req, res) : 객체 전달과 함께 url의 변화가 없음 
		
		request.getRequestDispatcher("/boardlist").forward(request, response);

//		JSONArray oArray = new JSONArray();
//		for (int i = 0; i < list.size(); i++) {
//			BoardResponseDto temp = list.get(i);
//			int postNumber = temp.getPostNumber();
//			String userId = temp.getUserId();
//			String title = temp.getTitle();
//			String contents = temp.getContents();
//			String adminComment = temp.getAdminComment();
//			boolean isCommented = temp.isCommented();
//			Timestamp postDate = temp.getPostDate();
//			Timestamp modDate = temp.getModDate();
//			boolean isNotice = temp.isNotice();
//			
//			JSONObject object = new JSONObject();
//			object.put("post_no", postNumber);
//			object.put("user_id", userId);
//			object.put("title", title);
//			object.put("contents", contents);
//			object.put("admin_comment", adminComment);
//			object.put("is_commented", isCommented);
//			object.put("post_date", postDate);
//			object.put("mod_date", modDate);
//			object.put("is_notice", isNotice);
//			oArray.put(object);
//		}
//		
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("application/json;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.append(oArray.toString());
	}

}
