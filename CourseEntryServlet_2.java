package LearnSE.ServletFiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import LearnSE.dao.daoService;
import LearnSE.model.mainEntryModel;

/**
 * Servlet implementation class CourseEntryServlet_2
 */
public class CourseEntryServlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseEntryServlet_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String entry_title= request.getParameter("text-title-content");
		String entry_details = request.getParameter("txt-content-detail");
		//set the model
		mainEntryModel entry = new mainEntryModel();
		entry.setContentTitle(entry_title);
		entry.setContentDetails(entry_details);
		//pass data top data access object
		daoService entrydao = new daoService();
		try {
			entrydao.addmainContent(entry);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
