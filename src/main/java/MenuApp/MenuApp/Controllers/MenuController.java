package MenuApp.MenuApp.Controllers;

import MenuApp.MenuApp.Model.Menu;
import MenuApp.MenuApp.Model.Category;
import MenuApp.MenuApp.Repository.MenuRepository;
import MenuApp.MenuApp.Repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
public class MenuController {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    public MenuController(MenuRepository menuRepository, CategoryRepository categoryRepository) {
        this.menuRepository = menuRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        if (menu.getCategory() == null || menu.getCategory().getId() == null) {
            return ResponseEntity.badRequest().build(); // Garante que a categoria seja informada
        }

        Optional<Category> category = categoryRepository.findById(menu.getCategory().getId());
        if (category.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Garante que a categoria exista
        }

        menu.setCategory(category.get());
        Menu savedMenu = menuRepository.save(menu);
        return ResponseEntity.status(201).body(savedMenu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @RequestBody Menu updatedMenu) {
        if (!menuRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        if (updatedMenu.getCategory() == null || updatedMenu.getCategory().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Optional<Category> category = categoryRepository.findById(updatedMenu.getCategory().getId());
        if (category.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        updatedMenu.setId(id);
        updatedMenu.setCategory(category.get());
        Menu savedMenu = menuRepository.save(updatedMenu);
        return ResponseEntity.ok(savedMenu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        if (!menuRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        menuRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
