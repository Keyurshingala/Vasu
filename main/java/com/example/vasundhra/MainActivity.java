package com.example.vasundhra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vasundhra.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnStart.setOnClickListener(v -> {
            String numSt = binding.etNum.getText().toString().trim();
            if (numSt.equals("")){
                Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();

            }else if(Integer.parseInt(numSt)<10){
                Toast.makeText(this, "Enter num > 10", Toast.LENGTH_SHORT).show();

            } else{
                Intent intent = new Intent(this,MainActivity2.class);
                intent.putExtra("num",numSt);
                startActivity(intent);
            }
        });
    }
}