package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Libro;

public interface LibroDAO {
	public void save(Libro libro) throws DataAccessException;

	public List<Libro> findLibro() throws DataAccessException;

}
