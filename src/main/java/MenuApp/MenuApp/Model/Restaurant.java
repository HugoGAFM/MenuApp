package MenuApp.MenuApp.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "TB_restaurante")
public class Restaurant {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_restaurant;
    private String telephone;




    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Users user;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Menu> MenuItems;


    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Order> Orderings;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Addresses> Address;
}
