package com.wojdylak.productmanager.controller;

import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.service.CampaignService;
import com.wojdylak.productmanager.service.ProductService;
import com.wojdylak.productmanager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class ProductController {
    private ProductService productService;
  private CampaignService campaignService;

    @Autowired
    public ProductController(ProductService productService,CampaignService campaignService) {
        this.productService = productService;
        this.campaignService = campaignService;
    }

    public ProductController() {
    }

    @RequestMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id")Long id){
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id")Long id){
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //campaigns

    @RequestMapping("/products/{productId}/campaigns")
    public ResponseEntity<List<Campaign>> getCampaignsFromProduct(@PathVariable("productId") Long productId) {
//      Product product = productService.findProductById(productId);
      List<Campaign> campaigns= productService.getCampaignsFromProduct(productId);
//      product.getCampaigns(campaign);
      return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/campaigns")
    public ResponseEntity<Campaign> addCampaignToProduct(@RequestBody Campaign campaign, @PathVariable("productId") Long productId) {
      Product product = productService.addCampaignToProduct(productId, campaign);
      return new ResponseEntity<>(campaign, HttpStatus.OK);
    }




}
