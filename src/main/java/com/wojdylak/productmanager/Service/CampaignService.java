package com.wojdylak.productmanager.Service;

import com.wojdylak.productmanager.exception.CamapaignNotFoundException;
import com.wojdylak.productmanager.model.Campaign;
import com.wojdylak.productmanager.repository.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampaignService {
    private final CampaignRepo campaignRepo;

    @Autowired
    public CampaignService(CampaignRepo campaignRepo) {
        this.campaignRepo = campaignRepo;
    }

    public Campaign addCampaign(Campaign campaign){
        return campaignRepo.save(campaign);
    }

    public List<Campaign> findAllCampaignes(){
        return campaignRepo.findAll();
    }

    public Campaign findCampaignById(Long id){
        return campaignRepo.findCampaignById(id).orElseThrow(()-> new CamapaignNotFoundException("Campaign by id" + id+"was not found"));
    }

    public Campaign update(Campaign campaign){
        return campaignRepo.save(campaign);
    }

    public void delete(Long id){
        campaignRepo.deleteCampaignById(id);
    }
}
