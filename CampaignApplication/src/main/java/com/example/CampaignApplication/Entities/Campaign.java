package com.example.CampaignApplication.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CAMPAIGN")
public class Campaign {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @NotNull(message = "Campaign name is mandatory")
   @Column(name = "campaign_name")
   private String campaignName;

   @NotNull(message = "Keywords are mandatory")
   @Column(name = "keywords")
   private String keywords;

   @NotNull(message = "Bid amount is mandatory")
   @Min(value = 1, message = "Bid amount must be at least 1")
   @Column(name = "bid_amount")
   private double bidAmount;

   @NotNull(message = "Campaign fund is mandatory")
   @Column(name = "campaign_fund")
   private double campaignFund;

   @Column(name = "status")
   private boolean status;

   @NotNull(message = "City ID is mandatory")
   @Column(name = "city_id")
   private Long cityId;

   @NotNull(message = "Radius is mandatory")
   @Min(value = 1, message = "Radius must be at least 1")
   @Column(name = "radius")
   private int radius;

   @ManyToOne
   @JoinColumn(name = "user_id", nullable = false)
   private User user;
}