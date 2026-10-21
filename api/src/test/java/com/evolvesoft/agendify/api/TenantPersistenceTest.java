package com.evolvesoft.agendify.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TenantPersistenceTest extends IntegrationTest {

  @Autowired JdbcTemplate jdbc;

  @Test
  void grava_e_le_um_tenant() {
    jdbc.update("INSERT INTO tenant (name) VALUES ('Acme')");

    String name = jdbc.queryForObject("SELECT name FROM tenant WHERE name = 'Acme'", String.class);

    assert (name).equals("Acme");
  }
}
