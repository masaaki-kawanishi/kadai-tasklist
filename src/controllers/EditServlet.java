package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoutil;
import task.message;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = daoutil.createEntityManager();

		message m = em.find(message.class,request.getParameter("tasks"));

		em.close();

		request.setAttribute("message", m);
		request.setAttribute("_token", request.getSession().getId());
		request.getSession().setAttribute("message_tasks", m.getTasks());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topview/edit.jsp");
		rd.forward(request, response);
	}

}
