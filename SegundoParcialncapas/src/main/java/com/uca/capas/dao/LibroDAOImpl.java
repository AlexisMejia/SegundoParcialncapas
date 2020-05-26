package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {
	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		entityManager.persist(libro);
		entityManager.flush();
		System.out.println("estoy en importancia:");

	}

	@Override
	public List<Libro> findLibro() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro> result = query.getResultList();
		return result;
	}

}
