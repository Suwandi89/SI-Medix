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
@Table(name = "admission")
public class AdmissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @Size(max = 100)
    @Column(name = "full_name")
    private String full_name;

    @Size(max = 50)
    @Column(name = "nick_name")
    private String nick_name;

    @Size(max = 25)
    @Column(name = "gelar_depan")
    private String gelar_depan;

    @Size(max = 25)
    @Column(name = "gelar_blk")
    private String gelar_blk;

    @Size(max = 50)
    @Column(name = "sex")
    private String sex;

    @Size(max = 100)
    @Column(name = "foto")
    private String foto;

    @Size(max = 20)
    @Column(name = "tempat_lahir")
    private String tempat_lahir;

    @Column(name = "tgl_lahir")
    private Date tgl_lahir;

    @Size(max = 50)
    @Column(name = "gol_darah")
    private String gol_darah;

    @Size(max = 50)
    @Column(name = "agama_id")
    private String agama_id;

    @Size(max = 25)
    @Column(name = "status_kawin")
    private String status_kawin;

    @Size(max = 50)
    @Column(name = "pasangan_id")
    private String pasangan_id;

    @Size(max = 100)
    @Column(name = "pasangan_name")
    private String pasangan_name;

    @Size(max = 25)
    @Column(name = "status_hub_keluarga")
    private String status_hub_keluarga;

    @Size(max = 25)
    @Column(name = "status_ekonomi")
    private String status_ekonomi;

    @Size(max = 2000)
    @Column(name = "hambatan")
    private String hambatan;

    @Size(max = 25)
    @Column(name = "butuh_pendamping")
    private String butuh_pendamping;

    @Size(max = 100)
    @Column(name = "pendamping")
    private String pendamping;

    @Size(max = 2000)
    @Column(name = "alasan_pilih_hospital")
    private String alasan_pilih_hospital;

    @Size(max = 20)
    @Column(name = "nik")
    private String nik;

    @Size(max = 20)
    @Column(name = "jns_identitas_lain")
    private String jns_identitas_lain;

    @Size(max = 25)
    @Column(name = "no_identitas_lain")
    private String no_identitas_lain;

    @Size(max = 50)
    @Column(name = "pendidikan_id")
    private String pendidikan_id;

    @Size(max = 50)
    @Column(name = "suku_id")
    private String suku_id;

    @Size(max = 100)
    @Column(name = "suku_name")
    private String suku_name;

    @Size(max = 50)
    @Column(name = "warga_negara")
    private String warga_negara;

    @Size(max = 50)
    @Column(name = "country_code")
    private String country_code;

    @Size(max = 50)
    @Column(name = "father_id")
    private String father_id;

    @Size(max = 50)
    @Column(name = "mother_id")
    private String mother_id;

    @Size(max = 2000)
    @Column(name = "alamat")
    private String alamat;

    @Size(max = 50)
    @Column(name = "kelurahan_id")
    private String kelurahan_id;

    @Size(max = 100)
    @Column(name = "kelurahan_name")
    private String kelurahan_name;

    @Size(max = 50)
    @Column(name = "kecamatan_id")
    private String kecamatan_id;

    @Size(max = 50)
    @Column(name = "kecamatan_name")
    private String kecamatan_name;

    @Size(max = 100)
    @Column(name = "kabupaten_id")
    private String kabupaten_id;

    @Size(max = 50)
    @Column(name = "kabupaten_name")
    private String kabupaten_name;

    @Size(max = 50)
    @Column(name = "provinsi_id")
    private String provinsi_id;

    @Size(max = 50)
    @Column(name = "provinsi_name")
    private String provinsi_name;

    @Size(max = 50)
    @Column(name = "negara_id")
    private String negara_id;

    @Size(max = 50)
    @Column(name = "negara_name")
    private String negara_name;

    @Size(max = 50)
    @Column(name = "zipcode")
    private String zipcode;

    @Size(max = 15)
    @Column(name = "no_hp")
    private String no_hp;

    @Size(max = 10)
    @Column(name = "no_tlpn")
    private String no_tlpn;

    @Size(max = 10)
    @Column(name = "no_fax")
    private String no_fax;

    @Size(max = 50)
    @Column(name = "email")
    private String email;

    @Size(max = 50)
    @Column(name = "organization_ids")
    private String organization_ids;

    @Size(max = 50)
    @Column(name = "pekerjaan_id")
    private String pekerjaan_id;

    @Size(max = 2000)
    @Column(name = "pekerjaan_tempat")
    private String pekerjaan_tempat;

    @Size(max = 2000)
    @Column(name = "pekerjaan_jabatan")
    private String pekerjaan_jabatan;

    @Size(max = 2000)
    @Column(name = "pekerjaan_alamat")
    private String pekerjaan_alamat;

    @Size(max = 50)
    @Column(name = "pekerjaan_kel_id")
    private String pekerjaan_kel_id;

    @Size(max = 50)
    @Column(name = "pekerjaan_kel_name")
    private String pekerjaan_kel_name;

    @Size(max = 50)
    @Column(name = "pekerjaan_kec_id")
    private String pekerjaan_kec_id;

    @Size(max = 50)
    @Column(name = "pekerjaan_kec_name")
    private String pekerjaan_kec_name;

    @Size(max = 50)
    @Column(name = "pekerjaan_kab_id")
    private String pekerjaan_kab_id;

    @Size(max = 50)
    @Column(name = "pekerjaan_kab_name")
    private String pekerjaan_kab_name;

    @Size(max = 50)
    @Column(name = "pekerjaan_prov_id")
    private String pekerjaan_prov_id;

    @Size(max = 50)
    @Column(name = "pekerjaan_prov_name")
    private String pekerjaan_prov_name;

    @Size(max = 10)
    @Column(name = "pekerjaan_zipcode")
    private String pekerjaan_zipcode;

    @Size(max = 15)
    @Column(name = "pekerjaan_no_tlpn")
    private String pekerjaan_no_tlpn;

    @Size(max = 15)
    @Column(name = "pekerjaan_no_fax")
    private String pekerjaan_no_fax;

    @Size(max = 50)
    @Column(name = "pekerjaan_family_ids")
    private String pekerjaan_family_ids;

    @Size(max = 50)
    @Column(name = "family_id")
    private String family_id;

    @Size(max = 50)
    @Column(name = "family_head_id")
    private String family_head_id;

    @Size(max = 50)
    @Column(name = "family_head_name")
    private String family_head_name;

    @Column(name = "live_with_family")
    private int live_with_family;

    @Size(max = 50)
    @Column(name = "penanggung_jwb_id")
    private String penanggung_jwb_id;

    @Size(max = 50)
    @Column(name = "penanggung_jwb_name")
    private String penanggung_jwb_name;

    @Size(max = 50)
    @Column(name = "penanggung_jwb_hub")
    private String penanggung_jwb_hub;

    @Size(max = 50)
    @Column(name = "jns_pembayaran_id")
    private String jns_pembayaran_id;

    @Size(max = 50)
    @Column(name = "jns_pembayaram_name")
    private String jns_pembayaran_name;

    @Size(max = 50)
    @Column(name = "jns_pembayaram_ids")
    private String jns_pembayaran_ids;

    @Size(max = 50)
    @Column(name = "jns_pembayaran_names")
    private String jns_pembayaran_names;

    @Size(max = 50)
    @Column(name = "kelas_id")
    private String kelas_id;

    @Size(max = 2000)
    @Column(name = "kelas")
    private String kelas;

    @Size(max = 50)
    @Column(name = "jns_pelayanan_id")
    private String jns_pelayanan_id;

    @Size(max = 50)
    @Column(name = "jns_pelayanan_name")
    private String jns_pelayanan_name;

    @Size(max = 50)
    @Column(name = "no_surat")
    private String no_surat;

    @Size(max = 50)
    @Column(name = "no_surat_ranap")
    private String no_surat_ranap;

    @Size(max = 50)
    @Column(name = "no_surat_rawat")
    private String no_surat_rawat;

    @Column(name = "tgl_rujukan")
    private Date tgl_rujukan;

    @Size(max = 50)
    @Column(name = "hospital_id_rujukan")
    private String hospital_id_rujukan;

    @Size(max = 50)
    @Column(name = "hospital_name_rujukan")
    private String hospital_name_rujukan;

    @Size(max = 50)
    @Column(name = "no_rujukan")
    private String no_rujukan;

    @Size(max = 2000)
    @Column(name = "ppk_rujukan")
    private String ppk_rujukan;

    @Size(max = 2000)
    @Column(name = "ppk_pelayanan")
    private String ppk_pelayanan;

    @Column(name = "tgl_sep")
    private Date tgl_sep;

    @Size(max = 50)
    @Column(name = "no_sep")
    private String no_sep;

    @Column(name = "tgl_sjp")
    private Date tgl_sjp;

    @Size(max = 50)
    @Column(name = "no_sjp")
    private String no_sjp;

    @Size(max = 50)
    @Column(name = "kode_dpjp_bpjs")
    private String kode_dpjp_bpjs;

    @Size(max = 2000)
    @Column(name = "inacbg_description")
    private String inacbg_description;

    @Size(max = 50)
    @Column(name = "inacbg_code")
    private String inacbg_code;

    @Column(name = "inacbg_rate")
    private double inacbg_rate;

    @Column(name = "grouping_rate")
    private double grouping_rate;

    @Size(max = 2000)
    @Column(name = "ws_response_msg")
    private String ws_response_msg;

    @Size(max = 2000)
    @Column(name = "ws_response_code")
    private String ws_response_code;

    @Size(max = 2000)
    @Column(name = "keluhan_utama")
    private String keluhan_utama;

    @Size(max = 2000)
    @Column(name = "diagnosa_awal")
    private String diagnosa_awal;

    @Size(max = 2000)
    @Column(name = "diagnosa_awal_desc")
    private String diagnosa_awal_desc;

    @Size(max = 2000)
    @Column(name = "diagnosa_primer")
    private String diagnosa_primer;

    @Size(max = 2000)
    @Column(name = "diagnosa_primer_desc")
    private String diagnosa_primer_desc;

    @Size(max = 50)
    @Column(name = "poli_id")
    private String poli_id;

    @Size(max = 50)
    @Column(name = "poli_name")
    private String poli_name;

    @Size(max = 25)
    @Column(name = "lakalantas")
    private String lakalantas;

    @Size(max = 25)
    @Column(name = "lokasi_laka")
    private String lokasi_laka;

    @Size(max = 50)
    @Column(name = "lokasilaka_provnsi_id_bpjs")
    private String lokasilaka_provinsi_id_bpjs;

    @Size(max = 50)
    @Column(name = "lokasilaka_kabupaten_id_bpjs")
    private String lokasilaka_kabupaten_id_bpjs;

    @Size(max = 50)
    @Column(name = "lokasilaka_kecamatan_id_bpjs")
    private String lokasilaka_kecamatan_id_bpjs;

    @Size(max = 50)
    @Column(name = "lakalantas_penjamin_id")
    private String lakalantas_penjamin_id;

    @Size(max = 50)
    @Column(name = "lakalantas_penjamin_name")
    private String lakalantas_penjamin_name;

    @Size(max = 2000)
    @Column(name = "lakalantas_description")
    private String lakalantas_description;

    @Column(name = "lakalantas_date")
    private Date lakalantas_date;

    @Size(max = 50)
    @Column(name = "src_rujukan_id")
    private String src_rujukan_id;

    @Size(max = 80)
    @Column(name = "src_rujukan_name")
    private String src_rujukan_name;

    @Size(max = 2000)
    @Column(name = "description")
    private String description;

    @Size(max = 20)
    @Column(name = "emergency_type")
    private String emergency_type;

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
    @Column(name = "room_grp_id")
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

    @Size(max = 50)
    @Column(name = "jns_tarif")
    private String jns_tarif;

    @Size(max = 100)
    @Column(name = "no_reg_bpjs")
    private String no_reg_bpjs;

    @Size(max = 50)
    @Column(name = "bb")
    private String bb;

    @Size(max = 50)
    @Column(name = "tb")
    private String tb;

    @Size(max = 50)
    @Column(name = "td")
    private String td;

    @Size(max = 50)
    @Column(name = "suhu")
    private String suhu;

}
