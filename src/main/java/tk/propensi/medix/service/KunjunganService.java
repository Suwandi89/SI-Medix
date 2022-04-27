package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.models.KunjunganModel;

public interface KunjunganService {
    List<KunjunganModel> findAll();
    List<KunjunganModel> getPasienList(String keyword);
}
