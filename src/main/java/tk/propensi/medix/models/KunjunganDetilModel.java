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
@Table(name = "kunjungan_detil")
public class KunjunganDetilModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "admission_id")
    private String admission_id;

    @Size(max = 50)
    @Column(name = "tipe_kasus_id")
    private String tipe_kasus_id;

    @Size(max = 50)
    @Column(name = "tipe_kasus_name")
    private String tipe_kasus_name;

    @Size(max = 50)
    @Column(name = "room_admission_id")
    private String room_admission_id;

    @Size(max = 50)
    @Column(name = "room_bed_id")
    private String room_bed_id;

    @Size(max = 50)
    @Column(name = "rom_grp_id")
    private String room_grp_id;

    @Size(max = 50)
    @Column(name = "room_grp_name")
    private String room_grp_name;

    @Size(max = 50)
    @Column(name = "kelas_rr_id")
    private String kelas_rr_id;

    @Size(max = 50)
    @Column(name = "kelas_rr_name")
    private String kelas_rr_name;

    @Size(max = 50)
    @Column(name = "dokter")
    private String dokter;

    @Size(max = 50)
    @Column(name = "perawat")
    private String perawat;

    @Column(name = "asesmen_date")
    private Date asesmen_date;

    @Size(max = 50)
    @Column(name = "encounter_with_id")
    private String encounter_with_id;

    @Size(max = 50)
    @Column(name = "encounter_with_name")
    private String encounter_with_name;

    @Size(max = 50)
    @Column(name = "encounter_change_id")
    private String encounter_change_id;

    @Size(max = 50)
    @Column(name = "encounter_change_name")
    private String encounter_change_name;

    @Column(name = "encounter_date")
    private Date encounter_date;

    @Column(name = "scheduled_date")
    private Date scheduled_date;

    @Column(name = "admission_date")
    private Date admission_date;

    @Column(name = "discharge_date")
    private Date discharge_date;

    @Column(name = "checkout_date")
    private Date checkout_date;

    @Column(name = "scheduled_ok")
    private Date scheduled_ok;

    @Size(max = 50)
    @Column(name = "discharge_plan_id")
    private String discharge_plan_id;

    @Column(name = "doa_date")
    private Date doa_date;

    @Size(max = 50)
    @Column(name = "checkout_go_home_id")
    private String checkout_go_home_id;

    @Size(max = 2000)
    @Column(name = "disposition")
    private String disposition;

    @Size(max = 50)
    @Column(name = "group_bill_id")
    private String group_bill_id;

    @Column(name = "bill")
    private double bill;

    @Size(max = 20)
    @Column(name = "is_paid")
    private String is_paid;

    @Size(max = 2000)
    @Column(name = "agunan")
    private String agunan;

    @Size(max = 2000)
    @Column(name = "konsul")
    private String konsul;

    @Size(max = 2000)
    @Column(name = "appointment")
    private String appointment;

    @Size(max = 20)
    @Column(name = "antrian_no")
    private String antrian_no;

    @Size(max = 2000)
    @Column(name = "bpjs_verification_tags")
    private String bpjs_verification_tags;

    @Size(max = 2000)
    @Column(name = "bpjs_verification_note")
    private String bpjs_verification_note;

    @Column(name = "bpjs_verification_date")
    private Date bpjs_verification_date;

    @Size(max = 20)
    @Column(name = "bpjs_verification_by")
    private String bpjs_verification_by;

    @Size(max = 25)
    @Column(name = "bpjs_verification_by_name")
    private String bpjs_verification_by_name;

    @Size(max = 2000)
    @Column(name = "catatan_kunjungan")
    private String catatan_kunjungan;

    @Size(max = 2000)
    @Column(name = "tags")
    private String tags;

    @Size(max = 2000)
    @Column(name = "history_travel")
    private String history_travel;

    @Size(max = 20)
    @Column(name = "person_close_contact")
    private String person_close_contact;

    @Size(max = 50)
    @Column(name = "pandemic_ids")
    private String pandemic_ids;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Size(max = 50)
    @Column(name = "branch_id")
    private String branch_id;

    @Size(max = 25)
    @Column(name = "table_ref")
    private String table_ref;

    @Size(max = 20)
    @Column(name = "column_ref")
    private String column_ref;

    @Size(max = 50)
    @Column(name = "ref_id")
    private String ref_id;

    @Column(name = "created_date")
    private Date created_date;

    @Size(max = 25)
    @Column(name = "created_by")
    private String created_by;

    @Size(max = 25)
    @Column(name = "created_by_name")
    private String created_by_name;

    @Column(name = "modified_date")
    private Date modified_date;

    @Size(max = 25)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 25)
    @Column(name = "modified_by_name")
    private String modified_by_name;

    @Size(max = 2000)
    @Column(name = "cancel_reason")
    private String cancel_reason;

    @Size(max = 2000)
    @Column(name = "cancel_dated")
    private Date cancel_dated;

    @Size(max = 25)
    @Column(name = "cancel_by")
    private String cancel_by;

    @Size(max = 25)
    @Column(name = "cancel_by_name")
    private String cancel_by_name;

    @Size(max = 50)
    @Column(name = "register_with_id")
    private String register_with_id;

    @Size(max = 25)
    @Column(name = "register_with_name")
    private String register_with_name;

    @Size(max = 50)
    @Column(name = "booking_id")
    private String booking_id;

    @Column(name = "booking_date")
    private Date booking_date;

    @Column(name = "booking_confirm_date")
    private Date booking_confirm_date;

    @Column(name = "rsonline_date")
    private Date rsonline_date;

    @Size(max = 2000)
    @Column(name = "rsonline_result")
    private String rsonline_result;

    @Column(name = "sisrute_date")
    private Date sisrute_date;

    @Size(max = 2000)
    @Column(name = "sisrute_result")
    private String sisrute_result;

    @Size(max = 50)
    @Column(name = "person_key")
    private String person_key;

    @Size(max = 2000)
    @Column(name = "link_konsul")
    private String link_konsul;
}
