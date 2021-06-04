package com.hiberus.kruger.hiberuskrugerapp.ui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.hiberus.kruger.hiberuskrugerapp.BaseActivity;
import com.hiberus.kruger.hiberuskrugerapp.R;
import com.hiberus.kruger.hiberuskrugerapp.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.navigate(R.id.homeScreen);
        NavigationUI.setupActionBarWithNavController(this, navController);
    }



    @Override
    public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.nav_host_fragment).navigateUp()
                || super.onSupportNavigateUp();
    }
}