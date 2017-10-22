package com.tugas1.model;

import java.lang.reflect.Field;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeluargaModel {
	private long id;
	private String nomor_kk;
	private String alamat;
	private String RT;
	private String RW;
	private long id_kelurahan;
	private int is_tidak_berlaku;
	private KelurahanModel kelurahan;
	private List<PendudukModel> anggota_keluarga;
	
	public boolean isOkay() throws IllegalAccessException {
	    for (Field f : getClass().getDeclaredFields()) {
	    	if (f.getName() == "is_tidak_berlaku" ||
	    			f.getName() == "kelurahan" ||
	    			f.getName() == "anggota_keluarga")
	    		continue;
	    	
	    	if (f.get(this) == null)
	            return false;
	    	
	    }
	        
	    return true;            
	}
}
