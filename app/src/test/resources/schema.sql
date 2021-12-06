CREATE TABLE card(
    id SERIAL PRIMARY KEY,
    externalId UUID NOT NULL,
    position INTEGER NOT NULL,
    frontText VARCHAR NOT NULL,
    backText VARCHAR NOT NULL);
