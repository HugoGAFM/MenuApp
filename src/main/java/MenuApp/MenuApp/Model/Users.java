package MenuApp.MenuApp.Model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "TB_user")
public class Users {

    public Users() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name_user;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles role;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Restaurant> restaurants;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orderList;





}
