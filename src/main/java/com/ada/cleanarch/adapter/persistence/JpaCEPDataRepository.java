package com.ada.cleanarch.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCEPDataRepository extends JpaRepository<CEPDataModel, Long> {

  boolean existsByPostalCode(String postalCode);
}
