package tk.propensi.medix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.ResumeMedisModel;
import tk.propensi.medix.models.UserModel;

public interface RekamMedisDB extends JpaRepository<ResumeMedisModel, Long>{
    List<ResumeMedisModel> findAllByPersonId(String personId);

    ResumeMedisModel findByResumeMedisID(String resumeMedisID);

    @Query("SELECT u FROM ResumeMedisModel u WHERE CONCAT(u.personId, u.resumeMedisID) LIKE %?1%")
    public List<ResumeMedisModel> search(String keyword);




}
