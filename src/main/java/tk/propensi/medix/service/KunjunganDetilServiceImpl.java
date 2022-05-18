package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.KunjunganDetilModel;
import tk.propensi.medix.models.KunjunganModel;
import tk.propensi.medix.repository.KunjunganDB;
import tk.propensi.medix.repository.KunjunganDetilDB;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class KunjunganDetilServiceImpl implements KunjunganDetilService{
    @Autowired
    private KunjunganDetilDB kunjunganDetilDb;

    @Override
    public int getJumlahBPJS(Long idrs){
        int jumlah = 0;
        Iterable<KunjunganDetilModel> kunjunganListAll = kunjunganDetilDb.findAll();

        List<KunjunganDetilModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganDetilModel kunjunganDetil : kunjunganList){
            if((kunjunganDetil.getBpjs_verification_by() != null) && (kunjunganDetil.getRumahSakit().getId() == idrs)){
                jumlah++;
            }
        }

        return jumlah;
    };

    @Override
    public int getJumlahnonBPJS(Long idrs){
        int jumlah = 0;
        Iterable<KunjunganDetilModel> kunjunganListAll = kunjunganDetilDb.findAll();

        List<KunjunganDetilModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganDetilModel kunjunganDetil : kunjunganList){
            if((kunjunganDetil.getBpjs_verification_by() == null) && (kunjunganDetil.getRumahSakit().getId() == idrs)){
                jumlah++;
            }
        }

        return jumlah;
    };

    @Override
    public HashMap<String, Integer> getJenisKonsultasiHashmap(Long idrs){
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
        ArrayList<String> key_list = new ArrayList<String>();

        Iterable<KunjunganDetilModel> kunjunganListAll = kunjunganDetilDb.findAll();

        List<KunjunganDetilModel> kunjunganList = new ArrayList<>();
        kunjunganListAll.forEach(kunjunganList::add);

        for (KunjunganDetilModel kunjunganDetil : kunjunganList){
            if(kunjunganDetil.getRumahSakit().getId() == idrs){
                if(!key_list.contains(kunjunganDetil.getKonsul())){
                    key_list.add(kunjunganDetil.getKonsul());
                    hash_map.put(kunjunganDetil.getKonsul(),1);
                } else {
                    hash_map.replace(kunjunganDetil.getKonsul(),hash_map.get(kunjunganDetil.getKonsul())+1);
                }
            }
        }

        return hash_map;
    };
}
