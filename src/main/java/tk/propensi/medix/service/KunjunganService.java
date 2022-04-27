package tk.propensi.medix.service;

import java.util.List;

import tk.propensi.medix.models.KunjunganModel;

public interface KunjunganService {
    KunjunganModel getKunjunganById(String personId);
    List<KunjunganModel> getPasienList(String keyword);
}
