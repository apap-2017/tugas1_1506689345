package com.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas1.dao.DataMapper;
import com.tugas1.model.KecamatanModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KecamatanServiceDatabase implements KecamatanService {

	@Autowired
	private DataMapper dataMapper;
	
	@Override
	public List<KecamatanModel> selectKecamatan(Long id_kota) {
		log.info("selecting");
		return dataMapper.selectKecamatan(id_kota);
	}
}
