package com.wojdylak.productmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Campaign implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long campaignID;
  private String name;
  private String keywords;
  private int minAmount;
  private BigDecimal fund;
  private boolean isEnabled;
  private String townName;
  private double radius;

  @ManyToOne
  @JoinColumn(name = "productId")
  private Product product;

  public Campaign() {
  }


  public Campaign(Long campaignID, String name, String keywords, int minAmount, BigDecimal fund, boolean isEnabled, String townName, double radius, Product product) {
    this.campaignID = campaignID;
    this.name = name;
    this.keywords = keywords;
    this.minAmount = minAmount;
    this.fund = fund;
    this.isEnabled = isEnabled;
    this.townName = townName;
    this.radius = radius;
    this.product = product;
  }


  public Long getCampaignID() {
    return campaignID;
  }

  public void setCampaignID(Long campaignID) {
    this.campaignID = campaignID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public int getMinAmount() {
    return minAmount;
  }

  public void setMinAmount(int minAmount) {
    this.minAmount = minAmount;
  }

  public BigDecimal getFund() {
    return fund;
  }

  public void setFund(BigDecimal fund) {
    this.fund = fund;
  }

  public boolean isEnabled() {
    return isEnabled;
  }

  public void setEnabled(boolean enabled) {
    isEnabled = enabled;
  }

  public String getTownName() {
    return townName;
  }

  public void setTownName(String townName) {
    this.townName = townName;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  @Override
  public String toString() {
    return "Campaign{" +
      "campaignID=" + campaignID +
      ", name='" + name + '\'' +
      ", keywords='" + keywords + '\'' +
      ", minAmount=" + minAmount +
      ", fund=" + fund +
      ", isEnabled=" + isEnabled +
      ", townName='" + townName + '\'' +
      ", radius=" + radius +
      ", product=" + product +
      '}';
  }
}
