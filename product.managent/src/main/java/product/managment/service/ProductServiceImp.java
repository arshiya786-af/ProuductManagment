package product.managment.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product.managment.exception.ProductNotFoundException;
import product.managment.model.Product;
import product.managment.repository.ProductRepository;

@Service 		
@Transactional
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;


	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	

	public Product updateProduct(Product product) {
		Optional<Product> productDb = this.productRepository.findById(product.getProductId());
		if(productDb.isPresent()) {
			Product productUpdate = productDb.get();
			productUpdate.setProductId(product.getProductId());;
			productUpdate.setProductName(product.getProductName());;
			productUpdate.setProductDescription(product.getProductDescription());;
			productUpdate.setPrice(product.getPrice());
			productRepository.save(productUpdate);
			return productUpdate;
		}else {
			throw new ProductNotFoundException("Product Not fround : " + product.getProductId());
		}

	}

	public List<Product> getListOfAllProducts() {
		return this.productRepository.findAll();
	}

	public Product getProductDetailsByProductId(Long productId) {
		Optional<Product> productDb = this.productRepository.findById(productId);
		if(productDb.isPresent()) {
			return productDb.get();
		}else {
			throw new ProductNotFoundException("Product not forund : "+ productId);
		}
	}
	public void deleteProduct(Long ProductId) {
		Optional<Product> productDb = this.productRepository.findById(ProductId);
		if(productDb.isPresent()) {
			this.productRepository.delete(productDb.get());
		}else {
			throw new ProductNotFoundException("product Not Found : " + ProductId);
		}
	}


	public Product create_Product(Product product) {
		// TODO Auto-generated method stub
		return null;
	}


	public Product update_Product(Product product) {
		// TODO Auto-generated method stub
		return null;
	}


	public Product get_ProductDetailsByProductId(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}


	public void delete_Product(Long ProductId) {
		// TODO Auto-generated method stub
		
	}
	
}