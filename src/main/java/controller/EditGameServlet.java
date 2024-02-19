package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.VideoGame;

/**
 * Servlet implementation class EditGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VideoGameHelper dao = new VideoGameHelper();
		
		String name = request.getParameter("name");
		String developer = request.getParameter("developer");
		String publisher = request.getParameter("publisher");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		VideoGame gameToUpdate = dao.searchForGameById(tempId);
		gameToUpdate.setName(name);
		gameToUpdate.setDeveloper(developer);
		gameToUpdate.setPublisher(publisher);
		
		dao.updateItem(gameToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
