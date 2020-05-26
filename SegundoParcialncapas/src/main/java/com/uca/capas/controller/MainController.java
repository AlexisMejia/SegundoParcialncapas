package com.uca.capas.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;
import com.uca.capas.service.CategoriaService;
import com.uca.capas.service.LibroService;


@Controller
public class MainController {
	
	@Autowired
	private CategoriaService cateService;
	
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/index")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView();
		Categoria cate = new Categoria();
		mav.addObject("categoria", cate);
		mav.setViewName("index");
		return mav;
	}
	
	@GetMapping("/ingresarCategoria")
	public ModelAndView insertCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria cate = new Categoria();
		
		mav.addObject("categoria", cate);
		mav.setViewName("ingresarCategoria");
		
		return mav;
	}
	
	@PostMapping("/ingresarCategoria")
	public ModelAndView showCategoria(@Valid @ModelAttribute Categoria cat, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ingresarCategoria");
		}else {
			cateService.save(cat);
		}
		
		mav.addObject("categorias", cat);
		mav.addObject("msgg", "categoria guardada con exito");
		mav.setViewName("index");
		
		return mav;
	}
	
	
	
	@GetMapping("/ingresarLibro")
	public ModelAndView insertLibro() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		List<Categoria> cate = cateService.findCategoria();
		
		mav.addObject("categorias", cate);
		mav.addObject("libro", libro);
		mav.setViewName("ingresarLibro");
		
		return mav;
	}
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView formLibro(@Valid @ModelAttribute Libro lib, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		List<Categoria> cate = cateService.findCategoria();
		
		if(result.hasErrors()) {
			mav.addObject("catego", cate);
			mav.setViewName("ingresarLibro");
		}else {
			lib.setFechaIngreso(new Date());
			libroService.save(lib);
			List<Libro> libro = null;
			
			try {
				libro = libroService.findLibro();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			mav.addObject("libros", libro);
			mav.addObject("msg", "libro guardado con exito");
			mav.setViewName("main");
		}
		

		return mav;
	}
	
	
	@PostMapping("/listLibros")
	public ModelAndView show() {
		ModelAndView mav = new ModelAndView();
		List<Libro> librito = libroService.findLibro();

		try {
			librito = libroService.findLibro();
		} catch (Exception e) {
			e.printStackTrace();
		}

		mav.addObject("libros", librito);
		mav.setViewName("listLibros");

		return mav;
	}
	

}
