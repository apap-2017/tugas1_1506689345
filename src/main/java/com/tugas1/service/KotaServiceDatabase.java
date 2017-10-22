package com.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas1.dao.DataMapper;
import com.tugas1.model.KotaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KotaServiceDatabase implements KotaService {

	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public List<KotaModel> selectAllKota(){
		log.info("selecting");
		return dataMapper.selectAllKota();
	}
}
