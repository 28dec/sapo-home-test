package com.example.sapo.controllers;

import com.example.sapo.interfaces.ConfigRepository;
import com.example.sapo.interfaces.LoyaltyCardRepository;
import com.example.sapo.interfaces.LoyaltyCardTypeRepository;
import com.example.sapo.interfaces.TransactionRepository;
import com.example.sapo.entities.Config;
import com.example.sapo.entities.LoyaltyCard;
import com.example.sapo.entities.LoyaltyCardType;
import com.example.sapo.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
@RequestMapping(path="/api")
public class MainController {
  @Autowired private ConfigRepository configRepository;
  @Autowired private TransactionRepository transactionRepository;
  @Autowired private LoyaltyCardRepository loyaltyCardRepository;
  @Autowired private LoyaltyCardTypeRepository loyaltyCardTypeRepository;
  @PostMapping(path="/config")
  public @ResponseBody String addNewConfig (@RequestParam int value) {
      Config c = new Config();
      c.setConfig(value);
      configRepository.save(c);
      return("new config saved!");
  }

  @GetMapping(path="/config")
  public @ResponseBody Iterable<Config> getAllConfigs() {
    return configRepository.findAll();
  }

  @PostMapping(path="/transaction")
  public @ResponseBody String addNewTransaction(@RequestParam int cardId, @RequestParam double spentAdjust){
      Config currentConfig = configRepository.findTopByOrderByIdDesc();
      int currentConfigId = currentConfig.getId();
      int currentConfigValue = currentConfig.getConfig();

      Transaction t = new Transaction();
      t.setLoyaltycardId(cardId);
      t.setSpentAdjust(spentAdjust);
      t.setConfigId(currentConfigId);
      t.setPointAdjust(spentAdjust/currentConfigValue);
      transactionRepository.save(t);

      updateLoyaltycard(cardId, spentAdjust, currentConfigValue);

      return("new transaction saved!");
  }

  @GetMapping(path="/transaction")
    public @ResponseBody Iterable<Transaction> getAllTransactions(){
      return transactionRepository.findAll();
  }

  boolean updateLoyaltycard(int cardId, double spentAdjust, int configValue){
      LoyaltyCard card = getCardById(cardId);
      LoyaltyCardType currentCardType = getCardTypeById(card.getLoyaltycardtypeId());
      LoyaltyCardType nextCardType = getCardTypeById(card.getLoyaltycardtypeId()+1);
      Optional<LoyaltyCard> cardFinder = loyaltyCardRepository.findById(cardId);
      double newRevenue = card.getRevenue() + spentAdjust;
      double newPoint = card.getPoint() + spentAdjust / configValue;
      card.setRevenue(newRevenue);
      card.setPoint(newPoint);
      if(newRevenue < currentCardType.getSpentThreshold()){
          card.setLoyaltycardtypeId(currentCardType.getId()-1);
      }
      if(nextCardType != null && newRevenue >= nextCardType.getSpentThreshold()){
          card.setLoyaltycardtypeId(currentCardType.getId()+1);
      }
      loyaltyCardRepository.save(card);
      return true;
  }


  LoyaltyCard getCardById(int cardId){
      Optional<LoyaltyCard> cardFinder = loyaltyCardRepository.findById(cardId);
      LoyaltyCard card = null;
      if(!cardFinder.isPresent()) {
          System.out.printf("No card found with cardId = %d%n", cardId);
          return null;
      }
      return cardFinder.get();
  }


  LoyaltyCardType getCardTypeById(int typeId){
      Optional<LoyaltyCardType> cardTypeFinder = loyaltyCardTypeRepository.findById(typeId);
      if(!cardTypeFinder.isPresent()) {
          System.out.printf("No card type found with typeId = %d%n", typeId);
          return null;
      }
      return cardTypeFinder.get();
  }


}