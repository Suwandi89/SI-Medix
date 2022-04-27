package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.KunjunganModel;

@Repository
public interface KunjunganDB extends JpaRepository<KunjunganModel,Long>{

}
