package MenuApp.MenuApp.Model;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity
@Table (name = "TB_Enderecos")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipCode;
    private String street;
    private String number;
    private String neighbourhood;
    private String city;
    private String state;
    private String reference;


    @ManyToOne
    @JoinColumn(name = "TB_Restaurante")
    private Restaurant restaurant;
}
