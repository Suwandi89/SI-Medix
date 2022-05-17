package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "procedure_taken")
public class ProcedureTakenModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "procedure_taken_id")
    private String procedure_taken_id;

    @Size(max = 50)
    @Column(name = "root_id")
    private String root_id;

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
    @Column(name = "jns_pelayanan_id")
    private String jns_pelayanan_id;

    @Size(max = 50)
    @Column(name = "jns_pelayanan_name")
    private String jns_pelayanan_name;

    @Size(max = 50)
    @Column(name = "jns_pembayaran_id")
    private String jns_pembayaran_id;

    @Size(max = 50)
    @Column(name = "jns_pembayaran_name")
    private String jns_pembayaran_name;

    @Size(max = 50)
    @Column(name = "poli_id")
    private String poli_id;

    @Size(max = 50)
    @Column(name = "poli_name")
    private String poli_name;

    @Size(max = 50)
    @Column(name = "rr_id")
    private String rr_id;

    @Size(max = 50)
    @Column(name = "rr_name")
    private String rr_name;

    @Size(max = 50)
    @Column(name = "kelas_rr_id")
    private String kelas_rr_id;

    @Size(max = 50)
    @Column(name = "kelas_rr_name")
    private String kelas_rr_name;

    @Size(max = 50)
    @Column(name = "procedure_id")
    private String procedure_id;

    @Size(max = 100)
    @Column(name = "procedure_name")
    private String procedure_name;

    @Size(max = 200)
    @Column(name = "procedure_tags")
    private String procedure_tags;

    @Size(max = 50)
    @Column(name = "procedure_no")
    private String procedure_no;

    @Size(max = 50)
    @Column(name = "procedure_ref_code")
    private String procedure_ref_code;

    @Size(max = 50)
    @Column(name = "lookup_id")
    private String lookup_id;

    @Size(max = 50)
    @Column(name = "manus")
    private String manus;

    @Column(name = "scheduled_date")
    private Date scheduled_date;

    @Column(name = "taken_date")
    private Date taken_date;

    @Size(max = 50)
    @Column(name = "petugas_id")
    private String petugas_id;

    @Size(max = 50)
    @Column(name = "petugas_name")
    private String petugas_name;

    @Size(max = 50)
    @Column(name = "dokter_id")
    private String dokter_id;

    @Size(max = 50)
    @Column(name = "dokter_name")
    private String dokter_name;

    @Size(max = 50)
    @Column(name = "icd9cm_id")
    private String icd9cm_id;

    @Size(max = 50)
    @Column(name = "icd9cm_name")
    private String icd9cm_name;

    @Size(max = 50)
    @Column(name = "icd9cm_nama")
    private String icd9cm_nama;

    @Size(max = 50)
    @Column(name = "disposition")
    private String disposition;

    @Size(max = 50)
    @Column(name = "verified_by")
    private String verified_by;

    @Size(max = 50)
    @Column(name = "verified_by_name")
    private String verified_by_name;

    @Column(name = "verified_date")
    private Date verified_date;

    @Size(max = 50)
    @Column(name = "canceled_by")
    private String canceled_by;

    @Size(max = 50)
    @Column(name = "canceled_by_name")
    private String canceled_by_name;

    @Column(name = "canceled_date")
    private Date canceled_date;

    @Size(max = 50)
    @Column(name = "canceled_notes")
    private String canceled_notes;

    @Size(max = 50)
    @Column(name = "approved_by")
    private String approved_by;

    @Size(max = 50)
    @Column(name = "approved_by_name")
    private String approved_by_name;

    @Column(name = "approved_date")
    private Date approved_date;

    @Column(name = "rate")
    private int rate;

    @Column(name = "bhp")
    private int bhp;

    @Column(name = "bpako")
    private int bpako;

    @Column(name = "dokter")
    private int dokter;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "discount")
    private int discount;

    @Column(name = "sisa")
    private int sisa;

    @Size(max = 50)
    @Column(name = "bill_ids")
    private String bill_ids;

    @Size(max = 50)
    @Column(name = "invoice_ids")
    private String invoice_ids;

    @Size(max = 50)
    @Column(name = "description")
    private String description;

    @Size(max = 50)
    @Column(name = "konsul_ids")
    private String konsul_ids;

    @Size(max = 50)
    @Column(name = "discharge_plan_ids")
    private String discharge_plan_ids;

    @Size(max = 50)
    @Column(name = "instruksi_medis_ids")
    private String instruksi_medis_ids;

    @Size(max = 50)
    @Column(name = "is_blacklist_or_whitelist")
    private String is_blacklist_or_whitelist;

    @Size(max = 50)
    @Column(name = "keterangan_dijamin_dahulu")
    private String keterangan_dijamin_dahulu;

    @Size(max = 50)
    @Column(name = "tags")
    private String tags;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Size(max = 50)
    @Column(name = "queue_rehabmedik_id")
    private String queue_rehabmedik_id;

    @Size(max = 50)
    @Column(name = "queue_hemodialisa_id")
    private String queue_hemodialisa_id;

    @Size(max = 50)
    @Column(name = "result_id")
    private String result_id;

    @Size(max = 50)
    @Column(name = "result_narrative")
    private String result_narrative;

    @Size(max = 50)
    @Column(name = "result_path")
    private String result_path;

    @Size(max = 50)
    @Column(name = "result_by")
    private String result_by;

    @Size(max = 50)
    @Column(name = "result_by_name")
    private String result_by_name;

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

    @Size(max = 2000)
    @Column(name = "lab_results")
    private String lab_results;

    @Size(max = 100)
    @Column(name = "jns_tarif")
    private String jns_tarif;

}
