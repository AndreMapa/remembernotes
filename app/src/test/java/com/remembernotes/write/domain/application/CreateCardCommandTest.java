package com.remembernotes.write.domain.application;


import com.remembernotes.write.domain.core.Card;
import org.junit.jupiter.api.Test;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class CreateCardCommandTest {

    @Test
    void GIVEN_ValidData_MUST_RetrieveSameData(){
        //given
        var externalId = UUID.randomUUID();
        var id = 1;
        var position = 1;
        var frontText = "dummy";
        var backText = "dummy";
        //when
        Card card = new Card(externalId, id, position, frontText, backText);

        //then
        assertThat(card.getExternalId(), equalTo(externalId));
        assertThat(card.getId(), equalTo(id));
        assertThat(card.getPosition(), equalTo(position));
        assertThat(card.getFrontText(), equalTo(frontText));
        assertThat(card.getBackText(), equalTo(backText));

    }
}
