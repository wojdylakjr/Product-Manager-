package com.wojdylak.productmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private String name;
    private BigDecimal price;
    private String imageURL;
//    private Campaign campaign;

    public Product(){}

//    public Product(Long productId, String name, BigDecimal price, String imageURL, Campaign campaign) {
//        this.productId = productId;
//        this.name = name;
//        this.price = price;
//        this.imageURL = imageURL;
//        this.campaign = campaign;
//    }
public Product(Long productId, String name, BigDecimal price, String imageURL, Campaign campaign) {
    this.productId = productId;
    this.name = name;
    this.price = price;
    this.imageURL = imageURL;
}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

//    public Campaign getCampaign() {
//        return campaign;
//    }
//
//    public void setCampaign(Campaign campaign) {
//        this.campaign = campaign;
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "productId=" + productId +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ", imageURL='" + imageURL + '\'' +
//                ", campaign=" + campaign +
//                '}';
//    }
}
