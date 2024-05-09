package rentalCarServer.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.board.model.BoardDao;
import rentalCarServer.board.model.BoardRequestDto;
import rentalCarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class SearchBoardAction
 */
public class SearchBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBoardAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String value = request.getParameter("search-value");
		String searchOption = request.getParameter("search-option");

		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto boardDto = new BoardRequestDto();

		List<BoardResponseDto> targetBoardList = null;

		if (searchOption.equals("isCommented")) {
			boardDto.setCommented(true);
			targetBoardList = boardDao.searchBoardsByIsCommented(boardDto);
		} else {
			if (value == null || value.equals(""))
				response.sendRedirect("/board");

			if (searchOption.equals("title")) {
				boardDto.setTitle(value);
				targetBoardList = boardDao.searchBoardsByTitle(boardDto);
			} else if (searchOption.equals("userId")) {
				boardDto.setUserId(value);
				targetBoardList = boardDao.searchBoardsByUserId(boardDto);
			}
		}
		
		HttpSession session = request.getSession();
		
		if(targetBoardList==null||targetBoardList.size()==0) {
			session.setAttribute("targetBoardList", null);
		}else {
			session.setAttribute("targetBoardList", targetBoardList);
		}
		
		response.sendRedirect("/viewSearchBoard");
	}	
}
