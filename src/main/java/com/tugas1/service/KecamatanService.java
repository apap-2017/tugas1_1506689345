package com.tugas1.service;

import java.util.List;

import com.tugas1.model.KecamatanModel;

public interface KecamatanService {
	public List<KecamatanModel> selectKecamatan(Long id_kota);
}
