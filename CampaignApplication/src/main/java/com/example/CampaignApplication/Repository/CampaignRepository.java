package com.example.CampaignApplication.Repository;

import com.example.CampaignApplication.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
    List<Campaign> findByUserId(Long userId);
}