package com.ic.bnvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ic.bnvp.pages.HomePageFragment;
import com.ic.bnvp.pages.ProfilePageFragment;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter mViewPagerAdapter;
    ViewPager2 viewpager;

    HomePageFragment homePageFragment;
    ProfilePageFragment profilePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this.getLifecycle());
        initView();
        createFragments();
        addFragments();
    }

    private void createFragments() {
        profilePageFragment = new ProfilePageFragment(this);
        homePageFragment = new HomePageFragment(this);
    }

    @SuppressLint("NonConstantResourceId")
    private void initView() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewpager = findViewById(R.id.viewpager);
        viewpager.setAdapter(mViewPagerAdapter);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    viewpager.setCurrentItem(0);
                    break;
                case R.id.profile:
                    viewpager.setCurrentItem(1);
                    break;
            }
            return true;
        });
        viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.profile);
                        break;
                }
                super.onPageSelected(position);
            }
        });
    }

    private void addFragments() {
        mViewPagerAdapter.addFragment(homePageFragment);
        mViewPagerAdapter.addFragment(profilePageFragment);
    }
}