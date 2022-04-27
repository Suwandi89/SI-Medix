package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "drug_order")
public class DrugOrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "drug_order_id")
    private String drug_order_id;

    @Size(max = 50)
    @Column(name = "resep_no")
    private String resep_no;

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
    @Column(name = "jns_pelayanan_id")
    private String jns_pelayanan_id;

    @Size(max = 50)
    @Column(name = "jns_pelayanan_name")
    private String jns_pelayanan_name;

    @Size(max = 50)
    @Column(name = "jns_pembayaran_id")
    private String jns_pembayaram_id;

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
    @Column(name = "drug_id")
    private String drug_id;

    @Size(max = 50)
    @Column(name = "drug_name")
    private String drug_name;

    @Size(max = 50)
    @Column(name = "brand_name")
    private String brand_name;

    @Size(max = 50)
    @Column(name = "batch_no")
    private String batch_no;

    @Column(name = "expired_date")
    private Date expired_date;

    @Size(max = 50)
    @Column(name = "packsize")
    private String packsize;

    @Size(max = 50)
    @Column(name = "packsize_unit")
    private String packsize_unit;

    @Size(max = 50)
    @Column(name = "optional_attr")
    private String optional_attr;

    @Size(max = 50)
    @Column(name = "sediaan")
    private String sediaan;

    @Size(max = 50)
    @Column(name = "strength")
    private String strength;

    @Size(max = 50)
    @Column(name = "unit_name_big")
    private String unit_name_big;

    @Size(max = 50)
    @Column(name = "unit_ratio")
    private String unit_ratio;

    @Size(max = 50)
    @Column(name = "unit_name_small")
    private String unit_name_small;

    @Size(max = 50)
    @Column(name = "unit_dose_ratio")
    private String unit_dose_ratio;

    @Size(max = 50)
    @Column(name = "unit_dose_name")
    private String unit_dose_name;

    @Size(max = 50)
    @Column(name = "ingredient_ids")
    private String ingredient_ids;

    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "end_date")
    private LocalDateTime end_date;

    @Column(name = "dose")
    private int dose;

    @Column(name = "numero")
    private int numero;

    @Size(max = 50)
    @Column(name = "numero_unit")
    private String numero_unit;

    @Size(max = 50)
    @Column(name = "waktu")
    private String waktu;

    @Size(max = 2000)
    @Column(name = "pemberian_obat")
    private String pemberian_obat;

    @Size(max = 50)
    @Column(name = "pemberian_obat_desc")
    private String pemberian_obat_desc;

    @Size(max = 50)
    @Column(name = "aturan_pakai")
    private String aturan_pakai;

    @Size(max = 50)
    @Column(name = "administration_route_id")
    private String administration_route_id;

    @Size(max = 50)
    @Column(name = "administration_route_name")
    private String administration_route_name;

    @Column(name = "start_taken")
    private LocalDateTime start_taken;

    @Column(name = "end_taken")
    private LocalDateTime end_taken;

    @Size(max = 50)
    @Column(name = "end_taken_by")
    private String end_taken_by;

    @Size(max = 50)
    @Column(name = "end_taken_by_name")
    private String end_taken_by_name;

    @Size(max = 50)
    @Column(name = "end_taken_reason")
    private String end_taken_reason;

    @Size(max = 50)
    @Column(name = "end_taken_physician_id")
    private String end_taken_physician_id;

    @Size(max = 50)
    @Column(name = "end_taken_physician_name")
    private String end_taken_physician_name;

    @Size(max = 50)
    @Column(name = "end_taken_signature")
    private String end_taken_signature;

    @Size(max = 50)
    @Column(name = "farmako_by")
    private String farmako_by;

    @Size(max = 50)
    @Column(name = "farmako_by_name")
    private String farmako_by_name;

    @Size(max = 50)
    @Column(name = "penanda_salinan_resep")
    private String penanda_salinan_resep;

    @Size(max = 50)
    @Column(name = "penanda_salinan_resep_desc")
    private String penanda_salinan_resep_desc;

    @Column(name = "numero_submit")
    private int numero_submit;

    @Size(max = 50)
    @Column(name = "petugas_id")
    private String petugas_id;

    @Size(max = 50)
    @Column(name = "petugas_name")
    private String petugas_name;

    @Size(max = 50)
    @Column(name = "disposition")
    private String disposition;

    @Column(name = "verified_date")
    private LocalDateTime verified_date;

    @Size(max = 50)
    @Column(name = "verified_by")
    private String verified_by;

    @Column(name = "approve_date")
    private LocalDateTime approve_date;

    @Size(max = 50)
    @Column(name = "approve_by")
    private String approve_by;

    @Column(name = "canceled_date")
    private LocalDateTime canceled_date;

    @Size(max = 50)
    @Column(name = "canceled_by")
    private String canceled_by;

    @Size(max = 50)
    @Column(name = "canceled_notes")
    private String canceled_notes;

    @Size(max = 50)
    @Column(name = "excuse")
    private String excuse;

    @Column(name = "is_copied")
    private int is_copied;

    @Size(max = 50)
    @Column(name = "copied_into")
    private String copied_into;

    @Size(max = 50)
    @Column(name = "copied_from")
    private String copied_from;

    @Column(name = "is_salinan_resep")
    private int is_salinan_resep;

    @Column(name = "is_iter")
    private int is_iter;

    @Column(name = "iter_num")
    private int iter_num;

    @Column(name = "iter_seq")
    private int iter_seq;

    @Size(max = 50)
    @Column(name = "tags")
    private String tags;

    @Column(name = "rate")
    private int rate;

    @Column(name = "service_fee1")
    private int service_fee1;

    @Column(name = "service_fee2")
    private int service_fee2;

    @Column(name = "service_fee3")
    private int service_fee3;

    @Column(name = "service_fee4")
    private int service_fee4;

    @Column(name = "service_fee5")
    private int service_fee5;

    @Column(name = "bill")
    private double bill;

    @Column(name = "discount")
    private double discount;

    @Column(name = "sisa")
    private int sisa;

    @Size(max = 50)
    @Column(name = "bill_ids")
    private String bill_ids;

    @Size(max = 50)
    @Column(name = "invoice_ids")
    private String invoice_ids;

    @Column(name = "is_blacklist_or_whitelist")
    private int is_blacklist_or_whitelist;

    @Size(max = 50)
    @Column(name = "keterangan_dijamin_dahulu")
    private String keterangan_dijamin_dahulu;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Size(max = 50)
    @Column(name = "company_id")
    private String company_id;

    @Size(max = 50)
    @Column(name = "company_name")
    private String company_name;

    @Column(name = "created_date")
    private LocalDateTime created_date;

    @Size(max = 50)
    @Column(name = "created_by")
    private String created_by_name;

    @Column(name = "modified_date")
    private LocalDateTime modified_date;

    @Size(max = 50)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 50)
    @Column(name = "modified_by_name")
    private String modified_by_name;

    @Column(name = "copied_date")
    private LocalDateTime copied_date;

    @Size(max = 50)
    @Column(name = "copied_by")
    private String copied_by;

    @Size(max = 50)
    @Column(name = "copied_by_name")
    private String copied_by_name;

    @Column(name = "dispense_date")
    private LocalDateTime dispense_date;

    @Size(max = 50)
    @Column(name = "dispense_by")
    private String dispense_by;

    @Size(max = 50)
    @Column(name = "dispense_by_name")
    private String dispense_by_name;

    @Column(name = "take_date")
    private LocalDateTime take_date;

    @Size(max = 50)
    @Column(name = "take_by")
    private String take_by;

    @Size(max = 50)
    @Column(name = "take_by_name")
    private String take_by_name;

    @Column(name = "prepare_date")
    private LocalDateTime prepare_date;

    @Size(max = 50)
    @Column(name = "prepare_by")
    private String prepare_by;

    @Size(max = 50)
    @Column(name = "prepare_by_name")
    private String prepare_by_name;

    @Column(name = "subtitute_date")
    private LocalDateTime subtitute_date;

    @Size(max = 50)
    @Column(name = "subtitute_by")
    private String subtitute_by;

    @Size(max = 50)
    @Column(name = "subtitute_by_name")
    private String subtitute_by_name;

    @Size(max = 50)
    @Column(name = "subtitute_notes")
    private String subtitute_notes;

    @Size(max = 50)
    @Column(name = "subtituted_drug_id")
    private String subtituted_drug_id;

    @Column(name = "retur_date")
    private LocalDateTime retur_date;

    @Size(max = 50)
    @Column(name = "retur_by")
    private String retur_by;

    @Size(max = 50)
    @Column(name = "retur_by_name")
    private String retur_by_name;

}

