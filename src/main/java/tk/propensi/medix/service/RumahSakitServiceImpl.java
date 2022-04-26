package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.repository.RumahSakitDB;

import javax.transaction.Transactional;

@Service
@Transactional
public class RumahSakitServiceImpl implements RumahSakitService{
    @Autowired
    private RumahSakitDB rumahsakitDb;

    public RumahSakitModel getRumahSakitByNamaRS(String namaRS){
        return rumahsakitDb.findByNamaRumahSakit(namaRS);
    }

    public void addRSData(RumahSakitModel rumahSakit, RumahSakitDataDTO form){
        rumahSakit.setJalan(form.jalan);
        rumahSakit.setJenis(form.jenis);
        rumahSakit.setKecamatan(form.kecamatan);
        rumahSakit.setKelurahan(form.kelurahan);
        rumahSakit.setKabupaten(form.kabupaten);
        rumahSakit.setProvinsi(form.provinsi);
        rumahSakit.setKodepos(form.kodepos);
        rumahSakit.setNotelp(form.notelp);
        rumahSakit.setEmail(form.email);
        rumahSakit.setWebsite(form.website);
        rumahsakitDb.save(rumahSakit);
    }
}
