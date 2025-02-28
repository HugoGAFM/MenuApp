package MenuApp.MenuApp.Model;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_user;
    private String Email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Restaurant> Restaurant;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;





}
