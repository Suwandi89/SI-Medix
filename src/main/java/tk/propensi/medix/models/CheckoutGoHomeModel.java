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
@Table(name = "checkout_go_home")
public class CheckoutGoHomeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(name = "kode")
    private String kode;

    @Size(max = 100)
    @Column(name = "singkatan")
    private String singkatan;

    @Size(max = 255)
    @Column(name = "nama")
    private String nama;
}
