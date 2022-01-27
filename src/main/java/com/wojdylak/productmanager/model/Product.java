package com.wojdylak.productmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long productId;
  private String name;
  private BigDecimal price;
  private String imageURL;

  @JsonIgnore
  @OneToMany(mappedBy = "product",
    cascade = CascadeType.ALL)
  private List<Campaign> campaigns = new ArrayList<>();

  public Product() {
  }


  public Product(Long productId, String name, BigDecimal price, String imageURL) {
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


  public List<Campaign> getCampaigns() {
    return campaigns;
  }

  public void setCampaigns(List<Campaign> campaigns) {
    this.campaigns = campaigns;
  }

  public void assignCampaign(Campaign campaign) {
    campaigns.add(campaign);
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
