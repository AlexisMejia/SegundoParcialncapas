package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService {
	
	@Autowired
	LibroDAO libroDAO;

	@Override
	public void save(Libro libro) throws DataAccessException {
		libroDAO.save(libro);
		
	}

	@Override
	public List<Libro> findLibro() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDAO.findLibro();
	}

}
