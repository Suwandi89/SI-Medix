package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.repository.KunjunganDB;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class KunjunganServiceImpl implements KunjunganService{
    @Autowired
    private KunjunganDB kunjunganDb;

    @Override
    public int getJumlahJenisKelaminPria(Long idrs){
        int jumlah = 0;
        Iterable<KunjunganModel> kunjunganListAll = kunjunganDb.findAll();

        List<KunjunganModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganModel kunjungan : kunjunganList){
            if((kunjungan.getSex().equals("1")) && (kunjungan.getRumahSakit().getId() == idrs)){
                jumlah++;
            }
        }

        return jumlah;
    }

    @Override
    public int getJumlahJenisKelaminWanita(Long idrs) {
        int jumlah = 0;
        Iterable<KunjunganModel> kunjunganListAll = kunjunganDb.findAll();

        List<KunjunganModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganModel kunjungan : kunjunganList) {
            if ((kunjungan.getSex().equals("2")) && (kunjungan.getRumahSakit().getId() == idrs)) {
                jumlah++;
            }
        }

        return jumlah;
    }

    @Override
    public List<KunjunganModel> getKunjunganById(String personId) {
        return kunjunganDb.findByPersonId(personId);
    }

    @Override
    public List<KunjunganModel> getPasienList(String keyword){
        if (keyword != null) {
            return kunjunganDb.search(keyword);
        }
        return kunjunganDb.findAll();
    }

    @Override
    public List<KunjunganModel> filterList(String filter) {
        if (filter != null) {
            return kunjunganDb.filter(filter);
        }
        return kunjunganDb.findAll();
    }

    @Override
    public List<String> getnamaRS() {
        return kunjunganDb.getAllNamaRS();
    }
}
