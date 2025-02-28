package MenuApp.MenuApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TB_Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_dish;
    private String Description;
    private String imageUrl;
    private BigDecimal price;
    private boolean availability;


    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurant restaurant;

    
}
