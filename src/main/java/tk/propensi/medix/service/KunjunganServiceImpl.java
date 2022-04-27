package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.repository.KunjunganDB;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class KunjunganServiceImpl implements KunjunganService{
    @Autowired
    KunjunganDB kunjunganDB;

    @Override
    public List<KunjunganModel> findAll(){ 
        return kunjunganDB.findAll();
    }

    @Override
    public List<KunjunganModel> getPasienList(String keyword){ 
        if (keyword != null){
            return kunjunganDB.search(keyword);
        }
        return kunjunganDB.findAll();
    }
}
