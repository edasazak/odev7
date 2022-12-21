package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.odev7.data.repo.YapilacaklarDaoRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetayViewModel extends ViewModel {
    private YapilacaklarDaoRepo yapilacaklarDaoRepo;

    @Inject
    public DetayViewModel(YapilacaklarDaoRepo yapilacaklarDaoRepo) {
        this.yapilacaklarDaoRepo = yapilacaklarDaoRepo;
    }

    public void guncelle(int id, String name){
        yapilacaklarDaoRepo.guncelle(id,name);
    }
}
