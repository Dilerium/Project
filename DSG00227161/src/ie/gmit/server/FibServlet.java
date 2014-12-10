package ie.gmit.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibServlet
 */
@WebServlet("/FibServlet")
public class FibServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FibService fs;

    /**
     * Default constructor. 
     */
    public FibServlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
    		fs = new FibService();	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rType = request.getParameter("request_type");
		if(rType.equals("Add")){
			String Number = "";
			Number += fs.add(Integer.parseInt(request.getParameter("max")));
			response.getOutputStream().print(Number);
		}
		else if (rType.equals("Poll")){
			String jobNumber = "";
			jobNumber += fs.add(Integer.parseInt(request.getParameter("jobNumber")));
			response.getOutputStream().print(jobNumber);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}