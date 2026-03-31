package io.github.iamjunhyeok.multitenantdemo.controller;

import io.github.iamjunhyeok.multitenant.web.TenantRequired;
import io.github.iamjunhyeok.multitenantdemo.domain.Tenant;
import io.github.iamjunhyeok.multitenantdemo.service.TenantService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TenantController {

  private final TenantService tenantService;

  @TenantRequired
  @GetMapping("/tenants")
  public List<Tenant> getTenants() {
    return tenantService.getTenants();
  }
}
