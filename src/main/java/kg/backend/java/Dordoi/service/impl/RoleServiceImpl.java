package kg.backend.java.Dordoi.service.impl;

import kg.backend.java.Dordoi.dto.role.RoleDto;
import kg.backend.java.Dordoi.entity.Role;
import kg.backend.java.Dordoi.exceptions.CustomException;
import kg.backend.java.Dordoi.mapper.RoleMapper;
import kg.backend.java.Dordoi.repository.RoleRepository;
import kg.backend.java.Dordoi.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper roleMapper;
    @Override
    public List<RoleDto> all() {
        return roleMapper.toDtoS(repository.findAll());
    }

    @Override
    public RoleDto findById(Long id) {
        return roleMapper.toDto(repository.findById(id).orElseThrow(() -> new CustomException("Role not found", HttpStatus.NOT_FOUND)));
    }

    @Override
    public void updateById(Long id, RoleDto roleDto) {
        Role role = repository.findById(id).orElseThrow(() -> new CustomException("Role not found", HttpStatus.NOT_FOUND));
        if(role.getName().equals(roleDto.getName().toUpperCase())) {
            throw new CustomException("Role with this name is already exist!", HttpStatus.BAD_REQUEST);
        }
        role.setName(roleDto.getName().toUpperCase());
        repository.save(role);
    }

    @Override
    public void deleteById(Long id) {
        if(repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new CustomException("Role not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void create(RoleDto roleDto) {
        if(repository.findByName(roleDto.getName().toUpperCase()).isEmpty()) {
            Role role = new Role();
            role.setName(roleDto.getName().toUpperCase());
            repository.save(role);
        } else {
            throw new CustomException("Role with this name is already exist!", HttpStatus.BAD_REQUEST);
        }
    }
}
