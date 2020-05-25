package com.uca.capas.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.ContribuyenteDAO;
import com.uca.capas.dao.ImportanciaDAO;
import com.uca.capas.domain.Contribuyente;


@Service
public class ContribuyenteServiceImpl implements ContribuyenteService {
	 @Autowired
	 ContribuyenteDAO contribuyenteDAO;

	 @Autowired
	 ImportanciaService importanciaService;

	@Override
	public List<Contribuyente> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return contribuyenteDAO.findAll();
	}

	@Override
	public void insert(Contribuyente contribuyente) throws DataAccessException {
		// TODO Auto-generated method stub		
		Date date = new Date();	
		contribuyente.setF_fecha_ingreso(date);
		contribuyente.setImportancia(importanciaService.findOne(contribuyente.getC_Importancia()));
		contribuyenteDAO.insert(contribuyente);
	}


	

	
	
	

	

}
