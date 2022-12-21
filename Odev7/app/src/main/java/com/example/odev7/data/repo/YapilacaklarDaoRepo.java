package com.example.odev7.data.repo;

import androidx.lifecycle.MutableLiveData;

import com.example.odev7.data.entity.Yapilacaklar;
import com.example.odev7.room.YapilacaklarDao;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class YapilacaklarDaoRepo {
    private MutableLiveData<List<Yapilacaklar>> yapilacaklarList;
    private YapilacaklarDao yapilacaklarDao;

    public YapilacaklarDaoRepo(YapilacaklarDao yapilacaklarDao){
        this.yapilacaklarDao = yapilacaklarDao;
        yapilacaklarList = new MutableLiveData();
    }

    public MutableLiveData<List<Yapilacaklar>> getYapilacaklarList() {
        return yapilacaklarList;
    }

    public void yapilacaklariYukle(){
        yapilacaklarDao.yapilacaklariYukle().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Yapilacaklar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Yapilacaklar> yapilacaklars) {
                        yapilacaklarList.setValue(yapilacaklars);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void ara(String aramaKelimesi){
        yapilacaklarDao.ara(aramaKelimesi).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Yapilacaklar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Yapilacaklar> yapilacaklars) {
                        yapilacaklarList.setValue(yapilacaklars);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void guncelle(int id, String name){
        Yapilacaklar guncellenenIs = new Yapilacaklar(id, name);
        yapilacaklarDao.guncelle(guncellenenIs).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void kayit(String name){
        Yapilacaklar yeniIs = new Yapilacaklar(0, name);
        yapilacaklarDao.kayit(yeniIs).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });
    }
    public void sil(int id){
        Yapilacaklar silinenIs = new Yapilacaklar(id, "");
        yapilacaklarDao.sil(silinenIs).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {}

                    @Override
                    public void onError(Throwable e) {}
                });
    }
}