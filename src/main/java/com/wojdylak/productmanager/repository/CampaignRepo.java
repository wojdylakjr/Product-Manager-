package com.wojdylak.productmanager.repository;

import com.wojdylak.productmanager.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {
    void deleteCampaignById(Long id);
    Optional<Campaign> findCampaignById(Long id);
}
