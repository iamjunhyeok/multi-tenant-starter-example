package io.github.iamjunhyeok.multitenantdemo.service;

import io.github.iamjunhyeok.multitenantdemo.domain.Tenant;
import io.github.iamjunhyeok.multitenantdemo.repository.TenantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TenantService {

  private final TenantRepository tenantRepository;

  public List<Tenant> getTenants() {
    return tenantRepository.findAll();
  }

}
