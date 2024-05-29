package kg.backend.java.Dordoi.mapper.impl;

import kg.backend.java.Dordoi.dto.role.RoleDto;
import kg.backend.java.Dordoi.entity.Role;
import kg.backend.java.Dordoi.mapper.RoleMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDto toDto(Role role) {
        RoleDto roleDto = new RoleDto();
        roleDto.setName(role.getName());
        return roleDto;
    }

    @Override
    public List<RoleDto> toDtoS(List<Role> roles) {
        List<RoleDto> roleDtoList = new ArrayList<>();
        for (Role role : roles) {
            roleDtoList.add(toDto(role));
        }
        return roleDtoList;
    }
}
