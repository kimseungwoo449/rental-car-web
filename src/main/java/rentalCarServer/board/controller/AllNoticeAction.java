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
import rentalCarServer.board.model.BoardResponseDto;

/**
 * Servlet implementation class AllNoticeAction
 */
@WebServlet("/AllNoticeAction")
public class AllNoticeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllNoticeAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BoardDao boardDao = BoardDao.getInstance();
		List<BoardResponseDto> list = boardDao.viewAllBoard();
		
		HttpSession session = request.getSession();
		
		session.setAttribute("boardlist", list);
		session.setAttribute("pageStatus", "notice");
		response.sendRedirect("/notice");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
