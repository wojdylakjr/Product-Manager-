package com.wojdylak.productmanager.controller;

import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.service.CampaignService;
import com.wojdylak.productmanager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CampaignController {
  private CampaignService campaignService;


  @Autowired
  public CampaignController(CampaignService campaignService) {
    this.campaignService = campaignService;

  }

  public CampaignController() {
  }


  @RequestMapping("/campaigns")
  public ResponseEntity<List<Campaign>> getAllCampaigns() {
    List<Campaign> campaigns = campaignService.findAllCampaigns();
    return new ResponseEntity<>(campaigns, HttpStatus.OK);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/campaigns")
  public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
    Campaign newCampaign = campaignService.addCampaign(campaign);
    return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/campaigns/{campaignId}")
  public ResponseEntity<Campaign> assignCampaignToProduct(@PathVariable("campaignId") Long campaignId) {
    campaignService.deleteCampaign(campaignId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @RequestMapping("/products/{productId}/campaigns/{campaignId}")
  public ResponseEntity<Campaign> getCampaignByIdFromProduct(@PathVariable("campaignId") Long campaignId) {
    Campaign campaign = campaignService.findCampaignById(campaignId);
    return new ResponseEntity<>(campaign, HttpStatus.OK);
  }


  @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}/campaigns/{campaignId}")
  public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaign, @PathVariable("campaignId") Long campaignId) {
    Campaign updatedCampaign = campaignService.updateCampaign(campaign);
    return new ResponseEntity<>(updatedCampaign, HttpStatus.OK);
  }

}
