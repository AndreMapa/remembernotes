package com.remembernotes.write.domain.application;

import com.remembernotes.write.adapter.out.CardRepositoryImpl;
import com.remembernotes.write.domain.core.Card;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreateCardCommandHandlerTest {

    ArgumentCaptor<Card> captor = ArgumentCaptor.forClass(Card.class);

    @Test
    void GIVEN_ValidCommand_MUST_DelegateToCardRepository(){

        //1°given
        var id =1;
        var externalId = UUID.randomUUID();
        var position = 1;
        var frontText = "dummy";
        var backText = "dummy";
        var command = new Card(externalId, id, position, frontText, backText);
        var repository = mock(CardRepositoryImpl.class);

        //2°when
        var handler = new CreateCardCommandHandler(repository);
        handler.handle(command);

        //3°then
        verify(repository).create(captor.capture());
        var card = captor.getValue();
        assertThat(card.getExternalId(), equalTo(externalId));
        assertThat(card.getPosition(), equalTo(position));
        assertThat(card.getFrontText(), equalTo(frontText));
        assertThat(card.getBackText(), equalTo(backText));

    }
}
