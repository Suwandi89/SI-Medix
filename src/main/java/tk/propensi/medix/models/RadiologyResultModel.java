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
@Table(name = "radiology_result")
public class RadiologyResultModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "radiology_result_id")
    private String radiology_result_id;

    @Size(max = 100)
    @Column(name = "procedure_taken_id")
    private String procedure_taken_id;

    @Size(max = 100)
    @Column(name = "admission_id")
    private String admission_id;

    @Size(max = 100)
    @Column(name = "person_id")
    private String person_id;

    @Size(max = 100)
    @Column(name = "rm_id")
    private String rm_id;

    @Size(max = 100)
    @Column(name = "berkas_id")
    private String berkas_id;

    @Size(max = 100)
    @Column(name = "doctor_id")
    private String doctor_id;

    @Size(max = 100)
    @Column(name = "doctor_name")
    private String doctor_name;

    @Size(max = 100)
    @Column(name = "detail")
    private String detail;

    @Size(max = 100)
    @Column(name = "photo")
    private String photo;

    @Column(name = "ekspertis_date")
    private Date ekspertis_date;

    @Size(max = 100)
    @Column(name = "hospital_id")
    private String hospital_id;

    @Column(name = "created_date")
    private Date created_date;

    @Size(max = 100)
    @Column(name = "created_by")
    private String created_by;

    @Size(max = 100)
    @Column(name = "created_by_name")
    private String created_by_name;

    @Column(name = "modified_date")
    private Date modified_date;

    @Size(max = 100)
    @Column(name = "modified_by")
    private String modified_by;

    @Size(max = 100)
    @Column(name = "modified_by_name")
    private String modified_by_name;

}
