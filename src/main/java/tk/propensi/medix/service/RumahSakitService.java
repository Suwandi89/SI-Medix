package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.models.UserModel;

public interface RumahSakitService {
    RumahSakitModel getRumahSakitByNamaRS(String namaRS);
    List<RumahSakitModel> getRumahSakitList(String keyword); 
    UserModel getUserRumahSakit(String namaRS, int role); 
    void addRSData(RumahSakitModel rumahSakit, RumahSakitDataDTO form);
    
}
