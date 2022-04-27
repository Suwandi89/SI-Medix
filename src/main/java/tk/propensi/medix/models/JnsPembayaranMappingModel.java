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
@Table(name = "jns_pembayaran_mapping")
public class JnsPembayaranMappingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50)
    @Column(name = "id_zicare")
    private String id_zicare;

    @Size(max = 255)
    @Column(name = "jenisPembayaran")
    private String jenisPembayaran;

}
