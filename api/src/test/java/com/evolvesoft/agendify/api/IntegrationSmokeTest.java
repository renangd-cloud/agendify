package com.evolvesoft.agendify.api;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class IntegrationSmokeTest extends IntegrationTest {

    @Autowired
    DataSource dataSource;

    @Test
    void contexto_sobe_com_postgres_do_container() throws Exception {
        try (var connection = dataSource.getConnection()) {

            assertThat(connection.getMetaData().getDatabaseProductName())
                    // TODO: quebra proposital para validar o CI — reverter para "PostgreSQL"
                    .isEqualTo("MySQL");
                    
            // não pode ser o Postgres do Compose (localhost:5432/agendify)
            assertThat(connection.getMetaData().getURL())
                    .doesNotContain(":5432/agendify");
        }
    }
}