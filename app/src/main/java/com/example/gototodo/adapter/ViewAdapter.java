package com.example.gototodo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gototodo.HomeFragment;
import com.example.gototodo.MainActivity;
import com.example.gototodo.SettingsFragment;
import com.example.gototodo.StatsFragment;

public class ViewAdapter extends FragmentStateAdapter {
    public ViewAdapter(@NonNull MainActivity mainActivity){
        super(mainActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position) {
            case 0: return new HomeFragment();
            case 1: return new StatsFragment();
            case 2: return new SettingsFragment();
            default: return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
