package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.models.UserModel;

@Repository
public interface RumahSakitDB extends JpaRepository<RumahSakitModel, Long> {
    RumahSakitModel findByNamaRumahSakit(String namaRumahSakit);
}
