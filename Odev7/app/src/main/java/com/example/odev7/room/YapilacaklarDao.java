package com.example.odev7.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.odev7.data.entity.Yapilacaklar;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface YapilacaklarDao {
    @Query("SELECT * FROM toDos")
    Single<List<Yapilacaklar>> yapilacaklariYukle();

    @Query("SELECT * FROM toDos WHERE name LIKE '%' || :aramaKelimesi || '%'")
    Single<List<Yapilacaklar>> ara(String aramaKelimesi);

    @Delete
    Completable sil(Yapilacaklar yapilacak);

    @Insert
    Completable kayit(Yapilacaklar yapilacak);

    @Update
    Completable guncelle(Yapilacaklar yapilacak);
}
