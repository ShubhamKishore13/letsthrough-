package com.letsthrough.groceryapp.adapters;

import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.google.android.material.button.MaterialButton;

import androidx.databinding.BindingAdapter;
import androidx.databinding.ObservableField;

public class BindingAdapters
{
    @BindingAdapter("switchView")
    public static void switchView(ViewSwitcher view, ObservableField<Boolean> switchChecked)
    {
        if (switchChecked != null )
        {
            Boolean b = switchChecked.get();
            if (b != null) if (b) view.showNext();
            else view.showPrevious();
        }
    }

    @BindingAdapter("switchListener")
    public static void switchListener(MaterialButton view, ObservableField<Boolean> switchChecked)
    {
        if (switchChecked != null)
        {
            Boolean b = switchChecked.get();
            if (b != null) view.setOnClickListener(v -> switchChecked.set(!b));
        }
    }

    @BindingAdapter("imageSrc")
    public static void setImageSrc(ImageView view , int src)
    {
        view.setImageResource(src);
    }
}