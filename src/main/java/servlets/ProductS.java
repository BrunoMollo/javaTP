package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.DataProducts;
import entities.Product;
import logic.CtrlProduct;

@WebServlet("/ProductS")
public class ProductS extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductS() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CtrlProduct cp = new CtrlProduct();
		Product p = cp.getProduct(Integer.parseInt(request.getParameter("id_prod")));
		
		HttpSession sesion = request.getSession();
		sesion.setAttribute("prod", p);
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
