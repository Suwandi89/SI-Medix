package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.LabResultModel;

@Repository
public interface LabResultDB extends JpaRepository<LabResultModel,Long>{

}
