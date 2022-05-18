package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.repository.KunjunganDB;
import tk.propensi.medix.models.*;
import tk.propensi.medix.repository.RekamMedisDB;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
@Service
@Transactional
public class RekamMedisServiceImpl implements RekamMedisService {

    @Autowired
    RekamMedisDB rekamMedisDB;

    public List<ResumeMedisModel> getRekamMedisByPersonId (String personId){
        return rekamMedisDB.findAllByPersonId(personId);
    }

    public ResumeMedisModel getRekamMedisByResumeID(String resumeMedisId){
        return rekamMedisDB.findByResumeMedisID(resumeMedisId);


    }

    public List<ResumeMedisModel> filterHidden (List<ResumeMedisModel> listResume){
        List<ResumeMedisModel> filtered = new ArrayList<ResumeMedisModel>(); 
        for (ResumeMedisModel resumeMedisModel : listResume) {
            if (!resumeMedisModel.is_hidden()) {
                filtered.add(resumeMedisModel); 
            }
        }
        return filtered; 
    }; 

    public void hideData(String resumeMedisID){
        ResumeMedisModel resumeMedis = getRekamMedisByResumeID(resumeMedisID); 
        resumeMedis.set_hidden(true);
    }

    public void memberiFlag(String resumeMedisID, String komen_flag){
        ResumeMedisModel flagged_rm = getRekamMedisByResumeID(resumeMedisID);
        flagged_rm.setKomen_flag(komen_flag);
        flagged_rm.set_flagged(true);
        

    }

    @Override
    public List<ResumeMedisModel> getRekamMedisList(String keyword){
        if (keyword != null){
            return rekamMedisDB.search(keyword);
        }
        return rekamMedisDB.findAll();
    }

    public void unflag(String resumeMedisID){
        ResumeMedisModel flagged_rm = getRekamMedisByResumeID(resumeMedisID);
        flagged_rm.setKomen_flag(null);
        flagged_rm.set_flagged(false);
        

    }
}
