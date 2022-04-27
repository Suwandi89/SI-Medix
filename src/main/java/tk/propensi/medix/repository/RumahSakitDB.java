package tk.propensi.medix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.RumahSakitModel;

@Repository
public interface RumahSakitDB extends JpaRepository<RumahSakitModel, Long> {
    RumahSakitModel findByNamaRumahSakit(String namaRumahSakit);

    // @Query("SELECT FROM RumahSakitModel")
    // public List<RumahSakitModel> search(String keyword);
}
