package com.zeidat.finalcar.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.zeidat.finalcar.R ;
import com.zeidat.finalcar.models.Cookie;
import com.zeidat.finalcar.models.LoginUser;
import com.zeidat.finalcar.services.API;
import com.zeidat.finalcar.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    private Button login ;
    private EditText username ,pasword ;
    private ProgressBar bar ;
    private SharedPreferences sharedPreferences ;
    private SharedPreferences.Editor editor ;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPreferences  = getSharedPreferences("login" ,Context.MODE_PRIVATE) ;
       // editor = sharedPreferences.ed   it() ;

        String token = sharedPreferences.getString("token" , "no");
        if(!token.equals("no")){
            Intent intent = new Intent(Login.this , GetLamd.class) ;
            //finish();
            startActivity(intent);
            finish();
        }
        setTheme(R.style.AppTheme); //back to default theme
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final API service =  ServiceGenerator.createService(API.class) ;

        login = (Button)findViewById(R.id.loginButton);
        username = (EditText)findViewById(R.id.LoginUserName);
        pasword  = (EditText)findViewById(R.id.loginPassword);
        bar = (ProgressBar)findViewById(R.id.loginBar) ;
        bar.setVisibility(View.INVISIBLE);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bar.setVisibility(View.VISIBLE);
                String strUserName , strPassword ;
                strUserName = username.getText().toString() ;
                strPassword = pasword.getText().toString() ;
                /**
                 * if the user not connected to ther internet
                 * avoid useless internet request
                 */
                if(!isNetworkConnected(getApplicationContext())){
                    Toast.makeText(Login.this, "check your internet connection", Toast.LENGTH_SHORT).show();
                    bar.setVisibility(View.INVISIBLE);
                    return;
                }

                try{
                   Call<Cookie> cal = service.getCookie(new LoginUser(strUserName ,strPassword)) ;

                   cal.enqueue(new Callback<Cookie>() {
                       @Override
                       public void onResponse(Call<Cookie> call, Response<Cookie> response) {
                          // Log.d("Response", "onResponse: "  +  response.body().toString());
                           Toast.makeText(Login.this , response.body().getToken() , Toast.LENGTH_LONG).show();
                           editor = getSharedPreferences("login" , Context.MODE_PRIVATE).edit();
                           editor.putString("token" ,response.body().getToken()).commit(); //save token to sharedPreferences

                           /**
                            * move to InstructorHome Activity
                            */
                           bar.setVisibility(View.INVISIBLE);
                           //TODO make Toast b ll arabic
                           try{
                               Intent intent = new Intent(Login.this , GetLamd.class) ;
                               //finish();
                               startActivity(intent);
                               finish();
                           }
                           catch(Exception e){
                               Log.d("TAG", "onResponse: ");
                           }

                       }

                       @Override
                       public void onFailure(Call<Cookie> call, Throwable t) {
                           bar.setVisibility(View.INVISIBLE);
                           Toast.makeText(Login.this, "Check UserName or Password " ,Toast.LENGTH_LONG).show();
                       }
                   });

                }
                catch (Exception e){
                    Log.d("TAG", "onClick: " + e.getMessage());

                }

            }
        });

    }

//    public LamdComponent getLamdComponent(){
//        return DaggerLamdComponent.builder()
//                .fragmentsModule(new FragmentsModule())
//                .build();
//    }

    /**
     * check network status
     * @param context
     * @return
     */
    public boolean isNetworkConnected(Context context){
        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected ;
    }
}
