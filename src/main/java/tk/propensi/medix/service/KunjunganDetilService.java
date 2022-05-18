package tk.propensi.medix.service;

import java.util.HashMap;

public interface KunjunganDetilService {
    int getJumlahBPJS(Long idrs);
    int getJumlahnonBPJS(Long idrs);
    HashMap<String, Integer> getJenisKonsultasiHashmap(Long idrs);
}
