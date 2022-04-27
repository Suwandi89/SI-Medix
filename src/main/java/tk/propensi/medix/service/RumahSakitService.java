package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RumahSakitModel;

public interface RumahSakitService {
    RumahSakitModel getRumahSakitByNamaRS(String namaRS);
    List<RumahSakitModel> getRumahSakitList(String keyword); 
    void addRSData(RumahSakitModel rumahSakit, RumahSakitDataDTO form);
}
