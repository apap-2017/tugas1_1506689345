package com.tugas1.service;

import java.util.List;

import com.tugas1.model.KeluargaModel;

public interface KeluargaService {
	public KeluargaModel getKeluarga(String nkk);
	
	public KeluargaModel getKeluargaById(long id);
	
	public boolean insertKeluarga(KeluargaModel keluargaModel);
	
	public List<KeluargaModel> getKeluargaByPrefixNkk(String prefix);
	
	public boolean updateKeluarga(KeluargaModel keluargaModel, String oldNkk);
	
	public boolean updateKeluarga2(KeluargaModel keluargaModel, String oldNkk);
}
