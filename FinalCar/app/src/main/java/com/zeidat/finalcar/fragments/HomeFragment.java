package com.zeidat.finalcar.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.zeidat.finalcar.R;
import rx.Subscription;
import rx.functions.Action1;

import java.text.DateFormat;
import java.util.Date;

public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private TextView clock , welcomeMessage ;
    private ListView dailyAppoitments ;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        clock = (TextView) view.findViewById(R.id.homeClock);
        welcomeMessage = (TextView) view.findViewById(R.id.homeWelcomeMessage);
        dailyAppoitments = (ListView) view.findViewById(R.id.homeAppointment);
        return view;
    }
    String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
//    Subscription clockEditText = RxTextView.textChanges(this.clock)
//            .subscribe(new Action1<CharSequence>() {
//                @Override
//                public void call(CharSequence charSequence) {
//                    Log.d("Tag", "call: ");
//                }
//            });


}
