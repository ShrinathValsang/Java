package com.modernjava.examples;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyEmptyClass {
	public static void main(String[] args) {
		Product p1 = new Product(10001, 20.05f);
		Product p2 = new Product(10001, 147.75f);
		Product p3 = new Product(10001, 80.50f);
		Product p4 = new Product(10001, 10.05f);
		
		Order o1 = new Order(80001, List.of(p1, p3));
		Order o2 = new Order(80002, List.of(p2, p4));
		List<Order> orderList = List.of(o1, o2);
		
		// filter order with at least one product with price greater than 100

		Predicate<Order> containsAnyProductPriceGreaterThan100 = (order) -> {
			List<Product> plist = order.getProductList();
			List<Product> newProdList = plist.stream().filter(p -> p.getPrice() > 100).collect(Collectors.toList());
			return (newProdList != null && !newProdList.isEmpty());
		};
		
		List<Order> list = orderList.stream().filter(containsAnyProductPriceGreaterThan100).collect(Collectors.toList());
		System.out.println(list);
		
		
	}
}


class Order {
	int orderId;
	List<Product> productList;
	
	public Order(int orderId, List<Product> productList) {
		super();
		this.orderId = orderId;
		this.productList = productList;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productList=" + productList + "]";
	}
	
	
	
}

class Product {
	private int productId;
	private float price;

	public Product(int productId, float price) {
		super();
		this.productId = productId;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", price=" + price + "]";
	}
	
	
}
