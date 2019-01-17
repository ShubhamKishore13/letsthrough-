package com.letsthrough.groceryapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.letsthrough.groceryapp.R;
import com.letsthrough.groceryapp.databinding.ActivitySplashBinding;
import com.letsthrough.groceryapp.fragments.SplashFragment;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding splashBinding = DataBindingUtil.setContentView(this,R.layout.activity_splash);

        String PREF_NAME = "App Pref";
        SharedPreferences appPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

        String IS_FIRST = "first";
        if (appPreferences.contains(IS_FIRST))
        {
            startActivity(new Intent(getApplicationContext(),AuthenticateActivity.class));
            finish();
        }
        else appPreferences.edit().putBoolean(IS_FIRST,false).apply();

        splashBinding.setSplashPagerAdapter(new SplashAdapter(getSupportFragmentManager()));

    }

    private class SplashAdapter extends FragmentPagerAdapter
    {
        private SplashAdapter(FragmentManager fm) { super(fm); }

        @Override
        public Fragment getItem(int position)
        {
            switch (position)
            {
                case 0: return SplashFragment.getInstance(R.drawable.splash_one,false);
                case 1: return SplashFragment.getInstance(R.drawable.splash_two,false);
                case 2: return SplashFragment.getInstance(R.drawable.splash_three,true);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

}
