package servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import entities.Product;
import entities.ProductType;
import logic.CtrlProduct;
import logic.CtrlProductType;

@WebServlet("/NewProduct")
@MultipartConfig
public class NewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product p = new Product();
        
        String nameInput = request.getParameter("nameInput");
        String descInput = request.getParameter("descInput");
        String priceInput = request.getParameter("priceInput");
        String stockInput = request.getParameter("stockInput");

        if (nameInput != null && descInput != null && priceInput != null && stockInput != null) {
            p.setName(nameInput);
            p.setDescription(descInput);

            try {
                p.setPrice(Double.parseDouble(priceInput));
                p.setStock(Integer.parseInt(stockInput));
            } catch (NumberFormatException e) {
            	request.setAttribute("errorType", 14);
    			request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else {
        	request.setAttribute("errorType", 15);
			request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        p.setActive(true);
        
        ProductType pt = new ProductType();
        CtrlProductType cpt = new CtrlProductType();
        pt.setName(request.getParameter("catInput"));
        
        p.setType(pt); 
        pt = cpt.getProductTypeByName(p);
        if (pt == null) {
        	request.setAttribute("errorType", 16);
			request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        p.setType(pt);
        
        // Subida de la foto al proyecto
		Part filePart = request.getPart("photoInput");
		String photoName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
	    
		try {
			File pFoto = new File(System.getProperty("user.dir") + "\\Workspace\\javaTP\\src\\main\\webapp\\imgs\\productos" + "\\" + pt.getId() + "\\" + photoName);
        	FileOutputStream fos = new FileOutputStream(pFoto);
        	IOUtils.copy(fileContent, fos);
        	fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		p.setImg("imgs/productos/" + pt.getId() + "/" + photoName);
		
		
        CtrlProduct cp = new CtrlProduct();
        cp.addNewProduct(p);
        
		request.getRequestDispatcher("controlProducts.jsp").forward(request, response);
	}

}
