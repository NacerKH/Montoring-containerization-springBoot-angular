package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.services.Iservices.IProductService;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {

   final ProductRepository productRepository;
   final StockRepository stockRepository;

    @Override
    public Product addProduct(Product product, Long idStock) {
        Stock stock = stockRepository.findById(idStock).orElseThrow(() -> new NullPointerException("stock not found"));
        product.setStock(stock);
        return productRepository.save(product);
    }

    @Override
    public Product retrieveProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new NullPointerException("Product not found"));
    }

    @Override
    public List<Product> retreiveAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> retrieveProductByCategory(ProductCategory category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> retreiveProductStock(Long id) {
        return productRepository.findByStockIdStock(id);
    }
}
