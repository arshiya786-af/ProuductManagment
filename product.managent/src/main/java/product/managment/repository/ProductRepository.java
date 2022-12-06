package product.managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import product.managment.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}