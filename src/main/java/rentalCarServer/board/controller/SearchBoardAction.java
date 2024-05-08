package rentalCarServer.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalCarServer.board.model.BoardDao;
import rentalCarServer.board.model.BoardRequestDto;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String value = request.getParameter("search-value");
		String searchOption = request.getParameter("search-option");
		
		BoardDao boardDao = BoardDao.getInstance();
		BoardRequestDto boardDto = null;

		if(searchOption.equals("isCommented")) {
			boardDto = new BoardRequestDto();
			boardDto.setCommented(true);
		}else {
			if(value==null||value.equals("")) {
				response.sendRedirect("/board");
			}
			
			boardDto = new BoardRequestDto();
			
			if(searchOption.equals("title")){
				boardDto.setTitle(value);
				
			}else if(searchOption.equals("userId")){
				boardDto.setUserId(value);

			}
		}
	}

}
