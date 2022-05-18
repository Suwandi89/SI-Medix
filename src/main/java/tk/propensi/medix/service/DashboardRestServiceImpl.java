package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.LabResultModel;
import tk.propensi.medix.repository.LabResultDB;

import javax.transaction.Transactional;
import java.time.format.TextStyle;
import java.util.*;

@Service
@Transactional
public class DashboardRestServiceImpl implements DashboardRestService{
    @Autowired
    private LabResultDB labResultDb;

    @Autowired
    private KunjunganService kunjunganService;

    @Autowired
    private KunjunganDetilService kunjunganDetilService;

    @Override
    public List<HashMap> getChartData(Long idrs){

        Iterable<LabResultModel> labResultModels = labResultDb.findAll();
        List<LabResultModel> labResult= new ArrayList<>();
        labResultModels.forEach(labResult::add);

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();

        hash_map.put("Jan",0);
        hash_map.put("Feb",0);
        hash_map.put("Mar",0);
        hash_map.put("Apr",0);
        hash_map.put("May",0);
        hash_map.put("Jun",0);
        hash_map.put("Jul",0);
        hash_map.put("Aug",0);
        hash_map.put("Sep",0);
        hash_map.put("Oct",0);
        hash_map.put("Nov",0);
        hash_map.put("Dec",0);

        for(LabResultModel labRes : labResult){
            if(labRes.getRumahSakit().getId() == idrs){
                hash_map.replace(labRes.getCreated_date().getMonth().getDisplayName(TextStyle.SHORT, Locale.US), hash_map.get(labRes.getCreated_date().getMonth().getDisplayName(TextStyle.SHORT, Locale.US))+1);
            }
        }

        List<HashMap> arr = new ArrayList<>();

        arr.add(hash_map);

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map2 = new HashMap<String, Integer>();

        int pria = kunjunganService.getJumlahJenisKelaminPria(idrs);
        int wanita = kunjunganService.getJumlahJenisKelaminWanita(idrs);

        hash_map2.put("Pria",pria);
        hash_map2.put("Wanita", wanita);

        arr.add(hash_map2);

        HashMap<String, Integer> hash_map3 = kunjunganDetilService.getJenisKonsultasiHashmap(idrs);
        HashMap<String, Integer> hash_map3res = new HashMap<String, Integer>();

        if(hash_map3.size() <= 5){
            arr.add(hash_map3);
        } else {
            List<String> top5key = sortHashMap(hash_map3).subList(0, 5);
            for(String key : top5key){
                hash_map3res.put(key,hash_map3.get(key));
            }
            arr.add(hash_map3res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map4 = new HashMap<String, Integer>();

        int bpjs = kunjunganDetilService.getJumlahBPJS(idrs);
        int nonbpjs = kunjunganDetilService.getJumlahnonBPJS(idrs);

        hash_map4.put("bpjs",bpjs);
        hash_map4.put("nonbpjs", nonbpjs);

        arr.add(hash_map4);


        return arr;

    }

    public static List<String> sortHashMap(final HashMap<String, Integer> map) {
        Set<String> set = map.keySet();
        List<String> keys = new ArrayList<String>(set);

        Collections.sort(keys, new Comparator<String>() {

            @Override
            public int compare(String s1, String s2) {
                if (map.get(s1) < map.get(s2)) {
                    return 1;
                }
                return 0;
            }
        });

        return keys;
    }
}
