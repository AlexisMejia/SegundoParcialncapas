package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;


public interface CategoriaDAO {

public void save(Categoria categoria) throws DataAccessException;
	
	public List<Categoria> findCategoria() throws DataAccessException;
}

