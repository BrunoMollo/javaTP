package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.ProductType;
import entities.User;
import logic.CtrlProductType;

@WebServlet("/NewProductType")
public class NewProductType extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewProductType() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userS = (User) request.getSession().getAttribute("userSession");
		
		if (userS.isAdmin()) {
			ProductType pt = new ProductType();
			CtrlProductType cpt = new CtrlProductType();
			
			pt.setName(request.getParameter("nameInput"));
			
			cpt.addNewProductType(pt);
			
			request.getRequestDispatcher("controlProductTypes.jsp").forward(request, response);
		} else {
			request.setAttribute("errorType", 2);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
