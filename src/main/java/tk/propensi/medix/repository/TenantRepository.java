package tk.propensi.medix.repository;

import org.springframework.data.repository.CrudRepository;
import tk.propensi.medix.domain.entity.Tenant;

public interface TenantRepository extends CrudRepository<Tenant, String> {
}

