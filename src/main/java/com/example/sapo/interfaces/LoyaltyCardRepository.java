package com.example.sapo.interfaces;

import com.example.sapo.entities.LoyaltyCard;
import org.springframework.data.repository.CrudRepository;

public interface LoyaltyCardRepository extends CrudRepository<LoyaltyCard, Integer> {
}
