/**
 * sample program for web programming written by Ben Wu
 * reference: http://www.mkyong.com/spring/maven-spring-jdbc-example/
 */
package com.sample.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.product.entity.Product;

public class ProductDAODB implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null ;
	private ResultSet rs = null ;
	private PreparedStatement smt = null ;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> getList(){
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Product> getList(String sql) {
					
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while(rs.next()){
				Product aProduct = new Product();
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierId(rs.getInt("supplierId"));
				aProduct.setName(rs.getString("name"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount(rs.getInt("discount"));
				productList.add(aProduct);
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return productList;
	}
		  
	public void insert(Product aProduct) {

		// remove first parameter when Id is auto-increment
	    String sql = "INSERT INTO product (SupplierID, Name, Color, Size, Category, Description, Inventory, ReorderPoint, price, discount) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";	
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getSupplierId());
			smt.setString(2, aProduct.getName());
			smt.setString(3, aProduct.getColor());
			smt.setString(4, aProduct.getSize());
			smt.setString(5, aProduct.getCategory());
			smt.setString(6, aProduct.getDesc());
			smt.setInt(7, aProduct.getInventory());
			smt.setInt(8, aProduct.getReorderPoint());
			smt.setInt(9, aProduct.getPrice());
			smt.setInt(10, aProduct.getDiscount());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}

	public Product get(long id) {
		Product aProduct = new Product();
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierId(rs.getInt("supplierId"));
				aProduct.setName(rs.getString("name"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount(rs.getInt("discount"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return aProduct;
	}
	
	public void update(Product aProduct) {
		
		String sql = "UPDATE product SET SupplierID=?, Name=?, Color=?, Size=?, Category=?, Description=?, Inventory=?, ReorderPoint=?, price=?, discount=?"
				+ " WHERE ProductID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getSupplierId());
			smt.setString(2, aProduct.getName());
			smt.setString(3, aProduct.getColor());
			smt.setString(4, aProduct.getSize());
			smt.setString(5, aProduct.getCategory());
			smt.setString(6, aProduct.getDesc());
			smt.setInt(7, aProduct.getInventory());
			smt.setInt(8, aProduct.getReorderPoint());
			smt.setInt(9, aProduct.getPrice());
			smt.setInt(10, aProduct.getDiscount());
			smt.setLong(11, aProduct.getId());
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		
	}
	
	public void delete(long id) {
		
		String sql = "DELETE FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			smt.executeUpdate();			
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}

	public int count(){
		return 0; //no longer needed
	}


public Product get(Product aProduct) {
		
		String sql = "SELECT * FROM product WHERE productID = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getId());
			rs = smt.executeQuery();
			if(rs.next()){
				aProduct.setId(rs.getInt("productID"));	
				aProduct.setSupplierId(rs.getInt("supplierId"));
				aProduct.setName(rs.getString("name"));
				aProduct.setColor(rs.getString("color"));
				aProduct.setSize(rs.getString("size"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setDesc(rs.getString("description"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setReorderPoint(rs.getInt("reorderPoint"));
				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount(rs.getInt("discount"));
			}
			rs.close();
			smt.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
		return aProduct;
	}
public List<Product> getAvailableList() {
	String sql = "SELECT * FROM product WHERE Inventory > 0";
	return getList(sql);
}


public List<Product> getReorderList() {
	String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
	return getList(sql);
}
	

}//ProductDAOBean

