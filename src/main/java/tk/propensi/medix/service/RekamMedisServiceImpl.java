package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.repository.KunjunganDB;
import tk.propensi.medix.models.*;
import tk.propensi.medix.repository.RekamMedisDB;

import java.util.List;

import javax.transaction.Transactional;
@Service
@Transactional
public class RekamMedisServiceImpl implements RekamMedisService {
    
    @Autowired
    RekamMedisDB rekamMedis;

    public List<ResumeMedisModel> getRekamMedisByIdPasien (String IdPasien){
        return rekamMedis.findAllByPersonid(IdPasien);
    }
}
