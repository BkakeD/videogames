package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGame;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String game = request.getParameter("game");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		
		VideoGame vg = new VideoGame(game, developer, publisher);
		VideoGameHelper dao = new VideoGameHelper();
		dao.insertItem(vg);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
