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
@Table(name = "pembayaran_ids_mapping")
public class PembayaranIdsMappingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "id_zicare")
    private String id_zicare;

    @Size(max = 255)
    @Column(name = "nama")
    private String nama;

    @Size(max = 255)
    @Column(name = "nama_sik")
    private String nama_sik;

}
