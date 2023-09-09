package com.edu.interfaces;

import com.edu.entidad.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(String vUsuario, String vClave);
}
