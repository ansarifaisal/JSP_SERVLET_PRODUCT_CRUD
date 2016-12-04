package com.niit.crud.product.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.crud.product.dao.ProductDAO;
import com.niit.crud.product.daoimpl.ProductDAOImpl;
import com.niit.crud.product.entity.Product;

@WebServlet(urlPatterns = {"/ProductController","/ProductController.do"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static ProductDAO productDAO = ProductDAOImpl.getProductDAO();
	
	private static final String LIST_OR_DELETE = "/productList.jsp";
	private static final String INSERT_OR_EDIT = "/productForm.jsp";
	
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
		if(action.equals("insert")){
			forward = INSERT_OR_EDIT;
		}else if(action.equals("edit")){
			forward = INSERT_OR_EDIT;
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productDAO.getId(id);
			productDAO.updateProduct(product);
			request.setAttribute("product", product);
		}else if(action.equals("delete")){
			forward = LIST_OR_DELETE;
			int id = Integer.parseInt(request.getParameter("id"));
			productDAO.deleteProduct(id);
			request.setAttribute("products", productDAO.prodcuts());
		}else{
			forward = LIST_OR_DELETE;
			request.setAttribute("products", productDAO.prodcuts());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product = new Product();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String category = request.getParameter("category");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		product.setCategory(category);
		product.setDescription(description);
		product.setPrice(price);
		product.setQuantity(quantity);
		System.out.println(product);
		if(id==0){
			productDAO.addProdcut(product);
		}else{
			productDAO.updateProduct(product);
		}
		response.sendRedirect("index.jsp");
		//doGet(request, response);
	}

}
