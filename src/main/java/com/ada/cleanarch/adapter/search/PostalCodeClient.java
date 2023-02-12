package com.ada.cleanarch.adapter.search;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PostalCodesClient", url = "${postal-code-service.url}")
public interface PostalCodeClient {

  @GetMapping("{postalCode}/json")
  PostalSearchModel getPostalCodeData(@PathVariable("postalCode") String postalCode);
}
