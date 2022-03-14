package com.example.appaeroporto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ImageView imagem;
    TextView texto;

    Animation aparece;
    Animation some;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagem = findViewById(R.id.minhaImagem);
        texto = findViewById(R.id.meuTexto);

        texto.setText("Toque para Continar");
        imagem.setVisibility(View.INVISIBLE);

        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        some.setDuration(500);
        aparece.setDuration(500);

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
                imagem.startAnimation(some);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
                texto.setText("Toque para Continar");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void clicouTela(View view){


        if (Math.random() < 0.5) {
            texto.setText("Siga para esquerda");
            imagem.setScaleX(1f);
        }else {
            texto.setText("Siga para direita");
            imagem.setScaleX(-1f);

        }
        imagem.startAnimation(aparece);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                imagem.startAnimation(some);
            }
        }, 3000);


    }
}