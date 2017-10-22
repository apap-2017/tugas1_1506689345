package com.tugas1.service;

import java.util.List;

import com.tugas1.model.PendudukModel;

public interface PendudukService {
	public PendudukModel getPenduduk(String nik);
	
	public boolean insertPenduduk(PendudukModel pendudukModel);
	
	public List<PendudukModel> getPendudukByPrefixNik(String prefix);

	public boolean updatePenduduk(String oldNik, PendudukModel penduduk);
	
	public List<PendudukModel> selectPendudukByKelurahan(Long id_kelurahan);
}
