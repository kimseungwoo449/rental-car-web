package rentalCarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import rentalCarServer.user.model.UserDao;
import rentalCarServer.user.model.UserRequestDto;
import rentalCarServer.user.model.UserResponseDto;
import rentalCarServer.util.PasswordCrypto;

/**
 * Servlet implementation class UpdateUserAction
 */

public class UpdateUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserAction() {
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
		
		UserRequestDto curUser = new UserRequestDto(
				loginUser.getId(),loginUser.getPassword(),loginUser.getEmail(),
				loginUser.getResidentNumber(),
				loginUser.getPhone(),loginUser.getGender(),loginUser.getName()
				);
		
		
		String inputPassword = request.getParameter("password");
		String newPassword = request.getParameter("new-password");
		String newEmail = request.getParameter("email");
		String newPhone =request.getParameter("phone");
		
		
		UserDao userDao = UserDao.getInstance();
		if(userDao.updateUser(curUser, inputPassword, newPassword, newEmail, newPhone)!=null) {
			session.removeAttribute("user");
			response.sendRedirect("/login");
		}else
			response.sendRedirect("/mypage");
		
	}

}
