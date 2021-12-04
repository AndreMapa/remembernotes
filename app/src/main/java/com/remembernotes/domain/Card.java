package com.remembernotes.domain;

import java.util.UUID;

public class Card {


    private final UUID externalId;
    private final int id;
    private final int position;
    private final String frontText;
    private final String backText;

    public Card(UUID externalId, int id, int position, String frontText, String backText) {
        this.externalId = externalId;
        this.id = id;
        this.position = position;
        this.frontText = frontText;
        this.backText = backText;
    }

    public UUID getExternalId() {
        return externalId;
    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getFrontText() {
        return frontText;
    }

    public String getBackText() {
        return backText;
    }
}
