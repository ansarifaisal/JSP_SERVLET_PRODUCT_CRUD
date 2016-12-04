<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.niit.crud.product.entity.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Product product = (Product) request.getAttribute("product");
		if(product == null){
			product = new Product();
			product.setName("");
			product.setBrand("");
			product.setDescription("");
			product.setCategory("");
		}
	%>
	<hr><h3 align="center">Product Details</h3><hr>
	<form action = "ProductController.do" method="POST">
		<table border="1" align="center">
			<tr>
				<td>Name</td>
				<td><input type="hidden" name="id" value="<%=product.getId()%>">
				<input type="text" name="name" value="<%=product.getName()%>" placeholder="Name">
				</td>	
			</tr>
			<tr>
				<td>Brand</td>
				<td><input type="text" name="brand" value="<%=product.getBrand()%>" placeholder="Brand"></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><input type="text" name="category" value="<%=product.getCategory()%>" placeholder="Category"></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" value="<%=product.getDescription()%>" placeholder="Description"></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" value="<%=product.getPrice()%>" placeholder="Price"></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="quantity" value="<%=product.getQuantity()%>" placeholder="Quantity"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>