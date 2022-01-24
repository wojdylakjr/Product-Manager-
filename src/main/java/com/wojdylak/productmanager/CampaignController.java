package com.wojdylak.productmanager;

import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.service.CampaignService;
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

    @RequestMapping("/products/{id}/campaigns")
    public ResponseEntity<List<Campaign>> getAllCampaigns(@PathVariable Long id){
        List<Campaign> campaigns = campaignService.getAllCampaignsByProductId(id);
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

//    @RequestMapping("/products/{productId}/campaigns/{id}")
//    public ResponseEntity<Campaign> getCampaignById(@PathVariable("id")Long id, @PathVariable("productId")Long productId){
//        Campaign campaign= campaignService.findCampaignByIdInProductId(id, productId);
//        return new ResponseEntity<>(campaign, HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/products/{productId}/campaigns")
//    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign){
//        Campaign newCampaign = campaignService.addCampaign(campaign);
//        return new ResponseEntity<>(newCampaign, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/products/{productId}/campaigns/{id}")
//    public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaign, @PathVariable("id")Long id){
//        Campaign updatedCampaign = campaignService.updateCampaign(campaign);
//        return new ResponseEntity<>(updatedCampaign, HttpStatus.OK);
//
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/products/{productId}/campaigns/{id}")
//    public ResponseEntity<?> deleteCampaign(@PathVariable("id")Long id){
//        campaignService.deleteCampaign(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

}
