package fr.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(
		name = "First Servlet",
		description = "Le dev de mon premier servlet",
		urlPatterns = {
				"/tata",
				"/tutu"
		})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FirstServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("passage dans init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("passage dans destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/*
	 * different scopes
	 *
	 * application session request (page)
	 *
	 *
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// je place la date du jour dans le scope request
		request.setAttribute("maclef", new Date());
		request.setAttribute("message", "coucou");

		// demande a request dispatcher (sert a lier la "vue" jsp a la servlet
		// "controleur)

		RequestDispatcher dispatcher = request.getRequestDispatcher("NewFile.jsp");
		dispatcher.forward(request, response);

		// PrintWriter out = response.getWriter();
		// out.write(
		// "<html><head><title>hola!</title></head><body>Bonjour tous le monde (je suis
		// en <b>GET</b>)</body></html>");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String Vch1 = request.getParameter("text1");

		String Vch2 = request.getParameter("check2");




		if(Vch1!=null)
		{
			// traitement
		}
		PrintWriter out = response.getWriter();

		out.write("Bonjour tous le monde  (je suis en POST");
		out.append(Vch1 + " " + Vch2);





	}
}


