package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoutil;
import task.message;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String _token = (String)request.getParameter("_token");
    	if(_token != null && _token.equals(request.getSession().getId())){
    		EntityManager em = daoutil.createEntityManager();

    		message m = new message();

    		String tasks = request.getParameter("tasks");
    		m.setTasks(tasks);

    		String content = request.getParameter("content");
    		m.setContent(content);

    		em.getTransaction().begin();
    		em.persist(m);
    		em.getTransaction().commit();
    		em.close();

    		response.sendRedirect(request.getContextPath() + "/index");

    	}
    }


}
