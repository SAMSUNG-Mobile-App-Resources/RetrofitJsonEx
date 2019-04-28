package com.example.retrofitjsonex.viewmodel;

import com.example.retrofitjsonex.model.Api;
import javax.inject.Singleton;
import dagger.Component;

/*
 * ApiComponent.java : Dagger interface for Retrofit object injection
 * Author : DONGGEUN JUNG (Dennis)
 * Date : Apr.16.2019
 */
@Singleton
@Component(modules = {ApiModule.class})
interface ApiComponent {
    Api provideApi();

    void inject(DataViewModel viewModel);
}
