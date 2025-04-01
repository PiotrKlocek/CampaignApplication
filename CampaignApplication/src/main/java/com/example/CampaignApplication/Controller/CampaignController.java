package com.example.CampaignApplication.Controller;

import com.example.CampaignApplication.Entities.Campaign;
import com.example.CampaignApplication.Service.CampaignService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {

    @Autowired
    private CampaignService campaignService;

    @GetMapping
    public List<Campaign> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campaign> getCampaignById(@PathVariable Long id) {
        return campaignService.getCampaignById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Campaign> createCampaign(@PathVariable Long userId, @Valid @RequestBody Campaign campaign) {
        try {
            Campaign createdCampaign = campaignService.createCampaign(userId, campaign);
            return ResponseEntity.ok(createdCampaign);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{userId}/{id}")
    public ResponseEntity<Campaign> updateCampaign(@PathVariable Long userId, @PathVariable Long id, @Valid @RequestBody Campaign campaign) {
        try {
            Campaign updatedCampaign = campaignService.updateCampaign(userId, id, campaign);
            return ResponseEntity.ok(updatedCampaign);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{userId}/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long userId, @PathVariable Long id) {
        try {
            campaignService.deleteCampaign(userId, id);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
