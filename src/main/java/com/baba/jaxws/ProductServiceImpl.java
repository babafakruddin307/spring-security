package com.baba.jaxws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ProductServiceImpl implements ProductService {
	
	List<Product> products=new ArrayList<>();
	private long id=123;
	
	ProductServiceImpl(){
		Product product=new Product();
		product.setId(id);
		product.setDescription("java crash course 8");
		products.add(product);
	}
	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public long addProduct(Product product) {

		product.setId(++id);
		products.add(product);
		return id;
	}

}
