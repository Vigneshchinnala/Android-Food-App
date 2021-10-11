package com.example.food_ordering_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.food_ordering_app.Adapters.MainAdapter;
import com.example.food_ordering_app.Models.MainModel;
import com.example.food_ordering_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list=new ArrayList<>();
        list.add(new MainModel(R.drawable.burge, "Burger", "40", "Veg burger"));
        list.add(new MainModel(R.drawable.burger, "HamBurger", "60", "Veg hamburger"));
        list.add(new MainModel(R.drawable.chau, "Hakka noodles", "70", "Full plate hakka noodles"));
        list.add(new MainModel(R.drawable.chaumin, "Noodles", "80", "Full plate veg noodles"));
        list.add(new MainModel(R.drawable.momos, "Momos", "100", "Veg Tandoori momos"));

        MainAdapter adapter=new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(linearLayoutManager);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()){
           case R.id.ordernum:
               startActivity(new Intent(MainActivity.this, OrdersActivity.class));
               break;
       }
        return super.onOptionsItemSelected(item);
    }
}
