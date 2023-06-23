package com.example.newproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//import com.example.Fragment.*;
import com.example.newproject1.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.*;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CardView myoffers,upcoming,alloffers;
    TextView myofferstxt,upcomingtxt,allofferstxt;
    LinearLayout linearLayout;
   //
    ConstraintLayout maincontainer;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        replaceFragment(new HomeFragment());
       // offersfragment=findViewById(R.id.offersfragment);
       linearLayout=findViewById(R.id.linear);
        maincontainer=findViewById(R.id.maincontainer);
        alloffers=findViewById(R.id.allofferscard);
        myoffers=findViewById(R.id.my_offers);
        upcoming=findViewById(R.id.upcomig_offers);
        myofferstxt=findViewById(R.id.myofferstxt);
        upcomingtxt=findViewById(R.id.upcomingofferstxt);
        allofferstxt=findViewById(R.id.all_offers);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.home:
                    linearLayout.setVisibility(View.VISIBLE);
                    replaceFragment(new OffersFragment());
                    break;
                case R.id.wallet:
                    linearLayout.setVisibility(View.INVISIBLE);
                    replaceFragment(new WalletFragment());
                    break;
                case R.id.refer:
                    linearLayout.setVisibility(View.INVISIBLE);
                    replaceFragment(new ReferFragment());
                    break;
                case R.id.profile:
                    linearLayout.setVisibility(View.INVISIBLE);
                    replaceFragment(new ProfileFragment());
                    break;

            }
            alloffers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allofferstxt.setTextColor(Color.parseColor("#FFFFFFFF"));
                    alloffers.setCardBackgroundColor(Color.parseColor("#005bb8"));
                   myofferstxt.setTextColor(Color.parseColor("#000000"));
                    myoffers.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    upcomingtxt.setTextColor(Color.parseColor("#000000"));
                    upcoming.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    replaceFragment(new OffersFragment());


                }
            });

            myoffers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allofferstxt.setTextColor(Color.parseColor("#000000"));
                    alloffers.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    myofferstxt.setTextColor(Color.parseColor("#FFFFFFFF"));
                    myoffers.setCardBackgroundColor(Color.parseColor("#005bb8"));
                    upcomingtxt.setTextColor(Color.parseColor("#000000"));
                    upcoming.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));

                    replaceFragment(new MyoffersFragment());
                }
            });
            upcoming.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allofferstxt.setTextColor(Color.parseColor("#000000"));
                    alloffers.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    myofferstxt.setTextColor(Color.parseColor("#000000"));
                    myoffers.setCardBackgroundColor(Color.parseColor("#FFFFFFFF"));
                    upcomingtxt.setTextColor(Color.parseColor("#FFFFFFFF"));
                    upcoming.setCardBackgroundColor(Color.parseColor("#005bb8"));
                    replaceFragment(new UpcomingoffersFragment());
                }
            });

            return true;
        });


    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment,fragment);
        fragmentTransaction.commit();



    }


}

