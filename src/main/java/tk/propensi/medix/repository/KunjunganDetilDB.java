package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.KunjunganDetilModel;

@Repository
public interface KunjunganDetilDB extends JpaRepository<KunjunganDetilModel,Long> {


}
