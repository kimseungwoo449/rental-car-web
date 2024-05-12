package rentalCarServer.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rentalCarServer.car.model.CarDao;
import rentalCarServer.car.model.CarResponseDto;
import rentalCarServer.reservation.model.ReservationDao;
import rentalCarServer.reservation.model.ReservationResponseDto;
import rentalCarServer.user.model.UserResponseDto;

/**
 * Servlet implementation class FindReservationByUserId
 */
public class FindReservationByUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindReservationByUserId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("find-reservation-by-userid");
		UserResponseDto user = (UserResponseDto)session.getAttribute("user");
		
		if(user == null) {
			response.sendRedirect("/");
			System.out.println("gotoindex");
		}else {
			String userId = user.getId();
			
			ReservationDao reservationDao = ReservationDao.getInstance();
			List<ReservationResponseDto> myList = reservationDao.findReservationByUserId(userId);
			
			CarDao carDao = CarDao.getInstance();
			for(int i =0;i<myList.size();i++) {
				ReservationResponseDto reservation = myList.get(i);
				String carNumber= reservation.getCarNumber();
				String carName = carDao.findCarNameByCarNumber(carNumber);
				reservation.setCarName(carName);
			}
			System.out.println("체크 끝");
			session.setAttribute("myReservationList", myList);
			response.sendRedirect("/mypage");
		}
	}
}
