package com.ada.cleanarch.postalcode;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.ada.cleanarch.postalcode.datasource.CEPRegisterDSGateway;
import com.ada.cleanarch.postalcode.domain.CEPFactory;
import com.ada.cleanarch.postalcode.dto.CEPCreateRequestModel;
import com.ada.cleanarch.postalcode.presenter.CEPPresenter;
import org.junit.jupiter.api.Test;

class CEPRegisterInteractorTest {

  final CEPRegisterDSGateway cepDSGateway = mock(CEPRegisterDSGateway.class);
  final CEPPresenter cepPresenter = mock(CEPPresenter.class);
  final CEPFactory cepFactory = mock(CEPFactory.class);

  final CEPRegisterInteractor registerInteractor =
      new CEPRegisterInteractor(cepDSGateway, cepPresenter, cepFactory);

  // teste da logica de criacao de cep, independente da implementacao de persistencia e da
  // camada de apresentaçao
  @Test
  public void shouldNotCreateCEPAlreadyExists() {
    String postalCode = "7777777";
    CEPCreateRequestModel requestModel =
        CEPCreateRequestModel.builder().postalCode(postalCode).build();

    when(cepDSGateway.existsByPostalCode(postalCode)).thenReturn(true);
    when(cepPresenter.prepareFailView(anyString())).thenThrow(new RuntimeException());
    assertThrows(RuntimeException.class, () -> registerInteractor.create(requestModel));
  }
}
