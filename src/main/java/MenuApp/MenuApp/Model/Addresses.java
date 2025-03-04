package MenuApp.MenuApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity
@Table (name = "TB_Enderecos")
public class Addresses {

    public Addresses() {

    }

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
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;
}
