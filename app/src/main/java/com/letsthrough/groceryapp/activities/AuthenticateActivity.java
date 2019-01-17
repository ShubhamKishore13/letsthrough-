package com.letsthrough.groceryapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;

import android.os.Bundle;

import com.letsthrough.groceryapp.R;
import com.letsthrough.groceryapp.databinding.ActivityAuthenticateBinding;

public class AuthenticateActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityAuthenticateBinding activityAuthenticateBinding = DataBindingUtil.setContentView(this,R.layout.activity_authenticate);

        activityAuthenticateBinding.setSwitchView(new ObservableField<>(true));
        activityAuthenticateBinding.setIsEnabled(new ObservableField<>(true));

    }
}
