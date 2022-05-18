package tk.propensi.medix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tk.propensi.medix.models.DrugOrderModel;

@Repository
public interface DrugOrderDB extends JpaRepository<DrugOrderModel,Long> {

}
