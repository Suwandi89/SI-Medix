package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "resume_medis")
public class ResumeMedisModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "resume_medis_id")
    private String resumeMedisID;

    @Size(max = 50)
    @Column(name = "admission_id")
    private String admission_id;

    @Size(max = 50)
    @Column(name = "person_id")
    private String personId;

    @Size(max = 50)
    @Column(name = "rm_id")
    private String rm_id;

    @Size(max = 50)
    @Column(name = "berkas_id")
    private String berkas_id;

    @Size(max = 50)
    @Column(name = "poli_id")
    private String poli_id;

    @Size(max = 50)
    @Column(name = "poli_name")
    private String poli_name;

    @Size(max = 50)
    @Column(name = "alasan_masuk_ri")
    private String alasan_masuk_ri;

    @Size(max = 50)
    @Column(name = "keadaan_umum")
    private String keadaan_umum;

    @Size(max = 50)
    @Column(name = "kesadaran")
    private String kesadaran;

    @Size(max = 50)
    @Column(name = "pemeriksaan_fisik")
    private String pemeriksaan_fisik;

    @Size(max = 50)
    @Column(name = "hasil_penunjang")
    private String hasil_penunjang;

    @Size(max = 2000)
    @Column(name = "diagnosa")
    private String diagnosa;

    @Size(max = 2000)
    @Column(name = "obat_selama_perawatan")
    private String obat_selama_perawatan;

    @Size(max = 2000)
    @Column(name = "obat_pulang")
    private String obat_pulang;

    @Size(max = 50)
    @Column(name = "instruksi_edukasi")
    private String instruksi_edukasi;

    @Size(max = 50)
    @Column(name = "kondisi_mendesak")
    private String kondisi_mendesak;

    @Size(max = 2000)
    @Column(name = "rm_procedure")
    private String rm_procedure;

    @Size(max = 50)
    @Column(name = "procedure_lain")
    private String procedure_lain;

    @Size(max = 50)
    @Column(name = "ttd_wali")
    private String ttd_wali;

    @Size(max = 50)
    @Column(name = "ttd_pasien")
    private String ttd_pasien;

    @Size(max = 50)
    @Column(name = "ttd_dokter")
    private String ttd_dokter;

    @Size(max = 50)
    @Column(name = "ttd_pemberi_kuasa")
    private String ttd_pemberi_kuasa;

    @Size(max = 50)
    @Column(name = "is_active")
    private String is_active;

    @Size(max = 50)
    @Column(name = "tags")
    private String tags;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Column(name = "created_date")
    private Date created_date;

    @Size(max = 50)
    @Column(name = "created_by")
    private String created_by;

    @Size(max = 50)
    @Column(name = "created_by_name")
    private String created_by_name;

    @Column(name = "modified_date")
    private Date modified_date;

    @Size(max = 50)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 50)
    @Column(name = "modified_by_name")
    private String modified_by_name;

    @Column
    private boolean is_hidden; 

    @Column
    private boolean is_flagged;

    @Size(max = 400)
    @Column(name = "komen_flag")
    private String komen_flag;
}
