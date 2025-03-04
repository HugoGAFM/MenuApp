package MenuApp.MenuApp.Model;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_Pedido")
public class Order {

    public Order() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private BigDecimal TotalValue;
    private String Status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurant restaurants;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Order_Item> items;

}
