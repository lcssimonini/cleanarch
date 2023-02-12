package com.ada.cleanarch.adapter.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Entity
@Table(name = "cep_data")
public class CEPDataModel {

  @Id @GeneratedValue Long id;
  String postalCode;
  String address;
  String neighbourhood;
  String city;
  String state;
  LocalDateTime insertedAt;
}
