package tk.propensi.medix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.KunjunganModel;

@Repository
public interface KunjunganDB extends JpaRepository<KunjunganModel,Long> {

    KunjunganModel findByPersonId(String personId);

    @Query("SELECT u FROM KunjunganModel u WHERE CONCAT(u.full_name, u.nik, u.email) LIKE %?1%")
    public List<KunjunganModel> search(String keyword);

}
