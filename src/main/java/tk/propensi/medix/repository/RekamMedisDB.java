package tk.propensi.medix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.ResumeMedisModel;

public interface RekamMedisDB extends JpaRepository<ResumeMedisModel, Long>{
    List<ResumeMedisModel> findAllByPersonId(String personId);
}
