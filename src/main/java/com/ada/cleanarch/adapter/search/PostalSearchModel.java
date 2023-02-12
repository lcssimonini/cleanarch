package com.ada.cleanarch.adapter.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostalSearchModel {

  @JsonProperty("cep")
  private String postalCode;

  @JsonProperty("logradouro")
  private String address;

  @JsonProperty("complemento")
  private String complement;

  @JsonProperty("bairro")
  private String neighbourhood;

  @JsonProperty("localidade")
  private String city;

  @JsonProperty("uf")
  private String state;

  @JsonProperty("ddd")
  private String areaCode;
}
