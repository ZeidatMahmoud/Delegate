package com.zeidat.finalcar.dagger;

import com.zeidat.finalcar.fragments.*;
import dagger.Module;
import dagger.Provides;

@Module
public class FragmentsModule {

    @Provides
    public Calender provideCalender(){
        return new Calender();
    }

    @Provides
    public StudentsFragment provideStudents(){
        return new StudentsFragment() ;
    }
    @Provides
    public HomeFragment provideHomeFragemnt(){
        return new HomeFragment() ;
    }
    @Provides
    public AddAppointment provideAppointmentFragment(){
        return new AddAppointment() ;
    }
    @Provides
    public VehicleFragment provideVehicleFragment(){
        return new VehicleFragment();
    }



}
