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

    @Autowired
    private DrugOrderService drugOrderService;

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

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map5 = drugOrderService.getDrugOrderHashmap(idrs);
        HashMap<String, Integer> hash_map5res = new HashMap<String, Integer>();

        if(hash_map5.size() <= 5){
            arr.add(hash_map5);
        } else {
            List<String> top5key = sortHashMap(hash_map5).subList(0, 5);
            for(String key : top5key){
                hash_map5res.put(key,hash_map5.get(key));
            }
            arr.add(hash_map5res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map6 = drugOrderService.getDrugOrderFilterHashmap(idrs,1);
        HashMap<String, Integer> hash_map6res = new HashMap<String, Integer>();

        if(hash_map6.size() <= 5){
            arr.add(hash_map6);
        } else {
            List<String> top5key = sortHashMap(hash_map6).subList(0, 5);
            for(String key : top5key){
                hash_map6res.put(key,hash_map6.get(key));
            }
            arr.add(hash_map6res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map7 = drugOrderService.getDrugOrderFilterHashmap(idrs,2);
        HashMap<String, Integer> hash_map7res = new HashMap<String, Integer>();

        if(hash_map7.size() <= 5){
            arr.add(hash_map7);
        } else {
            List<String> top5key = sortHashMap(hash_map7).subList(0, 5);
            for(String key : top5key){
                hash_map7res.put(key,hash_map7.get(key));
            }
            arr.add(hash_map7res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map8 = drugOrderService.getDrugOrderFilterHashmap(idrs,3);
        HashMap<String, Integer> hash_map8res = new HashMap<String, Integer>();

        if(hash_map8.size() <= 5){
            arr.add(hash_map8);
        } else {
            List<String> top5key = sortHashMap(hash_map8).subList(0, 5);
            for(String key : top5key){
                hash_map8res.put(key,hash_map8.get(key));
            }
            arr.add(hash_map8res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map9 = drugOrderService.getDrugOrderFilterHashmap(idrs,4);
        HashMap<String, Integer> hash_map9res = new HashMap<String, Integer>();

        if(hash_map9.size() <= 5){
            arr.add(hash_map9);
        } else {
            List<String> top5key = sortHashMap(hash_map9).subList(0, 5);
            for(String key : top5key){
                hash_map9res.put(key,hash_map9.get(key));
            }
            arr.add(hash_map9res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map10 = drugOrderService.getDrugOrderFilterHashmap(idrs,5);
        HashMap<String, Integer> hash_map10res = new HashMap<String, Integer>();

        if(hash_map10.size() <= 5){
            arr.add(hash_map10);
        } else {
            List<String> top5key = sortHashMap(hash_map10).subList(0, 5);
            for(String key : top5key){
                hash_map10res.put(key,hash_map10.get(key));
            }
            arr.add(hash_map10res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map11 = drugOrderService.getDrugOrderFilterHashmap(idrs,6);
        HashMap<String, Integer> hash_map11res = new HashMap<String, Integer>();

        if(hash_map11.size() <= 5){
            arr.add(hash_map11);
        } else {
            List<String> top5key = sortHashMap(hash_map11).subList(0, 5);
            for(String key : top5key){
                hash_map11res.put(key,hash_map11.get(key));
            }
            arr.add(hash_map11res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map12 = drugOrderService.getDrugOrderFilterHashmap(idrs,7);
        HashMap<String, Integer> hash_map12res = new HashMap<String, Integer>();

        if(hash_map12.size() <= 5){
            arr.add(hash_map12);
        } else {
            List<String> top5key = sortHashMap(hash_map12).subList(0, 5);
            for(String key : top5key){
                hash_map12res.put(key,hash_map12.get(key));
            }
            arr.add(hash_map12res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map13 = drugOrderService.getDrugOrderFilterHashmap(idrs,8);
        HashMap<String, Integer> hash_map13res = new HashMap<String, Integer>();

        if(hash_map13.size() <= 5){
            arr.add(hash_map13);
        } else {
            List<String> top5key = sortHashMap(hash_map13).subList(0, 5);
            for(String key : top5key){
                hash_map13res.put(key,hash_map13.get(key));
            }
            arr.add(hash_map13res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map14 = drugOrderService.getDrugOrderFilterHashmap(idrs,9);
        HashMap<String, Integer> hash_map14res = new HashMap<String, Integer>();

        if(hash_map14.size() <= 5){
            arr.add(hash_map14);
        } else {
            List<String> top5key = sortHashMap(hash_map14).subList(0, 5);
            for(String key : top5key){
                hash_map14res.put(key,hash_map14.get(key));
            }
            arr.add(hash_map14res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map15 = drugOrderService.getDrugOrderFilterHashmap(idrs,10);
        HashMap<String, Integer> hash_map15res = new HashMap<String, Integer>();

        if(hash_map15.size() <= 5){
            arr.add(hash_map15);
        } else {
            List<String> top5key = sortHashMap(hash_map15).subList(0, 5);
            for(String key : top5key){
                hash_map15res.put(key,hash_map15.get(key));
            }
            arr.add(hash_map15res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map16 = drugOrderService.getDrugOrderFilterHashmap(idrs,11);
        HashMap<String, Integer> hash_map16res = new HashMap<String, Integer>();

        if(hash_map16.size() <= 5){
            arr.add(hash_map16);
        } else {
            List<String> top5key = sortHashMap(hash_map16).subList(0, 5);
            for(String key : top5key){
                hash_map16res.put(key,hash_map16.get(key));
            }
            arr.add(hash_map16res);
        }

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map17 = drugOrderService.getDrugOrderFilterHashmap(idrs,12);
        HashMap<String, Integer> hash_map17res = new HashMap<String, Integer>();

        if(hash_map17.size() <= 5){
            arr.add(hash_map17);
        } else {
            List<String> top5key = sortHashMap(hash_map17).subList(0, 5);
            for(String key : top5key){
                hash_map17res.put(key,hash_map17.get(key));
            }
            arr.add(hash_map17res);
        }

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
