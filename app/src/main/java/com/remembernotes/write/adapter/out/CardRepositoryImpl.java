package com.remembernotes.write.adapter.out;

import com.remembernotes.write.domain.core.Card;
import com.remembernotes.write.domain.core.CardRepository;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class CardRepositoryImpl implements CardRepository {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public CardRepositoryImpl(DataSource dataSource) {
        jdbcTemplate= new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void create(Card card) {

        String sql = "INSERT INTO card(externalId, position, frontText, backText) values( :externalId, :position, :frontText, :backText)";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("uuid", card.getExternalId())
                .addValue("position", card.getPosition())
                .addValue("frontText", card.getFrontText())
                .addValue("backText", card.getBackText());


        jdbcTemplate.update(sql, parameters);

    }
}
