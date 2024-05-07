package rentalCarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.user.model.UserDao;
import rentalCarServer.user.model.UserRequestDto;
import rentalCarServer.user.model.UserResponseDto;
import rentalCarServer.util.PasswordCrypto;

/**
 * Servlet implementation class DeleteUserAction
 */
public class DeleteUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserResponseDto loginUser = (UserResponseDto)session.getAttribute("user");
		String inputPassword = request.getParameter("password");
		String encryptedPassword = loginUser.getPassword();
		
		if(PasswordCrypto.decrypt(inputPassword, encryptedPassword)) {
			UserRequestDto userDto = new UserRequestDto();
			userDto.setId(loginUser.getId());
			userDto.setPassword(encryptedPassword);
			
			UserDao userDao = UserDao.getInstance();
			userDao.deleteUser(userDto);
			session.removeAttribute("user");
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/mypage");
		}
	}

}
