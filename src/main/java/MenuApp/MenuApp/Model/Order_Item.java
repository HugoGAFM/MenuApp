package MenuApp.MenuApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB_itemPedido")
public class Order_Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private Double unitaryPrice;
    private String observation;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
