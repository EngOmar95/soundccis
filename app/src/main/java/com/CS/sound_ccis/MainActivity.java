package com.CS.sound_ccis;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

import com.CS.sound_ccis.R;
import com.google.android.material.navigation.NavigationView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;


    NavigationView navigationView ;

    SharedPreferences sharedPreferences;
    Bundle bundle;
    TextView Name ;
    TextView email  ;
    HomeFragment homeFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String FullName;
    String Email ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
         FullName =   sharedPreferences.getString("first_name","0") +" "+  sharedPreferences.getString("last_name","0");
         Email =   sharedPreferences.getString("Email","0")  ;

        String choes =   sharedPreferences.getString("Choes","0")  ;


        DrawerLayout drawer = findViewById(R.id.drawer_layout);


     //   NavigationView navigationView = findViewById(R.id.nav_view);

        View headerView=  navigationView.getHeaderView(0)  ;

         Name=headerView.findViewById(R.id.Name)   ;
         email=headerView.findViewById(R.id.email)   ;

        Name.setText(FullName);
        email.setText(Email);
         bundle=new Bundle();
        bundle.putString("Name",FullName);
        bundle.putString("Email",Email);
         homeFragment =new HomeFragment();
        homeFragment.setArguments(bundle);

         fragmentManager =getSupportFragmentManager();
         fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment,homeFragment)     ;
        fragmentTransaction.commit();


           if(choes.equals("User")){

               navigationView.getMenu().findItem(R.id.Mang_info).setVisible(false)       ;
               navigationView.getMenu().findItem(R.id.Mang_feedback).setVisible(false)       ;
           }

        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.about_college, R.id.Mang_info)
                .setDrawerLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);




    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
         FullName =   sharedPreferences.getString("first_name","0") +" "+  sharedPreferences.getString("last_name","0");
         Email =   sharedPreferences.getString("Email","0")  ;
         bundle=new Bundle();
        bundle.putString("Name",FullName);
        bundle.putString("Email",Email);
        homeFragment =new HomeFragment();
        homeFragment.setArguments(bundle);

        fragmentManager =getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment,homeFragment)     ;
        fragmentTransaction.commit();



        navigationView = findViewById(R.id.nav_view);
        View headerView=  navigationView.getHeaderView(0)  ;

         Name=headerView.findViewById(R.id.Name)   ;
         email=headerView.findViewById(R.id.email)   ;

        Name.setText(FullName);
        email.setText(Email);

    }



}