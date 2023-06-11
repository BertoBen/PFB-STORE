package com.kreitek.store.application.mapper;

import com.kreitek.store.application.dto.UsuarioDTO;
import com.kreitek.store.domain.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario>{

    @Override
    @Mapping(target = "password")
    Usuario toEntity(UsuarioDTO dto);

    @Override
    UsuarioDTO toDto(Usuario entity);

}
