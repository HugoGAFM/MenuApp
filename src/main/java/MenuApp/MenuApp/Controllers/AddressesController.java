package MenuApp.MenuApp.Controllers;

import MenuApp.MenuApp.Model.Addresses;
import MenuApp.MenuApp.Repository.AddressesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressesController {

    private final AddressesRepository addressesRepository;

    public AddressesController(AddressesRepository addressesRepository) {
        this.addressesRepository = addressesRepository;
    }

    @GetMapping
    public ResponseEntity<List<Addresses>> getAllAddresses() {
        return ResponseEntity.ok(addressesRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Addresses> getAddressById(@PathVariable Long id) {
        Optional<Addresses> address = addressesRepository.findById(id);
        return address.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Addresses> createAddress(@RequestBody Addresses address) {
        Addresses savedAddress = addressesRepository.save(address);
        return ResponseEntity.status(201).body(savedAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Addresses> updateAddress(@PathVariable Long id, @RequestBody Addresses updatedAddress) {
        if (!addressesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedAddress.setId(id);
        Addresses savedAddress = addressesRepository.save(updatedAddress);
        return ResponseEntity.ok(savedAddress);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id) {
        if (!addressesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        addressesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
