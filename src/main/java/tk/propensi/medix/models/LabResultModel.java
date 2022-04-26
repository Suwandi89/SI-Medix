package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "lab_result")
public class LabResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "procedure_taken_id")
    private String procedure_taken_id;

    @Size(max = 50)
    @Column(name = "procedure_no")
    private String procedure_no;

    @Size(max = 50)
    @Column(name = "procedure_id")
    private String procedure_id;

    @Size(max = 50)
    @Column(name = "admission_id")
    private String admission_id;

    @Size(max = 50)
    @Column(name = "person_id")
    private String person_id;

    @Size(max = 50)
    @Column(name = "rm_id")
    private String rm_id;

    @Size(max = 50)
    @Column(name = "berkas_id")
    private String berkas_id;

    @Size(max = 50)
    @Column(name = "test_cd")
    private String test_cd;

    @Size(max = 50)
    @Column(name = "test_name")
    private String test_name;

    @Size(max = 50)
    @Column(name = "test_group")
    private String test_group;

    @Size(max = 50)
    @Column(name = "ukuran")
    private String ukuran;

    @Size(max = 50)
    @Column(name = "satuan")
    private String satuan;

    @Size(max = 50)
    @Column(name = "nilai_rujukan")
    private String nilai_rujukan;

    @Size(max = 50)
    @Column(name = "flag")
    private String flag;

    @Size(max = 100)
    @Column(name = "hasil")
    private String hasil;

    @Size(max = 50)
    @Column(name = "hasil_detail")
    private String hasil_detail;

    @Size(max = 50)
    @Column(name = "dalam_kisaran")
    private String dalam_kisaran;

    @Size(max = 50)
    @Column(name = "diluar_kisaran")
    private String diluar_kisaran;

    @Size(max = 50)
    @Column(name = "metoda")
    private String metoda;

    @Size(max = 50)
    @Column(name = "penerima")
    private String penerima;

    @Size(max = 50)
    @Column(name = "nama_penerima")
    private String nama_penerima;

    @Size(max = 50)
    @Column(name = "hubungan_keluarga")
    private String hubungan_keluarga;

    @Size(max = 50)
    @Column(name = "ttd_penerima")
    private String ttd_penerima;

    @Column(name = "tanggal_diterima")
    private LocalDateTime tanggal_diterima;

    @Size(max = 50)
    @Column(name = "tags")
    private String tags;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Column(name = "created_date")
    private LocalDateTime created_date;

    @Size(max = 50)
    @Column(name = "created_by")
    private String created_by;

    @Size(max = 50)
    @Column(name = "created_by_name")
    private String created_by_name;

    @Column(name = "modified_date")
    private LocalDateTime modified_date;

    @Size(max = 50)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 50)
    @Column(name = "modified_by_name")
    private String modified_by_name;

    @Size(max = 50)
    @Column(name = "global_comment")
    private String global_comment;

    @Size(max = 50)
    @Column(name = "test_comment")
    private String test_comment;

}
