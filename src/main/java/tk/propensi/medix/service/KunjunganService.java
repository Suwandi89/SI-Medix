package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.models.KunjunganModel;

public interface KunjunganService {
    int getJumlahJenisKelaminPria(Long idrs);
    int getJumlahJenisKelaminWanita(Long idrs);
    List<KunjunganModel> getKunjunganById(String personId);
    List<KunjunganModel> getPasienList(String keyword);
    List<KunjunganModel> filterList(String filter);
    List<String>getnamaRS();
}
