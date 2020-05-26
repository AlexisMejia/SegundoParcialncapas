package com.uca.capas.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(schema = "public", name = "cat_libro")
public class Libro {

	@Id
	@Column(name = "c_libro")
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoLibro;

	@Size(message = "El campo no debe contener más de 50 caracteres", max = 50)
	@Column(name = "s_titulo")
	@NotEmpty(message = "*Campo obligatorio")
	private String nameTitulo;
	
	@Size(message = "El campo no debe contener más de 150 caracteres", max = 150)
	@Column(name = "s_autor")
	@NotEmpty(message = "*Campo obligatorio")
	private String nameAutor;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "c_categoria")
	@NotEmpty(message = "*Campo obligatorio")
	private Categoria categoria;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "f_ingreso")
	@NotEmpty(message = "*Campo obligatorio")
	private Date fechaIngreso;

	@NotNull(message = "*Campo obligatorio")
	@Column(name = "b_estado")
	private Boolean lEstado;

	@NotNull
	@Column(name = "s_isbn")
	@NotEmpty(message = "*Campo obligatorio")
	private String sIsbn;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getCodigoLibro() {
		return codigoLibro;
	}

	public void setCodigoLibro(Integer codigoLibro) {
		this.codigoLibro = codigoLibro;
	}

	public String getNameTitulo() {
		return nameTitulo;
	}

	public void setNameTitulo(String nameTitulo) {
		this.nameTitulo = nameTitulo;
	}

	public String getNameAutor() {
		return nameAutor;
	}

	public void setNameAutor(String nameAutor) {
		this.nameAutor = nameAutor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Boolean getlEstado() {
		return lEstado;
	}

	public void setlEstado(Boolean lEstado) {
		this.lEstado = lEstado;
	}

	public String getsIsbn() {
		return sIsbn;
	}

	public void setsIsbn(String sIsbn) {
		this.sIsbn = sIsbn;
	}

	// Delegate para activo o inactivo
	public String getBactivoDelegate() {
		if (this.lEstado == null) {
			return "";
		} else {
			if (this.lEstado)
				return "ACTIVO";
			else
				return "INACTIVO";
		}
	}

	// Delegate para conversion de fecha
	public String getFechaDelegate() {
		if (this.fechaIngreso == null) {
			return "";
		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String shortdate = sdf.format(this.fechaIngreso.getTime());
			return shortdate;
		}
	}

}
