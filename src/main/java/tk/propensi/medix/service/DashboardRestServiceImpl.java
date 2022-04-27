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

        hash_map2.put("Pria",kunjunganService.getJumlahJenisKelaminPria(idrs));
        hash_map2.put("Wanita",kunjunganService.getJumlahJenisKelaminWanita(idrs));

        arr.add(hash_map2);

        return arr;

    }
}
