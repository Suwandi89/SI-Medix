package tk.propensi.medix.service;

import java.util.HashMap;

public interface DrugOrderService {
    HashMap<String, Integer> getDrugOrderHashmap(Long idrs);
    HashMap<String, Integer> getDrugOrderFilterHashmap(Long idrs, int month);
}
