package com.tugas1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tugas1.dao.DataMapper;
import com.tugas1.model.PendudukModel;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PendudukServiceDatabase implements PendudukService {
	
	@Autowired
	private DataMapper dataMapper;

	@Override
	public PendudukModel getPenduduk(String nik)  {
		log.info("selecting penduduk with nik " + nik);
		return dataMapper.selectPenduduk(nik);
	}
	
	@Override
	public List<PendudukModel> getPendudukByPrefixNik(String prefix)  {
		log.info("selecting penduduk with prefix nik " + prefix);
		return dataMapper.getPendudukByPrefixNik(prefix);
	}
	
	@Override
	public boolean insertPenduduk(PendudukModel pendudukModel) {
		log.info("inserting penduduk with nik " + pendudukModel.getNik());
		try {
			long newId = dataMapper.getLatestPenduduk().getId() + 1;
			pendudukModel.setId(newId);
			dataMapper.insertPenduduk(pendudukModel);
			
			return true;
		} catch (Exception e) {
			log.error("error on inserting penduduk with nik " + pendudukModel.getNik(), e);
			return false;
		}
	}
	
	@Override
	public boolean updatePenduduk(String oldNik, PendudukModel penduduk) {
		log.info("updating penduduk with nik " + penduduk.getNik());
		try {
			long newId = dataMapper.getLatestPenduduk().getId() + 1;
			penduduk.setId(newId);
			dataMapper.updatePenduduk(penduduk, oldNik);
			
			return true;
		} catch (Exception e) {
			log.error("error on updating penduduk with nik " + oldNik, e);
			return false;
		}
	}
	
	@Override
	public List<PendudukModel> selectPendudukByKelurahan(Long id_kelurahan) {
		log.info("selecting");
		return dataMapper.selectPendudukByKelurahan(id_kelurahan);
	}
}
