package tk.propensi.medix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.propensi.medix.dto.RumahSakitDataDTO;
import tk.propensi.medix.models.RumahSakitModel;
import tk.propensi.medix.models.UserModel;
import tk.propensi.medix.repository.RumahSakitDB;

import java.util.List;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RumahSakitServiceImpl implements RumahSakitService{
    @Autowired
    private RumahSakitDB rumahsakitDb;

    public RumahSakitModel getRumahSakitByNamaRS(String namaRS){
        return rumahsakitDb.findByNamaRumahSakit(namaRS);
    }


    public List<RumahSakitModel> getRumahSakitList(String keyword){
        if (keyword != null){
            //return rumahsakitDb.search(keyword);
        }
        return rumahsakitDb.findAll();
    }

    public UserModel getUserRumahSakit(String namaRS, int role){
        List<UserModel> listUser = rumahsakitDb.findByNamaRumahSakit(namaRS).getUserRumahSakit();         
        UserModel user = null; 
        if (role == 1) {
            for (UserModel userModel : listUser) {
                if (userModel.getRole().getId() == 1) {
                    user = userModel; 
                }
            }
        } else if (role == 2){
            for (UserModel userModel : listUser) {
                if (userModel.getRole().getId() == 2) {
                    user = userModel; 
                }
            }
        } else if (role == 3){
            for (UserModel userModel : listUser) {
                if (userModel.getRole().getId() == 3) {
                    user = userModel; 
                }
            }
        } 
        
        return user; 
    }; 

    public int getJumlahRumahSakit(){
        int jumlahRumahSakit = 0;
        Iterable<RumahSakitModel> rumahSakitListAll = rumahsakitDb.findAll();

        List<RumahSakitModel> rumahSakitList = new ArrayList<>();
        rumahSakitListAll.forEach(rumahSakitList::add);

        for (RumahSakitModel rs : rumahSakitList){
            jumlahRumahSakit++;
        }

        return jumlahRumahSakit;
    }

    public void updateRSData(RumahSakitModel rs){
        rumahsakitDb.save(rs);
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
