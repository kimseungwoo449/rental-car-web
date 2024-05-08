package rentalCarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.board.model.BoardDao;
import rentalCarServer.board.model.BoardRequestDto;
import rentalCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class CreateBoardAction
 */
public class CreateBoardAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateBoardAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		if(title==null||title.equals("")||contents==null||contents.equals("")) {
			response.sendRedirect("/board");
		}else {
			BoardDao boardDao = BoardDao.getInstance();
			
			HttpSession session = request.getSession();
			UserResponseDto user = (UserResponseDto)session.getAttribute("user");
			
			String userId = user.getId();
			
			BoardRequestDto boardDto = new BoardRequestDto();
			boardDto.setUserId(userId);
			boardDto.setTitle(title);
			boardDto.setContents(contents);
			
			boardDao.createBoard(boardDto);
			
			response.sendRedirect("/board");
		}
	}

}
