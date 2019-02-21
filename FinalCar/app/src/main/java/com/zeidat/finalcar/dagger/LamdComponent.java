package com.zeidat.finalcar.dagger;

import com.zeidat.finalcar.activities.GetLamd;
import dagger.Component;

@Component(modules =  {FragmentsModule.class,AppModule.class})
public interface LamdComponent {
    void inject(GetLamd home) ;

}
