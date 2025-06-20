package com.eazybank.cards.Mapper;

import com.eazybank.cards.dto.CardDto;
import com.eazybank.cards.entity.Card;

public class CardMapper {


    public static Card mapToCard(CardDto cardDto, Card card){
        card.setCardNumber(cardDto.getCardNumber());
        card.setCardType(cardDto.getCardType());
        card.setAmountUsed(cardDto.getAmountUsed());
        card.setAvailableAmount(cardDto.getAvailableAmount());
        card.setMobileNumber(cardDto.getMobileNumber());
        card.setTotalLimit(cardDto.getTotalLimit());
        return card;
    }


    public static CardDto mapToCardDto(Card card, CardDto cardDto){
        cardDto.setAmountUsed(card.getAmountUsed());
        cardDto.setCardNumber(card.getCardNumber());
        cardDto.setCardType(card.getCardType());
        cardDto.setAvailableAmount(card.getAvailableAmount());
        cardDto.setTotalLimit(card.getTotalLimit());
        cardDto.setMobileNumber(card.getMobileNumber());
        return cardDto;

    }
}
