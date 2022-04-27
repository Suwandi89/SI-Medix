package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.repository.KunjunganDB;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KunjunganServiceImpl implements KunjunganService{
    @Autowired
    private KunjunganDB kunjunganDb;

    public int getJumlahJenisKelaminPria(Long idrs){
        int jumlah = 0;
        Iterable<KunjunganModel> kunjunganListAll = kunjunganDb.findAll();

        List<KunjunganModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganModel kunjungan : kunjunganList){
            if((kunjungan.getSex().equals("Pria")) && (kunjungan.getRumahSakit().getId() == idrs)){
                jumlah++;
            }
        }

        return jumlah;
    }

    public int getJumlahJenisKelaminWanita(Long idrs){
        int jumlah = 0;
        Iterable<KunjunganModel> kunjunganListAll = kunjunganDb.findAll();

        List<KunjunganModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganModel kunjungan : kunjunganList){
            if((kunjungan.getSex().equals("Wanita")) && (kunjungan.getRumahSakit().getId() == idrs)){
                jumlah++;
            }
        }

        return jumlah;
    }
}
