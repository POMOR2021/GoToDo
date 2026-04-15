package com.example.gototodo;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gototodo.adapter.ViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewPager2 viewPager2 = findViewById(R.id.ViewPager);
        BottomNavigationView bnv = findViewById(R.id.bottomNav);

        ViewAdapter viewAdapter = new ViewAdapter(this);
        viewPager2.setAdapter(viewAdapter);

        bnv.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.homeFragment) {
                viewPager2.setCurrentItem(0);
            } else if (id == R.id.statsFragment) {
                viewPager2.setCurrentItem(1);
            } else if (id == R.id.settingsFragment) {
                viewPager2.setCurrentItem(2);
            }
            return true;
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                switch (position) {
                    case 0:
                        bnv.setSelectedItemId(R.id.homeFragment);
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.statsFragment);
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.settingsFragment);
                        break;
                }
            }
        });

    }
}