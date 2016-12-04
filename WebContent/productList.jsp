<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.niit.crud.product.entity.Product" %>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
</head>
<body>
	<%
		List<Product> products = (List<Product>)request.getAttribute("products");
	%>
	<table border = "1" width = "80%" align = "center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Category</th>
				<th>Description</th>
				<th>Price</th>
				<th>Quantity</th>
				<th colspan = "2">Action</th>
			</tr>
		</thead>
		<tbody>
			<% 
				for(Product product : products){
			%>
				<tr>
					<td><%=product.getId()%></td>
					<td><%=product.getName()%></td>
					<td><%=product.getBrand()%></td>
					<td><%=product.getCategory()%></td>
					<td><%=product.getDescription()%></td>
					<td><%=product.getPrice()%></td>
					<td><%=product.getQuantity()%></td>
					<td><a href = "ProductController.do?action=edit&id=<%=product.getId()%>">Edit</a></td>
					<td><a href = "ProductController.do?action=delete&id=<%=product.getId()%>">Delete</a></td>
				</tr>
			<%
				}
			%>
		</tbody>
		<tfoot>
			<tr>
				<td align = "center" colspan = "9"><a href = "ProductController.do?action=insert">Add New Product</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>