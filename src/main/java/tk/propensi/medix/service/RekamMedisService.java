package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.models.ResumeMedisModel;

public interface RekamMedisService {
    List<ResumeMedisModel> getRekamMedisByPersonId (String personId);
    ResumeMedisModel getRekamMedisByResumeID(String resumeMedisID);
    List<ResumeMedisModel> filterHidden (List<ResumeMedisModel> listResume); 
    void hideData(String resumeMedisID); 
    void memberiFlag(String resumeMedisID, String komen_flag);
    List<ResumeMedisModel> getRekamMedisList(String keyword);
    void unflag(String resumeMedisID);
}
