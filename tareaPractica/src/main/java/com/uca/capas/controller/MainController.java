package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import com.uca.capas.service.ContribuyenteService;
import com.uca.capas.service.ImportanciaService;

@Controller
public class MainController {
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@Autowired
	private ContribuyenteDAO contribuyenteDao;
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		 ModelAndView mav = new ModelAndView();
	        List<Importancia> importanciaList = new ArrayList<>();
	        try{
	            importanciaList = importanciaService.findAll();
	        } catch (DataAccessException e) {
	            e.printStackTrace();
	        }
	        mav.addObject("contribuyente",new Contribuyente());
	        mav.addObject("importanciaList", importanciaList);
	        mav.setViewName("index");
	        return mav;
	}
	
	@RequestMapping("/insertar")
	public ModelAndView insertar(@ModelAttribute Contribuyente contribuyente) {
		ModelAndView mav = new ModelAndView();

		try {
			contribuyenteService.insert(contribuyente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		
		
		try {
			
			contribuyentes = contribuyenteService.findAll();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyentes",contribuyentes);
		mav.setViewName("listado");
		
		return mav;
	}
	
	
	

}
