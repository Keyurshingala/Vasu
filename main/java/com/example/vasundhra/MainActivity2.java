package com.example.vasundhra;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.vasundhra.databinding.ActivityMain2Binding;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    MainActivity2 mContext;
    ActivityMain2Binding binding;
    LinearLayout linearLayout;
    Button button[];
    int num, rNum, i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mContext = this;

        try {
            num = Integer.parseInt(getIntent().getStringExtra("num"));
        } catch (Exception e) {
            Toast.makeText(mContext, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        Random random = new Random();
        rNum = random.nextInt(num);

        button = new Button[num];

        int k = 0;
        if (num % 4 == 0) {
            for (i = 1; i <= num / 4; i++) {
                linearLayout = new LinearLayout(mContext);
                for (j = 1; j <= 4; j++) {
                    button[i] = new Button(mContext);
                    if (k == rNum) {
                        button[i].setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.purple_200));
                    }
                    linearLayout.addView(button[i], WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    k++;
                }
                binding.parent.addView(linearLayout, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            }
        } else if (num % 4 != 0) {
            for (i = 1; i <= (num - (num % 4)) / 4; i++) {
                linearLayout = new LinearLayout(mContext);
                for (j = 1; j <= 4; j++) {
                    button[k] = new Button(mContext);
                    if (k == rNum) {
                        button[k].setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.purple_200));
                    }
                    linearLayout.addView(button[k], WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    k++;
                }
                binding.parent.addView(linearLayout, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            }
            for (i = 1; i < 2; i++) {
                linearLayout = new LinearLayout(mContext);
                for (j = 1; j <= num % 4; j++) {
                    button[k] = new Button(mContext);
                    if (k == rNum) {
                        button[k].setBackgroundTintList(ContextCompat.getColorStateList(mContext, R.color.purple_200));
                    }
                    linearLayout.addView(button[k], WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
                    k++;
                }
                binding.parent.addView(linearLayout, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
            }

        }
    }
}