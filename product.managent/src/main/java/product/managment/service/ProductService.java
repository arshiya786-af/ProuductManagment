package product.managment.service;

import java.util.List;

import product.managment.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	
	public Product updateProduct(Product product);
	
	public List<Product> getListOfAllProducts();
	
	public Product getProductDetailsByProductId(Long productId);

	public void deleteProduct(Long ProductId);


}