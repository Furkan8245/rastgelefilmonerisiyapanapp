package com.example.ezanvakti;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    private Switch geceModuSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        geceModuSwitch=findViewById(R.id.geceModuSwitch);
        geceModuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        ImageView hakkindaImage=findViewById(R.id.hakkindaImage);
        hakkindaImage.setOnClickListener(view -> {
            showAboutDialog();
        });


    }

    private void showAboutDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Uygulama Hakkında");
        builder.setMessage("Uygulamamız izleyecek film bilmiyorsanız size rastgele film önerisi yapmaktadır. IMDB puanları ile birlikte size sunulmaktadır. Şimdiden İyi Seyirler...  Uygulama Sahibi : @Furkan Keleş");
        builder.setPositiveButton("Tamam",null);
        builder.show();
    }

}