package com.zeidat.finalcar.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Context context ;
    public AppModule(Context context){
        this.context = context ;

    }
    @Provides
    public SharedPreferences provideSharedPreferences(){
        return context.getSharedPreferences("login" , Context.MODE_PRIVATE) ;
    }

    @Provides
    public SharedPreferences.Editor provideSharedPreferencesEditor(){
        return context.getSharedPreferences("login",Context.MODE_PRIVATE).edit();
    }



}
