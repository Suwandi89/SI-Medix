package tk.propensi.medix.service;

import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RumahSakitModel;

public interface RumahSakitService {
    RumahSakitModel getRumahSakitByNamaRS(String namaRS);
    void addRSData(RumahSakitModel rumahSakit, RumahSakitDataDTO form);
}
