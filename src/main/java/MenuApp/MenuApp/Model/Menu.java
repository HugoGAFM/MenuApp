package MenuApp.MenuApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "TB_Menu")
public class Menu {

    public Menu() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameDish;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private boolean availability;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
