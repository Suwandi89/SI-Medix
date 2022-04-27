package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.models.ResumeMedisModel;

public interface RekamMedisService {
    List<ResumeMedisModel> getRekamMedisByIdPasien (String IdPasien);
}
