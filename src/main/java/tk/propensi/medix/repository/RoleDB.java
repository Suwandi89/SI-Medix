package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.RoleModel;

@Repository
public interface RoleDB extends JpaRepository<RoleModel,Long> {
}
