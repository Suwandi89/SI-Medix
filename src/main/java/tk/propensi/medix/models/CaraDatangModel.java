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
@Table(name = "cara_datang")
public class CaraDatangModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "kode")
    private String kode;

    @Size(max = 255)
    @Column(name = "cara")
    private String cara;

    @Size(max = 255)
    @Column(name = "caraDetil")
    private String caraDetil;
}
