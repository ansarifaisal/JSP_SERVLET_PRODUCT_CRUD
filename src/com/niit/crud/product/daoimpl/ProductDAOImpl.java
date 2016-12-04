package com.niit.crud.product.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.crud.product.dao.ProductDAO;
import com.niit.crud.product.dbutil.DBUtil;
import com.niit.crud.product.entity.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private static ProductDAO productDAO = null;
	
	private static Connection connection = null;
	
	public static ProductDAO getProductDAO(){
		if(productDAO == null){
			productDAO = new ProductDAOImpl();
		}
		return productDAO;
	}
	public ProductDAOImpl() {
		if(connection == null){
			connection = DBUtil.getConnection();
		}
	}
	

	@Override
	public Product getId(int id) {
		Product product = new Product();
		String selectQuery = "SELECT * FROM product WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setCategory(resultSet.getString("category"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return null;
		}
		return product;
	}

	@Override
	public List<Product> prodcuts() {
		List<Product> products = new ArrayList<>();
		String selectQuery = "SELECT * FROM product";
		try(PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				Product product = new Product();
				product.setId(resultSet.getInt("id"));
				product.setName(resultSet.getString("name"));
				product.setBrand(resultSet.getString("brand"));
				product.setCategory(resultSet.getString("category"));
				product.setDescription(resultSet.getString("description"));
				product.setPrice(resultSet.getDouble("price"));
				product.setQuantity(resultSet.getInt("quantity"));
				products.add(product);
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return null;
		}
		return products;
	}
	@Override
	public boolean deleteProduct(int id) {
		String deleteQuery = "DELETE FROM product WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
	}
	@Override
	public boolean addProdcut(Product product) {
		String insertQuery = "INSERT INTO product(name,brand,category,description,price,quantity) VALUES"
				+ "(?,?,?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setDouble(5, product.getPrice());
			preparedStatement.setInt(6, product.getQuantity());
			preparedStatement.executeUpdate();
			//System.out.println(product);
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
	}
	@Override
	public boolean updateProduct(Product product) {
		String updateQuery = "UPDATE product SET "
				+ "name = ?, brand = ?, category = ?, description = ?, price = ?, quantity = ?"
				+ "WHERE id = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getBrand());
			preparedStatement.setString(3, product.getCategory());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setDouble(5, product.getPrice());
			preparedStatement.setInt(6, product.getQuantity());
			preparedStatement.setInt(7, product.getId());
			preparedStatement.executeUpdate();
			//System.out.println(product);
			return true;
		} catch (SQLException e) {
			System.out.println("SQL Error: "+e.getMessage());
			return false;
		}
	}

	
}
