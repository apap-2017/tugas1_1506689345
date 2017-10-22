package com.tugas1.service;

import java.util.List;

import com.tugas1.model.KelurahanModel;

public interface KelurahanService {
	public KelurahanModel getKelurahanById(long id);
	
	public List<KelurahanModel> getAllKelurahan();
	
	public KelurahanModel getKelurahanById(Long id_kelurahan);
	
	public List<KelurahanModel> selectKelurahan(Long id_kecamatan);
}
