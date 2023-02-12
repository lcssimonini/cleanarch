package com.ada.cleanarch.postalcode;

import static org.junit.jupiter.api.Assertions.*;

import com.ada.cleanarch.postalcode.domain.CEP;
import com.ada.cleanarch.postalcode.domain.CEPModel;
import org.junit.jupiter.api.Test;

// todos os testes relacionados a essa entidade devem ser independentes de
// framework e tecnologia de persistencia
class CEPModelTest {

  // Primeiro teste criado, totalmente independente de integraçao com o framework
  @Test
  public void shouldBuildCEPDataObject() {
    CEP cep = CEPModel.builder().build();

    assertFalse(cep.isValidPostalCode());
  }

  @Test
  public void shouldBuildValidCEPDataObject() {
    CEP cep = CEPModel.builder().postalCode("38408318").build();

    assertTrue(cep.isValidPostalCode());
  }
}
