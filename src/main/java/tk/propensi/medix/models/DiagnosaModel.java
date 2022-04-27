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
@Table(name = "diagnosa")
public class DiagnosaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "diagnosa_id")
    private String diagnosa_id;

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
    @Column(name = "diagnosa")
    private String diagnosa;

    @Size(max = 2000)
    @Column(name = "diagnosa_desc")
    private String diagnosa_desc;

    @Size(max = 50)
    @Column(name = "diagnosa_type")
    private String diagnosa_type;

    @Size(max = 50)
    @Column(name = "assessment")
    private String assessment;

    @Size(max = 10)
    @Column(name = "is_active")
    private String is_active;

    @Size(max = 50)
    @Column(name = "konsul_ids")
    private String konsul_ids;

    @Size(max = 50)
    @Column(name = "discharge_plan_ids")
    private String discharge_plan_ids;

    @Size(max = 50)
    @Column(name = "ok_report_id")
    private String ok_report_id;

    @Size(max = 2000)
    @Column(name = "catatan_anestesi_id")
    private String catatan_anestesi_id;

    @Size(max = 100)
    @Column(name = "tags")
    private String tags;

    @Size(max = 50)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Column(name = "created_date")
    private String created_date;

    @Size(max = 100)
    @Column(name = "created_by")
    private String created_by;

    @Size(max = 100)
    @Column(name = "created_by_name")
    private String created_by_name;

    @Column(name = "modified_date")
    private Date modified_date;

    @Size(max = 50)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 100)
    @Column(name = "modified_by_name")
    private String modified_by_name;
}
