package controllers;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.daoutil;
import task.tasks;
import validators.TasksValidator;

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

    		tasks m = new tasks();

    		String taskname = request.getParameter("taskname");
    		m.setTaskname(taskname);

    		String content = request.getParameter("content");
    		m.setContent(content);

    		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
    		m.setCreated_at(currentTime);
    		m.setUpdated_at(currentTime);

    		List<String> errors = TasksValidator.validate(m);
    		if(errors.size() > 0){
    			em.close();

    			request.setAttribute("_token", request.getSession().getId());
        		request.setAttribute("tasks",m);
        		request.setAttribute("errors", errors);

    		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topview/new.jsp");
            rd.forward(request, response);
    	 } else {
    		em.getTransaction().begin();
    		em.persist(m);
    		em.getTransaction().commit();
    		request.getSession().setAttribute("flush", "登録が完了しました。");
    		em.close();

    		response.sendRedirect(request.getContextPath() + "/index");

    	}
    }
  }
}
