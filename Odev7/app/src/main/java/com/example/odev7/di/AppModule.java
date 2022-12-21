package com.example.odev7.di;

import android.content.Context;

import androidx.room.Room;

import com.example.odev7.data.repo.YapilacaklarDaoRepo;
import com.example.odev7.room.Veritabani;
import com.example.odev7.room.YapilacaklarDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public YapilacaklarDaoRepo provideYapilacaklarDaoRepo(YapilacaklarDao yapilacaklarDao) {
        return new YapilacaklarDaoRepo(yapilacaklarDao);
    }
    @Provides
    @Singleton
    public YapilacaklarDao provideYapilacaklarDao(@ApplicationContext Context context) {
        Veritabani vt = Room.databaseBuilder(context, Veritabani.class, "todos.sqlite")
                .createFromAsset("todos.sqlite").build();

        return vt.getYapilacaklarDao();
    }
}
