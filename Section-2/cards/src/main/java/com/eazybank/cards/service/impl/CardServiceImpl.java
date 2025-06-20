package com.eazybank.cards.service.impl;


import com.eazybank.cards.Mapper.CardMapper;
import com.eazybank.cards.constants.CardConstants;
import com.eazybank.cards.dto.CardDto;
import com.eazybank.cards.entity.Card;
import com.eazybank.cards.exceptions.CardAlreadyExistsException;
import com.eazybank.cards.exceptions.ResourceNotFoundException;
import com.eazybank.cards.repo.CardRepository;
import com.eazybank.cards.service.ICardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardService {

    private CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Card> card = cardRepository.findByMobileNumber(mobileNumber);
        if (card.isPresent()){
            throw new CardAlreadyExistsException("Card already exists with mobile number"+mobileNumber);
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    @Override
    public boolean updateCard(CardDto cardDto) {
        Card card = cardRepository.findByMobileNumber(cardDto.getMobileNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", cardDto.getCardNumber())
        );
        CardMapper.mapToCard(cardDto, card);
        cardRepository.save(card);
        return true;
    }

    @Override
    public CardDto fetchCardDetails(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );
        return CardMapper.mapToCardDto(card, new CardDto());
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "Mobile Number", mobileNumber)
        );
        cardRepository.deleteById(card.getCardId());
        return true;
    }


    private Card createNewCard(String mobileNumber){
        Card card = new Card();
        long cardNumber = 10_00_00_00_00 + new Random().nextInt(9_00_00_00_00);
        card.setCardNumber(Long.toString(cardNumber));
        card.setCardType(CardConstants.CREDIT_CARD);
        card.setMobileNumber(mobileNumber);
        card.setAmountUsed(0);
        card.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        card.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return card;
    }


}
