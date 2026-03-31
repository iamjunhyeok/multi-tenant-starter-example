package io.github.iamjunhyeok.multitenantdemo.repository;

import io.github.iamjunhyeok.multitenantdemo.domain.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

}