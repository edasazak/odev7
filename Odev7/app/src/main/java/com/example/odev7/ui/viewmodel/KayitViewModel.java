package com.example.odev7.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.odev7.data.repo.YapilacaklarDaoRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class KayitViewModel extends ViewModel {
    private YapilacaklarDaoRepo yapilacaklarDaoRepo;

    @Inject
    public KayitViewModel(YapilacaklarDaoRepo yapilacaklarDaoRepo) {
        this.yapilacaklarDaoRepo = yapilacaklarDaoRepo;
    }

    public void kayit(String name){
        yapilacaklarDaoRepo.kayit(name);
    }
}
