package com.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas1.dao.DataMapper;
import com.tugas1.model.KelurahanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KelurahanServiceDatabase implements KelurahanService {

	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public KelurahanModel getKelurahanById(long id) {
		log.info("selecting");
		return dataMapper.selectKelurahanById(id);
	}
	
	@Override
	public List<KelurahanModel> getAllKelurahan()  {
		log.info("selecting");
		return dataMapper.getAllKelurahan();
	}
	
	@Override
	public KelurahanModel getKelurahanById(Long id_kelurahan) {
		log.info("selecting");
		return dataMapper.selectKelurahanById(id_kelurahan);
	}
	
	@Override
	public List<KelurahanModel> selectKelurahan(Long id_kecamatan) {
		log.info("selecting");
		return dataMapper.selectKelurahan(id_kecamatan);
	}
}
