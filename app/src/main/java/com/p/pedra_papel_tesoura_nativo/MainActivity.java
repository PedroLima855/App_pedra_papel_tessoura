package com.p.pedra_papel_tesoura_nativo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionarTessoura(View view) {
        this.opcaoSelecionada("tessoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {

        ImageView imagemResultado = (ImageView) findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        String[] opcoes = {"pedra", "papel", "tessoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tessoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (escolhaApp == "pedra" && escolhaUsuario == "tessoura") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "tessoura" && escolhaUsuario == "papel")) {
            textoResultado.setText("Você perdeu Estezinha :(");

        } else if ((escolhaUsuario == "pedra" && escolhaApp == "tessoura") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "tessoura" && escolhaApp == "papel")) {
            textoResultado.setText("Parabéns Ester, você ganhou !");
        } else {
            textoResultado.setText("Ops! deu empate!");
        }
    }

}