package tn.esprit.devops_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(ProductCategory category);
    List<Product> findByStockIdStock(Long idStock);
}
