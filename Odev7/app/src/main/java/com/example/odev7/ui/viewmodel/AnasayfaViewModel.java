package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.odev7.data.entity.Yapilacaklar;
import com.example.odev7.data.repo.YapilacaklarDaoRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {
    private YapilacaklarDaoRepo yapilacaklarDaoRepo;
    public MutableLiveData<List<Yapilacaklar>> yapilacaklarList = new MutableLiveData<>();

    @Inject
    public AnasayfaViewModel(YapilacaklarDaoRepo yapilacaklarDaoRepo){
        this.yapilacaklarDaoRepo = yapilacaklarDaoRepo;
        yapilacaklariYukle();
        yapilacaklarList = yapilacaklarDaoRepo.getYapilacaklarList();
    }

    public void ara(String aramaKelimesi) {
        yapilacaklarDaoRepo.ara(aramaKelimesi);
    }
    public void sil(int id) {
        yapilacaklarDaoRepo.sil(id);
    }
    public void yapilacaklariYukle() {
        yapilacaklarDaoRepo.yapilacaklariYukle();
    }
}
