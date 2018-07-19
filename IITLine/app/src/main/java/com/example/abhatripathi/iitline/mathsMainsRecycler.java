package com.example.abhatripathi.iitline;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class mathsMainsRecycler extends AppCompatActivity {
    ArrayList<mathsMainsQuestion1> MathsArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_mains_recycler);
        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        MathsArrayList.add(new mathsMainsQuestion1("QUESTION 1:", "2+4=?", "ITS basic 6", "6","7","8","4"));
        RecyclerView recyclerView = findViewById(R.id.rvMaths);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AdapterMaths1 AdapterMaths1 = new AdapterMaths1(MathsArrayList,this);
        recyclerView.setAdapter(AdapterMaths1);

    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0 :
                    return "Questions";
                case 1 :
                    return "Videos";
                case 2 :
                    return "Progress";
                default:
                    return null;
            }
        }

        @Override
        public Fragment getItem(int i) {
            switch (i){
                case 0 :
                    return new FragmentQues();
                case 1 :
                    return new FragmentVideo();
                case 2 :
                    return new FragmentProgress();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
