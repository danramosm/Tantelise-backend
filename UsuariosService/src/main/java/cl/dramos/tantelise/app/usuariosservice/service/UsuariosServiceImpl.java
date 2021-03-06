package cl.dramos.tantelise.app.usuariosservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cl.dramos.tantelise.app.usuariosservice.domain.Usuario;
import cl.dramos.tantelise.app.usuariosservice.domain.UsuarioRepositorio;

@Service
public class UsuariosServiceImpl implements UsuariosService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario u = this.buscarUsuario(username);
		if(u ==null) {
			throw new UsernameNotFoundException("Usuario: "+ username +" no encontrado");
			
		}
		return u;
	}

	@Override
	public Usuario buscarUsuario(String usuario) {
		return usuarioRepositorio.findUsuarioByUsuario(usuario);
	}

}
