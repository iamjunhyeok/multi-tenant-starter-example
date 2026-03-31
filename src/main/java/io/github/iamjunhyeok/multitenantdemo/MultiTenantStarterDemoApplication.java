package io.github.iamjunhyeok.multitenantdemo;

import io.github.iamjunhyeok.multitenant.core.TenantContext;
import io.github.iamjunhyeok.multitenant.core.TenantContextHolder;
import io.github.iamjunhyeok.multitenant.core.TenantId;
import io.github.iamjunhyeok.multitenantdemo.domain.Tenant;
import io.github.iamjunhyeok.multitenantdemo.domain.User;
import io.github.iamjunhyeok.multitenantdemo.repository.TenantRepository;
import io.github.iamjunhyeok.multitenantdemo.repository.UserRepository;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiTenantStarterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantStarterDemoApplication.class, args);
	}

	@Bean
	ApplicationRunner appRunner(TenantRepository tenantRepository, UserRepository userRepository) {
		return args -> {
			Tenant tenantA = createTenant("회사 A");
			Tenant tenantB = createTenant("회사 B");
			tenantRepository.saveAll(List.of(tenantA, tenantB));

			TenantContextHolder.setContext(new TenantContext(new TenantId(String.valueOf(tenantA.getId()))));
			userRepository.saveAll(List.of(
					createUser("홍길동", "password1"),
					createUser("김철수", "password2")
			));

			TenantContextHolder.setContext(new TenantContext(new TenantId(String.valueOf(tenantB.getId()))));
			userRepository.saveAll(List.of(
					createUser("이영희", "password3")
			));
			TenantContextHolder.clear();
		};
	}

	private Tenant createTenant(String name) {
		Tenant tenant = new Tenant();
		tenant.setName(name);
		return tenant;
	}

	private User createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		return user;
	}
}
