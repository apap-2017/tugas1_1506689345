package com.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tugas1.model.KecamatanModel;
import com.tugas1.model.KeluargaModel;
import com.tugas1.model.KelurahanModel;
import com.tugas1.model.KotaModel;
import com.tugas1.model.PendudukModel;

@Mapper
public interface DataMapper {
	@Select("select * from penduduk where id_keluarga=#{id_keluarga}")
	List<PendudukModel> selectPendudukByIdKeluarga(@Param("id_keluarga") Long id_keluarga);

	@Select("select * from kota where id=#{id}")
	KotaModel selectKotaById(@Param("id") Long id);
	
	@Select("select * from penduduk order by id DESC LIMIT 1")
	PendudukModel getLatestPenduduk();
	
	@Select("select * from penduduk where nik LIKE #{prefix}")
	List<PendudukModel> getPendudukByPrefixNik(String prefix);
	
	@Select("SELECT * from kota")
	List<KotaModel> selectAllKota();
	
	@Select("SELECT * from kecamatan where id_kota=#{id_kota}")
	List<KecamatanModel> selectKecamatan(Long id_kota);
	
	@Select("SELECT * from kelurahan where id_kecamatan=#{id_kecamatan}")
	List<KelurahanModel> selectKelurahan(Long id_kecamatan);
	
	@Select("SELECT p.* from penduduk p, keluarga k where p.id_keluarga = k.id and k.id_kelurahan=#{id_kelurahan}")
	List<PendudukModel> selectPendudukByKelurahan(Long id_kelurahan);
	
	@Select("select * from keluarga order by id DESC LIMIT 1")
	KeluargaModel getLatestKeluarga();
	
	@Select("select * from keluarga where nomor_kk LIKE #{prefix}")
	List<KeluargaModel> getKeluargaByPrefixNkk(String prefix);
	
	@Insert("INSERT INTO keluarga (id, nomor_kk, alamat, RT, RW, id_kelurahan) VALUES (#{id}, #{nomor_kk}, #{alamat}, #{RT}, #{RW}, #{id_kelurahan})")
	void insertKeluarga(KeluargaModel keluarga);
	
	@Insert("INSERT INTO penduduk (id, nik, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, is_wni, id_keluarga, agama, pekerjaan, status_perkawinan, status_dalam_keluarga, golongan_darah, is_wafat) VALUES (#{id}, #{nik}, #{nama}, #{tempat_lahir}, #{tanggal_lahir}, #{jenis_kelamin}, #{is_wni}, #{id_keluarga}, #{agama}, #{pekerjaan}, #{status_perkawinan}, #{status_dalam_keluarga}, #{golongan_darah}, #{is_wafat})")
	void insertPenduduk(PendudukModel penduduk);
	
	@Update("UPDATE penduduk SET nik=#{penduduk.nik}, nama=#{penduduk.nama}, tempat_lahir=#{penduduk.tempat_lahir}, tanggal_lahir=#{penduduk.tanggal_lahir}, is_wni=#{penduduk.is_wni}, id_keluarga=#{penduduk.id_keluarga}, agama=#{penduduk.agama}, pekerjaan=#{penduduk.pekerjaan}, status_perkawinan=#{penduduk.status_perkawinan}, status_dalam_keluarga=#{penduduk.status_dalam_keluarga}, golongan_darah=#{penduduk.golongan_darah}, is_wafat=#{penduduk.is_wafat} WHERE nik=#{oldNik}")
	void updatePenduduk(@Param("penduduk") PendudukModel penduduk, @Param("oldNik") String oldNik);
	
	@Update("UPDATE keluarga SET nomor_kk=#{keluarga.nomor_kk}, alamat=#{keluarga.alamat}, RT=#{keluarga.RT}, RW=#{keluarga.RW}, id_kelurahan=#{keluarga.id_kelurahan} WHERE nomor_kk=#{oldNkk}")
	void updateKeluarga(@Param("keluarga") KeluargaModel keluarga, @Param("oldNkk") String oldNkk);
	
	@Update("UPDATE keluarga SET is_tidak_berlaku=#{keluarga.is_tidak_berlaku} WHERE nomor_kk=#{oldNkk}")
	void updateKeluarga2(@Param("keluarga") KeluargaModel keluarga, @Param("oldNkk") String oldNkk);
	
	@Select("select * from penduduk where nik=#{nik}")
	@Results(value = { 
			@Result(property = "keluarga", column = "id_keluarga", 
					javaType = KeluargaModel.class, 
					many = @Many(select = "selectKeluargaById")) 
	})
	PendudukModel selectPenduduk(@Param("nik") String nik);
	
	@Select("select * from keluarga where id=#{id}")
	@Results(value = { 
			@Result(property = "kelurahan", column = "id_kelurahan", 
					javaType = KelurahanModel.class, 
					many = @Many(select = "selectKelurahanById")) 
	})
	KeluargaModel selectKeluargaById(@Param("id") Long id);
	
	@Select("select * from kelurahan where id=#{id}")
	@Results(value = { 
			@Result(property = "kecamatan", column = "id_kecamatan", 
					javaType = KecamatanModel.class, 
					many = @Many(select = "selectKecamatanById")) 
	})
	KelurahanModel selectKelurahanById(@Param("id") Long id);
	
	@Select("select * from kecamatan where id=#{id}")
	@Results(value = { 
			@Result(property = "kota", column = "id_kota", 
					javaType = KotaModel.class, 
					many = @Many(select = "selectKotaById")) 
	})
	KecamatanModel selectKecamatanById(@Param("id") Long id);
	
	@Select("select * from keluarga where nomor_kk=#{nkk}")
	@Results(value = { 
			@Result(property = "kelurahan", column = "id_kelurahan", 
					javaType = KelurahanModel.class, 
					many = @Many(select = "selectKelurahanById")) 
	})
	KeluargaModel selectKeluarga(@Param("nkk") String nkk);
	
	@Select("select * from kelurahan")
	@Results(value = { 
			@Result(property = "kecamatan", column = "id_kecamatan", 
					javaType = KecamatanModel.class, 
					many = @Many(select = "selectKecamatanById")) 
	})
	List<KelurahanModel> getAllKelurahan();
}
