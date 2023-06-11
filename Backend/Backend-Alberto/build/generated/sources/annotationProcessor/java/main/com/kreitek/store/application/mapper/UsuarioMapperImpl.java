package com.kreitek.store.application.mapper;

import com.kreitek.store.application.dto.UsuarioDTO;
import com.kreitek.store.domain.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-09T11:47:09+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.7 (Amazon.com Inc.)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtoList.size() );
        for ( UsuarioDTO usuarioDTO : dtoList ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entityList.size() );
        for ( Usuario usuario : entityList ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setPassword( dto.getPassword() );
        usuario.setId( dto.getId() );
        usuario.setUsername( dto.getUsername() );
        usuario.setName( dto.getName() );
        usuario.setLastname( dto.getLastname() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPhonenumber( dto.getPhonenumber() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDto(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setUsername( entity.getUsername() );
        usuarioDTO.setName( entity.getName() );
        usuarioDTO.setLastname( entity.getLastname() );
        usuarioDTO.setEmail( entity.getEmail() );
        usuarioDTO.setPassword( entity.getPassword() );
        usuarioDTO.setPhonenumber( entity.getPhonenumber() );

        return usuarioDTO;
    }
}
