package rentalCarServer.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rentalCarServer.user.model.UserDao;
import rentalCarServer.user.model.UserRequestDto;

/**
 * Servlet implementation class JoinAction
 */
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
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
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String residentNumber = request.getParameter("resident-number");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String name = request.getParameter("name");
		
		if(phone.length()==11) {
			phone = phone.substring(0,3)+"-"+phone.substring(3,7)+"-"+phone.substring(7,phone.length());
		}
		
		if(residentNumber.length()==13) {
			residentNumber = residentNumber.substring(0,6)+"-"+residentNumber.substring(6,residentNumber.length());
		}
		
		UserRequestDto userDto = new UserRequestDto(id, password, email, residentNumber, phone, gender, name);
		UserDao userDao = UserDao.getInstance();
		if(userDao.createUser(userDto)!=null) {
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/join");
		}
	}

}
