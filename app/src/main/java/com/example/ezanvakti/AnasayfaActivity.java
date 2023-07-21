package com.example.ezanvakti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;
import java.util.Random;

public class AnasayfaActivity extends AppCompatActivity {

    private TextView diziBaslikTxt;
    private TextView imdbRatingTxt;
    private ImageView filmFoto;
    private Button randomDiziButton;

    private String[] filmListesi={"Tatlı Hayat (1960)","Roma Tatili (1953)", "Şarkı Sokağı (2016)"," Barb and Star Go to Vista Del Mar (2021)",
    " The Kissing Booth 2 (2020)", "Deadpool (2016)"," Dağ 2 (2016)", "Kış Uykusu(Türk)","Cep Herkülü: Naim Süleymanoğlu","Bir Zamanlar Anadolu'da(Türk)"," Nefes: Vatan Sağolsun(2009)","Bizim Için Sampiyon (Türk)","Uçurtmayi Vurmasinlar(Türk)","7. Koğuştaki Mucize(Türk)"};
            private double[] imdbPuanlari={8.1,8.0,7.9,6.3,5.7,8.0,8.2,8.1,8.2,7.8,8.0,8.2,8.3,8.2};
            private int[] filmFotolari= {R.drawable.tatlihayat,R.drawable.romatatili,R.drawable.sarkisokagi,R.drawable.barb,
            R.drawable.thekissing,R.drawable.deadpool,R.drawable.dag2,R.drawable.kisuykusu,R.drawable.naimsuleymanoglu,R.drawable.birzamanlaranadoluda,R.drawable.nefes,R.drawable.bizimicinsampiyon,R.drawable.ucurtma,R.drawable.kogustakimucize};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        diziBaslikTxt=findViewById(R.id.movie_title);
        imdbRatingTxt=findViewById(R.id.imdb_rating);
        filmFoto=findViewById(R.id.movie_image);
        randomDiziButton=findViewById(R.id.random_movie_button);

        randomDiziButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rastgeleFilmSec();

            }
        });

        ImageView settingsIcon  =findViewById(R.id.settingsIcon);
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(AnasayfaActivity.this,SettingsActivity.class);
                startActivity(intent);
            }
        });


        }

        private void rastgeleFilmSec(){
            Random random = new Random();
            int randomIndex=random.nextInt(filmListesi.length);

            String randomFilmAdi=filmListesi[randomIndex];
            double randomImdbPuani=imdbPuanlari[randomIndex];
            int randomFoto=filmFotolari[randomIndex];

            diziBaslikTxt.setText(randomFilmAdi);
            imdbRatingTxt.setText("IMDb Puanı: " + randomImdbPuani);
            filmFoto.setImageResource(randomFoto);
    }
}