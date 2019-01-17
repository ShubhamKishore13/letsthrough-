package com.letsthrough.groceryapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsthrough.groceryapp.activities.AuthenticateActivity;
import com.letsthrough.groceryapp.databinding.FragmentSplashBinding;

import org.jetbrains.annotations.NotNull;

import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;

public class SplashFragment extends Fragment
{
    private static final String IMAGE_FILE = "image" ;
    private static final String IMAGE_IS_FINAL = "final" ;

    public SplashFragment() {}

    public static SplashFragment getInstance(int image , boolean isFinal)
    {
        SplashFragment splashFragment = new SplashFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(IMAGE_FILE,image);
        bundle.putBoolean(IMAGE_IS_FINAL,isFinal);

        splashFragment.setArguments(bundle);

        return splashFragment;
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        FragmentSplashBinding fragmentSplashBinding = FragmentSplashBinding.inflate(inflater,container,false);

        if (getArguments() != null)
        {
            fragmentSplashBinding.setImage(getArguments().getInt(IMAGE_FILE));
            fragmentSplashBinding.setNextIsVisible(new ObservableField<>(getArguments().getBoolean(IMAGE_IS_FINAL)));
            fragmentSplashBinding.setNextListener( v ->
            {
                startActivity(new Intent(getContext(),AuthenticateActivity.class));
                getActivity().finish();
            });
        }

        return fragmentSplashBinding.getRoot();
    }

}
