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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(fs == null)
		{
			try {
				fs = new FibService();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String rType = request.getSession().getAttribute("request-type").toString();
		if(rType.equals("Add")){
			int number = Integer.parseInt(request.getParameter("number"));
			String jobNumber = "";
			jobNumber += fs.add(number);
			request.getSession().setAttribute("jobNumber", jobNumber);
			request.getSession().setAttribute("timer", 2);
			request.getRequestDispatcher("Interrim.jsp").forward(request, response);
			try {
				fs.genFib(number);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (rType.equals("Poll")){
			String results = "";
			try{
				results += fs.getResult(Integer.parseInt(request.getSession().getAttribute("jobNumber").toString()));
			}
			catch(Exception e){
				e.getMessage();
			}
			if((!results.equals("") && results != null)){
				request.getSession().setAttribute("results", results);
				request.getRequestDispatcher("Result.jsp").forward(request, response);
			}
			else{
				request.getRequestDispatcher("Interrim.jsp").forward(request, response);			
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}