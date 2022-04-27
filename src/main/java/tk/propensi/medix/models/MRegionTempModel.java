package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "m_region_temp")
public class MRegionTempModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 255)
    @Column(name = "kode")
    private String kode;

    @Size(max = 255)
    @Column(name = "nama")
    private String nama;

    @Size(max = 255)
    @Column(name = "tanggal")
    private String tanggal;

    @Size(max = 255)
    @Column(name = "website")
    private String website;

    @Size(max = 255)
    @Column(name = "lembaga")
    private String lembaga;
}
