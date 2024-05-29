package kg.backend.java.Dordoi.controller;

import kg.backend.java.Dordoi.dto.role.RoleDto;
import kg.backend.java.Dordoi.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/all")
    public List<RoleDto> all() {
        return roleService.all();
    }

    @GetMapping("/findById/{id}")
    public RoleDto findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @PutMapping("/updateById/{id}")
    public void updateById(@PathVariable Long id, @RequestBody RoleDto roleDto) {
        roleService.updateById(id, roleDto);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody RoleDto roleDto) {
        roleService.create(roleDto);
    }
}
