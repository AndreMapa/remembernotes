package com.remembernotes.write.domain.application;

import com.remembernotes.write.adapter.out.CardRepositoryImpl;
import com.remembernotes.write.domain.core.Card;
import com.remembernotes.write.domain.core.CardRepository;

public class CreateCardCommandHandler {

    private final CardRepository repository;

    public CreateCardCommandHandler(CardRepositoryImpl repository) {
        this.repository = repository;
    }

    public void handle(Card card){
        var command = new Card(card.getExternalId(), card.getId(), card.getPosition(), card.getFrontText(), card.getBackText());
        repository.create(command);
    }

}
