package com.eazybank.cards.service;


import com.eazybank.cards.dto.CardDto;
import org.springframework.stereotype.Service;


public interface ICardService {

    void createCard(String mobileNumber);


    boolean updateCard(CardDto cardDto);


    CardDto fetchCardDetails(String mobileNumber);

    boolean deleteCard(String mobileNumber);
}
