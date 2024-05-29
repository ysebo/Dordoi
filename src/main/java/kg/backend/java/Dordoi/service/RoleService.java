package kg.backend.java.Dordoi.service;

import kg.backend.java.Dordoi.dto.role.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> all();
    RoleDto findById(Long id);
    void updateById(Long id, RoleDto roleDto);
    void deleteById(Long id);
    void create(RoleDto roleDto);
}
