package kg.backend.java.Dordoi.mapper;

import kg.backend.java.Dordoi.dto.role.RoleDto;
import kg.backend.java.Dordoi.entity.Role;

import java.util.List;

public interface RoleMapper {
    RoleDto toDto(Role role);
    List<RoleDto> toDtoS(List<Role> roles);
}
