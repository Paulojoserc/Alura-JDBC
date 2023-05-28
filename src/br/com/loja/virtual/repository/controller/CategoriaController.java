package br.com.loja.virtual.repository.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.loja.virtual.repository.modelo.Categoria;

public class CategoriaController {
	public List<Categoria> listar() {
		List<Categoria> categorias = 
				new ArrayList<Categoria>();
		categorias.add(new Categoria(1, "Categoria de teste")); 
		return categorias;
	}
}
