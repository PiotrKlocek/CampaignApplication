package com.example.CampaignApplication.Service;

import com.example.CampaignApplication.Entities.Campaign;
import com.example.CampaignApplication.Entities.User;
import com.example.CampaignApplication.Repository.CampaignRepository;
import com.example.CampaignApplication.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    @Autowired
    private CampaignRepository campaignRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Campaign> getAllCampaigns() {
        return campaignRepository.findAll();
    }

    public Optional<Campaign> getCampaignById(Long id) {
        return campaignRepository.findById(id);
    }

    public Campaign createCampaign(Long userId, Campaign campaign) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getEmeraldBalance() < campaign.getCampaignFund()) {
            throw new RuntimeException("Not enough Emeralds to fund this campaign");
        }
        user.setEmeraldBalance(user.getEmeraldBalance() - campaign.getCampaignFund());
        userRepository.save(user);

        campaign.setUser(user);
        return campaignRepository.save(campaign);
    }

    public Campaign updateCampaign(Long userId, Long id, Campaign campaignDetails) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        if (!campaign.getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot update a campaign you do not own.");
        }

        User user = campaign.getUser();
        double oldFund = campaign.getCampaignFund();
        double newFund = campaignDetails.getCampaignFund();
        double fundDifference = newFund - oldFund;

        if (fundDifference > 0) {
            if (user.getEmeraldBalance() < fundDifference) {
                throw new RuntimeException("Not enough Emeralds to increase campaign fund");
            }
            user.setEmeraldBalance(user.getEmeraldBalance() - fundDifference);
        } else if (fundDifference < 0) {
            user.setEmeraldBalance(user.getEmeraldBalance() - fundDifference);
        }

        userRepository.save(user);

        campaign.setCampaignName(campaignDetails.getCampaignName());
        campaign.setKeywords(campaignDetails.getKeywords());
        campaign.setBidAmount(campaignDetails.getBidAmount());
        campaign.setCampaignFund(campaignDetails.getCampaignFund());
        campaign.setStatus(campaignDetails.isStatus());
        campaign.setCity(campaignDetails.getCity());
        campaign.setRadius(campaignDetails.getRadius());

        return campaignRepository.save(campaign);
    }

    public void deleteCampaign(Long userId, Long id) {
        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        if (!campaign.getUser().getId().equals(userId)) {
            throw new RuntimeException("You cannot delete a campaign you do not own.");
        }

        User user = campaign.getUser();
        user.setEmeraldBalance(user.getEmeraldBalance() + campaign.getCampaignFund());
        userRepository.save(user);

        campaignRepository.delete(campaign);
    }
}
