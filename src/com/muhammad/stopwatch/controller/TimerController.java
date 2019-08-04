package com.muhammad.stopwatch.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.muhammad.stopwatch.modell.StopWatch;
import com.muhammad.stopwatch.modell.Timer;

/**
 * Servlet implementation class TimerController
 */
@WebServlet("/TimerController")
public class TimerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/Index.jsp");
		HttpSession session = request.getSession();
		StopWatch currentWatch = (StopWatch) session.getAttribute("Timers");
		int id = Integer.parseInt(request.getParameter("id"));
		if (id == 0) {
			if(session.getAttribute("currentTime") == null) {
				Timer time = new Timer();
				currentWatch.addTime(time);
				session.setAttribute("currentTime", time);
				session.setAttribute("Timers", currentWatch);
			}
		}
		if (id == 1) {
				Timer time = (Timer) session.getAttribute("currentTime");
				if(session.getAttribute("currentTime") == null) {
					view.forward(request, response);
					return;
				}
				time.setEndTime();
				session.setAttribute("Timers", currentWatch);
				session.removeAttribute("currentTime");	
		}
		if (id == 2) {
			Timer time = (Timer) session.getAttribute("currentTime");
			if(session.getAttribute("currentTime") == null) {
				view.forward(request, response);
				return;
			}
			time.resetTimer();
		}
		request.setAttribute("time", currentWatch.getTimer());
		
		request.setAttribute("startingTime", 
				currentWatch.getTimer()
				.get(currentWatch.getTimer().size() - 1)
				.getStartTime());
		request.setAttribute("runningTime", 
				currentWatch.getTimer()
				.get(currentWatch.getTimer().size() - 1)
				.runningTime());
		request.setAttribute("TimeCurrently", 
				currentWatch.getTimer()
				.get(currentWatch.getTimer().size() - 1)
				.currentTime());
		
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
