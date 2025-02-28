package MenuApp.MenuApp.Repository;

import MenuApp.MenuApp.Model.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Long>   {
}
