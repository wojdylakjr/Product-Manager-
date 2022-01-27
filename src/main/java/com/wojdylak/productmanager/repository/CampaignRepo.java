package com.wojdylak.productmanager.repository;

import com.wojdylak.productmanager.model.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CampaignRepo extends JpaRepository<Campaign, Long> {
  void deleteById(Long id);

  Optional<Campaign> findById(Long id);

  @Query("SELECT c FROM Campaign c WHERE c.product.productId = ?1")
  List<Campaign> findByProductId(Long productId);

//    @Query("SELECT c FROM Campaign c WHERE c.product.productId = ?2 and c.campaignId = ?1")
//    Optional<Campaign> findCampaignByIdInProductId(Long id, Long productId);


}
