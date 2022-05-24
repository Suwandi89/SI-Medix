package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.models.DrugOrderModel;
import tk.propensi.medix.models.KunjunganDetilModel;
import tk.propensi.medix.repository.DrugOrderDB;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class DrugOrderServiceImpl implements DrugOrderService{
    @Autowired
    private DrugOrderDB drugOrderDb;

    @Override
    public HashMap<String, Integer> getDrugOrderHashmap(Long idrs){
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
        ArrayList<String> key_list = new ArrayList<String>();

        Iterable<DrugOrderModel> drugListAll = drugOrderDb.findAll();

        List<DrugOrderModel> drugList = new ArrayList<>();
        drugListAll.forEach(drugList::add);

        for (DrugOrderModel drugOrder : drugList){
            if(drugOrder.getRumahSakit().getId() == idrs){
                if(!key_list.contains(drugOrder.getDrug_name())){
                    key_list.add(drugOrder.getDrug_name());
                    hash_map.put(drugOrder.getDrug_name(),1);
                } else {
                    hash_map.replace(drugOrder.getDrug_name(),hash_map.get(drugOrder.getDrug_name())+1);
                }
            }
        }

        return hash_map;
    }

    @Override
    public HashMap<String, Integer> getDrugOrderFilterHashmap(Long idrs, int month){
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();
        ArrayList<String> key_list = new ArrayList<String>();

        Iterable<DrugOrderModel> drugListAll = drugOrderDb.findAll();

        List<DrugOrderModel> drugList = new ArrayList<>();
        drugListAll.forEach(drugList::add);

        for (DrugOrderModel drugOrder : drugList){
            if(drugOrder.getRumahSakit().getId() == idrs){
                if (drugOrder.getCreated_date().getMonth().getValue() == month){
                    if(!key_list.contains(drugOrder.getDrug_name())){
                        key_list.add(drugOrder.getDrug_name());
                        hash_map.put(drugOrder.getDrug_name(),1);
                    } else {
                        hash_map.replace(drugOrder.getDrug_name(),hash_map.get(drugOrder.getDrug_name())+1);
                    }
                }
            }
        }

        return hash_map;
    }
}
