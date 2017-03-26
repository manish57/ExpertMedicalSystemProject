package com.medical.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medical.dao.MedicalDao;
import com.medical.model.Comparison;
import com.medical.model.Doctors;

/**
 * Servlet implementation class ScheduleAppointment
 */
@WebServlet("/ScheduleAppointment")
public class ScheduleAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MedicalDao dao;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleAppointment() {
        super();
        dao = new MedicalDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String disease= request.getParameter("sAppoint");
		Comparison comparison = new Comparison();
		Doctors doctor = new Doctors();
		comparison.setDisease(disease);
		dao.getCompValue(comparison);
		doctor = dao.getDocDetails(comparison);
		System.out.println("inside ser:"+doctor.getFirstName());
		request.setAttribute("dfname",doctor.getFirstName());
		request.setAttribute("dlname",doctor.getLastName());
		request.setAttribute("address",doctor.getAddress());
		request.setAttribute("special",comparison.getSpecialization());
		request.getRequestDispatcher("/Appointment.jsp").forward(request, response);  
		
	}

}
