package com.wojdylak.productmanager.service;

import com.wojdylak.productmanager.exception.ProductNotFoundException;
import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.model.Product;
import com.wojdylak.productmanager.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
  private final ProductRepo productRepo;

  @Autowired
  public ProductService(ProductRepo productRepo) {
    this.productRepo = productRepo;
  }

  public Product addProduct(Product product) {
    return productRepo.save(product);
  }

  public List<Product> findAllProducts() {
    return productRepo.findAll();
  }

  public Product findProductById(Long id) {
    return productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("Product by id: " + id + "was not found"));
  }

  public Product updateProduct(Product newProduct) {
    return productRepo.save(newProduct);
  }

  public void deleteProduct(Long id) {
    productRepo.deleteById(id);
  }

  //campaigns

  public Product addCampaignToProduct(Long productId, Campaign campaign) {
    Product product = this.findProductById(productId);
    campaign.setProduct(product);
    product.assignCampaign(campaign);
    return productRepo.save(product);
  }

  public List<Campaign> getCampaignsFromProduct(Long productId) {

    Product product = this.findProductById(productId);
    return product.getCampaigns();
  }


//  public Product deleteProductFromProduct(Long productId, Long campaignId) {
//    Product product = this.findProductById(productId);
//    campaign.setProduct(product);
//    product.assignCampaign(campaign);
//    return productRepo.save(product);
//  }
}
