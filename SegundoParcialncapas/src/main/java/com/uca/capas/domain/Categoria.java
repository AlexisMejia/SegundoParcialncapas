package com.uca.capas.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public", name="cat_categoria")
public class Categoria {

	@Id
	@Column(name="c_categoria")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoCategoria;
	
	@Size(message = "El campo no debe contener más de 50 caracteres", max = 50)
	@NotEmpty(message = "*Campo obligatorio")
	@Column(name="s_categoria")
	private String nameCategoria;
	
	

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getCodigoCategoria() {
		return codigoCategoria;
	}


	public void setCodigoCategoria(Integer codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}


	public String getNameCategoria() {
		return nameCategoria;
	}


	public void setNameCategoria(String nameCategoria) {
		this.nameCategoria = nameCategoria;
	}


	
	
}
