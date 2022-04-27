package tk.propensi.medix.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "rumahsakit")
public class RumahSakitModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=300)
    @Column(name="namaRumahSakit", nullable = false)
    private String namaRumahSakit;

    @Size(max=300)
    @Column(name="jenis")
    private String jenis;

    @Size(max=300)
    @Column(name="kelas")
    private String kelas;

    @Size(max=300)
    @Column(name="kepemilikan")
    private String kepemilikan;

    @Size(max=300)
    @Column(name="jalan")
    private String jalan;

    @Size(max=300)
    @Column(name="kelurahan")
    private String kelurahan;

    @Size(max=300)
    @Column(name="kecamatan")
    private String kecamatan;

    @Size(max=300)
    @Column(name="kabupaten")
    private String kabupaten;

    @Size(max=300)
    @Column(name="provinsi")
    private String provinsi;

    @Size(max=300)
    @Column(name="kodepos")
    private String kodepos;

    @Size(max=300)
    @Column(name="notelp")
    private String notelp;

    @Size(max=300)
    @Column(name="email")
    private String email;

    @Size(max=300)
    @Column(name="website")
    private String website;
}
