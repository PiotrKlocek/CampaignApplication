package com.example.CampaignApplication.Repository;

import com.example.CampaignApplication.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
