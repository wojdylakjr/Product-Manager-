package com.wojdylak.productmanager.service;

import com.wojdylak.productmanager.exception.CamapaignNotFoundException;
import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {
    private CampaignRepo campaignRepo;

    @Autowired
    public CampaignService(CampaignRepo campaignRepo) {
        this.campaignRepo = campaignRepo;
    }

    public Campaign addCampaign(Campaign campaign){
        return campaignRepo.save(campaign);
    }

    public List<Campaign> findAllCampaigns(){
        return campaignRepo.findAll();
    }

    public Campaign findCampaignById(Long id){
        return campaignRepo.findById(id).orElseThrow(()-> new CamapaignNotFoundException("Campaign by id" + id+" was not found"));
    }

//    public List<Campaign> getAllCampaignsByProductId(Long productId){
//        //        campaignRepo.findByProductId(p bn  roductId).forEach(campaigns::add);
//        return new ArrayList<>(campaignRepo.findByProductId(productId));
//    }

    public Campaign updateCampaign(Campaign campaign){
        return campaignRepo.save(campaign);
    }

    public void deleteCampaign(Long id){
        campaignRepo.deleteById(id);
    }

//    public Campaign findCampaignByIdInProductId(Long id, Long productId) {
//        return campaignRepo.findCampaignByIdInProductId(id,productId).orElseThrow(()-> new CamapaignNotFoundException("Campaign by id" + id+" was not found"));
//    }
}

