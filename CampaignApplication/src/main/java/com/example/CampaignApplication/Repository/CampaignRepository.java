package com.example.CampaignApplication.Repository;

import com.example.CampaignApplication.Entities.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}