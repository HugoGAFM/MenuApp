package MenuApp.MenuApp.Controllers;

import MenuApp.MenuApp.Model.Order_Item;
import MenuApp.MenuApp.Repository.Order_ItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order-items")
public class Order_ItemController {

    private final Order_ItemRepository orderItemRepository;

    public Order_ItemController(Order_ItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @GetMapping
    public ResponseEntity<List<Order_Item>> getAllOrderItems() {
        return ResponseEntity.ok(orderItemRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order_Item> getOrderItemById(@PathVariable Long id) {
        Optional<Order_Item> orderItem = orderItemRepository.findById(id);
        return orderItem.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Order_Item> createOrderItem(@RequestBody Order_Item orderItem) {
        Order_Item savedOrderItem = orderItemRepository.save(orderItem);
        return ResponseEntity.status(201).body(savedOrderItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order_Item> updateOrderItem(@PathVariable Long id, @RequestBody Order_Item updatedOrderItem) {
        if (!orderItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedOrderItem.setId(id);
        Order_Item savedOrderItem = orderItemRepository.save(updatedOrderItem);
        return ResponseEntity.ok(savedOrderItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        if (!orderItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
