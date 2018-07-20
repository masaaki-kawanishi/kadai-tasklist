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
 * Servlet implementation class NewServlet
 */
@WebServlet("/new")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = daoutil.createEntityManager();
		em.getTransaction().begin();

		message m = new message();

		String tasks = "Meeting";
		m.setTasks(tasks);

		String content ="NewMerchandise";
		m.setContent(content);

		em.persist(m);
		em.getTransaction().commit();

		response.getWriter().append(String.valueOf(m.getTasks()).toString ());


		em.close();
	}

}
