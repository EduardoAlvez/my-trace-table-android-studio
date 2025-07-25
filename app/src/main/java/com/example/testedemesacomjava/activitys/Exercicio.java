package com.example.testedemesacomjava.activitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import android.content.Intent;

import com.example.testedemesacomjava.R;
import com.example.testedemesacomjava.models.RespostasAritmetico;
import com.example.testedemesacomjava.models.RespostasCondicionais;
import com.example.testedemesacomjava.models.RespostasEstruturaDeRepeticao;
import com.example.testedemesacomjava.models.RespostasLista;

public class Exercicio extends AppCompatActivity {

    EditText campo1, campo2, campo3, campo4, campo5,
            campo6, campo7, campo8, campo9, campo10,
            campo11, campo12, campo13, campo14, campo15,
            campo16, campo17, campo18, campo19, campo20,
            campo21, campo22, campo23, campo24, campo25,
            campo26, campo27, campo28, campo29, campo30;

    private String numeroExercicio = null;
    private TextView textTituloMenu = null;
    private String tipoExercicio = null;
    private Button buttonTentarDenovo;
    private Button buttonRetornarMenuExercicio;
    private Button buttonVerificarRestposta;
    boolean acertouTudo = true;

    boolean tentandoNovamente = false;

    private EditText legendaLinha1, legendaLinha2, legendaLinha3,
    legendaLinha4, legendaLinha5, legendaLinha6, legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10;


    private EditText legendaVariavel1, legendaVariavel2, legendaVariavel3;
    private ImageView imagemExercicio;

    List<String> respostaUsuario = new ArrayList<>();

    List<EditText> campos = new ArrayList<>();

    RespostasAritmetico respostasAritmetico = new RespostasAritmetico();
    RespostasCondicionais respostasCondicionais = new RespostasCondicionais();
    RespostasLista respostasLista = new RespostasLista();
    RespostasEstruturaDeRepeticao respostasEstruturaDeRepeticao = new RespostasEstruturaDeRepeticao();

    MediaPlayer mediaPlayer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_exercicio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ativa a Toolbar como ActionBar para suportar o menu
        // Configura a Toolbar
        Toolbar toolbar = findViewById(R.id.toolbarTelaExercicio);
        setSupportActionBar(toolbar);

        // Altera a cor do ícone de overflow (três pontinhos)
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setTint(Color.BLACK); // Troque Color.BLACK pela cor desejada
        }


        campo1 = findViewById(R.id.editTextNumber1);
        campo2 = findViewById(R.id.editTextNumber2);
        campo3 = findViewById(R.id.editTextNumber3);
        campo4 = findViewById(R.id.editTextNumber4);
        campo5 = findViewById(R.id.editTextNumber5);
        campo6 = findViewById(R.id.editTextNumber6);
        campo7 = findViewById(R.id.editTextNumber7);
        campo8 = findViewById(R.id.editTextNumber8);
        campo9 = findViewById(R.id.editTextNumber9);
        campo10 = findViewById(R.id.editTextNumber10);
        campo11 = findViewById(R.id.editTextNumber11);
        campo12 = findViewById(R.id.editTextNumber12);
        campo13 = findViewById(R.id.editTextNumber13);
        campo14 = findViewById(R.id.editTextNumber14);
        campo15 = findViewById(R.id.editTextNumber15);
        campo16 = findViewById(R.id.editTextNumber16);
        campo17 = findViewById(R.id.editTextNumber17);
        campo18 = findViewById(R.id.editTextNumber18);
        campo19 = findViewById(R.id.editTextNumber19);
        campo20 = findViewById(R.id.editTextNumber20);
        campo21 = findViewById(R.id.editTextNumber21);
        campo22 = findViewById(R.id.editTextNumber22);
        campo23 = findViewById(R.id.editTextNumber23);
        campo24 = findViewById(R.id.editTextNumber24);
        campo25 = findViewById(R.id.editTextNumber25);
        campo26 = findViewById(R.id.editTextNumber26);
        campo27 = findViewById(R.id.editTextNumber27);
        campo28 = findViewById(R.id.editTextNumber28);
        campo29 = findViewById(R.id.editTextNumber29);
        campo30 = findViewById(R.id.editTextNumber30);

        campos = Arrays.asList(
                campo1, campo2, campo3, campo4, campo5,
                campo6, campo7, campo8, campo9, campo10,
                campo11, campo12, campo13, campo14, campo15,
                campo16, campo17, campo18, campo19, campo20,
                campo21, campo22, campo23, campo24, campo25,
                campo26, campo27, campo28, campo29, campo30
        );



        //RECUPERANDO INTENT
        numeroExercicio = getIntent().getStringExtra("numeroExercicio");
        tipoExercicio = getIntent().getStringExtra("tipoExercicio");
        textTituloMenu = findViewById(R.id.id_numero_exercicio);

       /* Toast.makeText(Exercicio.this, tipoExercicio, Toast.LENGTH_SHORT).show();
        Toast.makeText(Exercicio.this, numeroExercicio, Toast.LENGTH_SHORT).show();*/

        imagemExercicio = findViewById(R.id.imageView_Exercicio);
        legendaLinha1 = findViewById(R.id.linha1);
        legendaLinha2 = findViewById(R.id.linha2);
        legendaLinha3 = findViewById(R.id.linha3);
        legendaLinha4 = findViewById(R.id.linha4);
        legendaLinha5 = findViewById(R.id.linha5);
        legendaLinha6 = findViewById(R.id.linha6);
        legendaLinha7 = findViewById(R.id.linha7);
        legendaLinha8 = findViewById(R.id.linha8);
        legendaLinha9 = findViewById(R.id.linha9);
        legendaLinha10 = findViewById(R.id.linha10);


        legendaVariavel1 = findViewById(R.id.lengendaVariavel1);
        legendaVariavel2 = findViewById(R.id.lengendaVariavel2);
        legendaVariavel3 = findViewById(R.id.lengendaVariavel3);

        buttonRetornarMenuExercicio = findViewById(R.id.buttonMenuExercicios);

        buttonRetornarMenuExercicio.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });


        // Adicionando um listener para cada campo usando um for tradicional
        for (int i = 0; i < campos.size(); i++) {
            int index = i; // Variável final para usar dentro do listener

            campos.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // Pode ser deixado vazio se não precisar fazer nada antes da mudança do texto
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    // Pode ser deixado vazio se não precisar fazer nada após a mudança do texto
                    if (tentandoNovamente) {
//                        VerificaResposta(true);
                    }
                }
            });
        }


        buttonTentarDenovo = findViewById(R.id.buttonTentarNovamente);

        buttonTentarDenovo.setOnClickListener(v -> {


                    buttonVerificarRestposta.setClickable(true);
                    buttonVerificarRestposta.setVisibility(View.VISIBLE);

                    buttonRetornarMenuExercicio.setVisibility(View.INVISIBLE);
                    buttonRetornarMenuExercicio.setClickable(false);

                    buttonTentarDenovo.setVisibility(View.INVISIBLE);
                    buttonTentarDenovo.setClickable(false);

            if(acertouTudo){
                //LIMPA TODOS OS CAMPOS
                switch (tipoExercicio) {
                    case "aritmetico":
                        if (numeroExercicio.equals("1")) {
                            limparCampos(respostasAritmetico.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            limparCampos(respostasAritmetico.getExercicio2());
                        } else {
                            limparCampos(respostasAritmetico.getExercicio3());
                        }
                        break;
                    case "condicional":
                        if (numeroExercicio.equals("1")) {
                            limparCampos(respostasCondicionais.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            limparCampos(respostasCondicionais.getExercicio2());
                        } else {
                            limparCampos(respostasCondicionais.getExercicio3());
                        }
                        break;
                    case "repeticao":
                        if (numeroExercicio.equals("1")) {
                            limparCampos(respostasEstruturaDeRepeticao.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            limparCampos(respostasEstruturaDeRepeticao.getExercicio2());
                        } else {
                            limparCampos(respostasEstruturaDeRepeticao.getExercicio3());
                        }
                        break;
                    case "listas":
                        if (numeroExercicio.equals("1")) {
                            limparCampos(respostasLista.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            limparCampos(respostasLista.getExercicio2());
                        } else {
                            limparCampos(respostasLista.getExercicio3());
                        }
                        break;
                }
            } else{
                //LIBERA OS CAMPOS PARA EDIÇÃO AO INVÉS DE LIMPÁ-LOS
                switch (tipoExercicio) {
                    case "aritmetico":
                        if (numeroExercicio.equals("1")) {
                            liberarCamposSemApagar(respostasAritmetico.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            liberarCamposSemApagar(respostasAritmetico.getExercicio2());
                        } else {
                            liberarCamposSemApagar(respostasAritmetico.getExercicio3());
                        }
                        break;
                    case "condicional":
                        if (numeroExercicio.equals("1")) {
                            liberarCamposSemApagar(respostasCondicionais.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            liberarCamposSemApagar(respostasCondicionais.getExercicio2());
                        } else {
                            liberarCamposSemApagar(respostasCondicionais.getExercicio3());
                        }
                        break;
                    case "repeticao":
                        if (numeroExercicio.equals("1")) {
                            liberarCamposSemApagar(respostasEstruturaDeRepeticao.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            liberarCamposSemApagar(respostasEstruturaDeRepeticao.getExercicio2());
                        } else {
                            liberarCamposSemApagar(respostasEstruturaDeRepeticao.getExercicio3());
                        }
                        break;
                    case "listas":
                        if (numeroExercicio.equals("1")) {
                            liberarCamposSemApagar(respostasLista.getExercicio1());
                        } else if (numeroExercicio.equals("2")) {
                            liberarCamposSemApagar(respostasLista.getExercicio2());
                        } else {
                            liberarCamposSemApagar(respostasLista.getExercicio3());
                        }
                        break;
                }
            }


        });

        DefineNumeroExercicio();

        buttonVerificarRestposta = findViewById(R.id.button31);

        buttonVerificarRestposta.setOnClickListener(v -> {
            VerificaResposta(false);
            if (isAcertouTudo()) {
                //Toast.makeText(Exercicio.this, "Resposta correta!", Toast.LENGTH_SHORT).show();
                tentandoNovamente = false;
                buttonTentarDenovo.setText("REFAZER");
                buttonTentarDenovo.requestLayout();


                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // Inflar o layout personalizado
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogView = inflater.inflate(R.layout.dialog_text_image, null);


                builder.setView(dialogView);

                AlertDialog dialog = builder.create();
                dialog.show();

                // Fechar automaticamente após 2 segundos (2000ms)
                new Handler().postDelayed(dialog::dismiss, 3000);
                mediaPlayer = MediaPlayer.create(this, R.raw.success);
                mediaPlayer.start();

                //DESATIVANDO O BOTÃO VERIFICAR RESPOSTA, POIS NÃO FAZ SENTIDO MANTÊ-LO QUANDO O USUÁRIO ACERTAR
                buttonVerificarRestposta.setVisibility(View.INVISIBLE);

                buttonRetornarMenuExercicio.setVisibility(View.VISIBLE);
                buttonRetornarMenuExercicio.setClickable(true);
                buttonTentarDenovo.setVisibility(View.VISIBLE);
                buttonTentarDenovo.setClickable(true);


            } else {
                //Toast.makeText(Exercicio.this, "Resposta incorreta, tente novamente!", Toast.LENGTH_SHORT).show();
                tentandoNovamente = true;
                buttonTentarDenovo.setText("TENTAR NOVAMENTE");

                buttonVerificarRestposta.setClickable(false);
                buttonVerificarRestposta.setVisibility(View.INVISIBLE);

                buttonRetornarMenuExercicio.setVisibility(View.VISIBLE);
                buttonRetornarMenuExercicio.setClickable(true);
                buttonTentarDenovo.setVisibility(View.VISIBLE);
                buttonTentarDenovo.setClickable(true);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // Inflar o layout personalizado
                LayoutInflater inflater = LayoutInflater.from(this);
                View dialogView = inflater.inflate(R.layout.dialog_text_image_sad, null);


                builder.setView(dialogView);

                AlertDialog dialog = builder.create();
                dialog.show();

                // Fechar automaticamente após 2 segundos (2000ms)
                new Handler().postDelayed(dialog::dismiss, 3000);

            }
        });


        //OCULTANDO AS CAIXAS DE TEXTO DE ACORDO COM CADA RESPOSTA
        if (tipoExercicio.equals("aritmetico")) {
            if (numeroExercicio.equals("1")) {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio1);
                bloqueaCampos(respostasAritmetico.getExercicio1());
                limparCampos(respostasAritmetico.getExercicio1());
                //Integer.parseInt(numeroExercicio);

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo16, campo17, campo18, campo19, campo20, campo21, campo22, campo23,
                        campo24, campo25, campo26, campo27, campo28, campo29, campo30);

            } else if (numeroExercicio.equals("2")) {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio2);
                bloqueaCampos(respostasAritmetico.getExercicio2());
                limparCampos(respostasAritmetico.getExercicio2());

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo16, campo17, campo18, campo19, campo20, campo21, campo22, campo23,
                        campo24, campo25, campo26, campo27, campo28, campo29, campo30);

            } else {
                imagemExercicio.setImageResource(R.drawable.aritmetico_exercicio3);
                bloqueaCampos(respostasAritmetico.getExercicio3());
                limparCampos(respostasAritmetico.getExercicio3());

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                         campo16, campo17, campo18, campo19, campo20, campo21, campo22, campo23,
                        campo24, campo25, campo26, campo27, campo28, campo29, campo30);

            }
        } else if (tipoExercicio.equals("condicional")) {
            if (numeroExercicio.equals("1")) {
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha3, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo7, campo8, campo9 ,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.condicional_exercicio1);
                bloqueaCampos(respostasCondicionais.getExercicio1());
                limparCampos(respostasCondicionais.getExercicio1());
            } else if (numeroExercicio.equals("2")){
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo16, campo17, campo18,
                        campo19, campo20, campo21,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.condicional_exercicio2);
                bloqueaCampos(respostasCondicionais.getExercicio2());
                limparCampos(respostasCondicionais.getExercicio2());
            } else {
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE,  legendaLinha5 , legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo13, campo14, campo15,
                        campo16, campo17, campo18,
                        campo19, campo20, campo21,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.condicional_exercicio3);
                bloqueaCampos(respostasCondicionais.getExercicio3());
                limparCampos(respostasCondicionais.getExercicio3());
            }

        } else if (tipoExercicio.equals("repeticao")) {
            if (numeroExercicio.equals("1")) {
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.estrutura_de_repeticao_exercicio1);
                bloqueaCampos(respostasEstruturaDeRepeticao.getExercicio1());
                limparCampos(respostasEstruturaDeRepeticao.getExercicio1());

            } else if (numeroExercicio.equals("2")){
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.estrutura_de_repeticao_exercicio2);
                bloqueaCampos(respostasEstruturaDeRepeticao.getExercicio2());
                limparCampos(respostasEstruturaDeRepeticao.getExercicio2());

                legendaLinha2.setText("4");
                legendaLinha3.setText("5");
                legendaLinha4.setText("6");
                legendaLinha5.setText("4");
                legendaLinha6.setText("5");
                legendaLinha7.setText("6");

            } else {
                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.INVISIBLE, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.INVISIBLE,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

                imagemExercicio.setImageResource(R.drawable.estrutura_de_repeticao_exercicio3);
                bloqueaCampos(respostasEstruturaDeRepeticao.getExercicio3());
                limparCampos(respostasEstruturaDeRepeticao.getExercicio3());

                legendaLinha2.setText("3");
                legendaLinha3.setText("5");
                legendaLinha4.setText("6");
                legendaLinha5.setText("3");
                legendaLinha6.setText("5");
                legendaLinha7.setText("6");

            }

        } else {
            if (numeroExercicio.equals("1")){
                imagemExercicio.setImageResource(R.drawable.lista_exercicio1);
                bloqueaCampos(respostasLista.getExercicio1());
                limparCampos(respostasLista.getExercicio1());

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.GONE, legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.GONE,
                        campo19, campo20, campo21, campo22, campo23, campo24,
                        campo25, campo26, campo27, campo28, campo29, campo30);

                legendaLinha1.setText("2");
                legendaLinha2.setText("3");
                legendaLinha3.setText("4");
                legendaLinha4.setText("3");
                legendaLinha5.setText("4");
                legendaLinha6.setText("5");
            }else if (numeroExercicio.equals("2")){
                imagemExercicio.setImageResource(R.drawable.lista_exercicio2);
                bloqueaCampos(respostasLista.getExercicio2());
                limparCampos(respostasLista.getExercicio2());

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.GONE, legendaLinha5 , legendaLinha6 , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.GONE,
                        campo13, campo14, campo15,
                        campo16, campo17, campo18,
                        campo19, campo20, campo21,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);

            } else {
                imagemExercicio.setImageResource(R.drawable.lista_exercicio3);
                bloqueaCampos(respostasLista.getExercicio3());
                limparCampos(respostasLista.getExercicio3());

                //DEIXANDO OCULTO OS CAMPOS QUE NÃO SERÃO USADOS
                setViewsVisibility(View.GONE , legendaLinha7, legendaLinha8, legendaLinha9, legendaLinha10);
                setViewsVisibility(View.GONE,
                        campo19, campo20, campo21,
                        campo22, campo23, campo24,
                        campo25, campo26, campo27,
                        campo28, campo29, campo30);
            }
        }


    }

    private void setViewsVisibility(int visibility, View... views) {
        Stream.of(views).forEach(view -> view.setVisibility(visibility));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity2, menu);
        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.getItem(i);
            SpannableString spanString = new SpannableString(item.getTitle().toString());
            spanString.setSpan(new ForegroundColorSpan(Color.BLACK), 0, spanString.length(), 0); // Cor do texto
            item.setTitle(spanString);
        }
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        if (id == R.id.action_menu_principal) {
            intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_menu_exercicios){
            intent = new Intent(this, MenuExercicio.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_ajuda) {
            intent = new Intent(this, AjudaActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sobre) {
            intent = new Intent(this, SobreActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_sair){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Fechar Aplicativo");
            builder.setMessage("Deseja realmente sair do aplicativo?");
            builder.setPositiveButton("Sim", (dialog, which) -> {
                ((Activity) this).finishAffinity(); // Fecha o app
            });
            builder.setNegativeButton("Não", (dialog, which) -> dialog.dismiss());

            // Criar o diálogo
            AlertDialog alertDialog = builder.create();

            // Mostrar o diálogo e mudar a cor de fundo
            alertDialog.setOnShowListener(dialog -> {
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(
                        ContextCompat.getColor(this, R.color.background_button_color)
                ));
            });

            alertDialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Indica que o campo deve ficar bloqueado, pois a variável não existe
    public void bloqueaCampos(List<String> resposta) {
        for (int i = 0; i < resposta.size(); i++) {
            if (resposta.get(i).equals("*")) {
                campos.get(i).setFocusable(false);
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado));
                //campos.get(i+1).setVisibility(View.GONE);
            }

        }
    }

    public void DefineNumeroExercicio() {
        if (numeroExercicio.equals("1")) {
            textTituloMenu.setText("EXERCÍCIO 1");
        } else if (numeroExercicio.equals("2")) {
            textTituloMenu.setText("EXERCÍCIO 2");
        } else if (numeroExercicio.equals("3")) {
            textTituloMenu.setText("EXERCÍCIO 3");
        } else if (numeroExercicio.equals("4")) {
            textTituloMenu.setText("EXERCÍCIO 4");
        } else if (numeroExercicio.equals("5")) {
            textTituloMenu.setText("EXERCÍCIO 5");
        } else {
            textTituloMenu.setText("EXERCÍCIO 6");
        }
    }

    public void limparCampos(List<String> resposta) {
        for (int i = 0; i < campos.size(); i++) {
            //Limpar apenas os campos que não estejam bloqueados
            //Alterar se for adiconar mais um caracter
            if (!resposta.get(i).equals("*")) {
                campos.get(i).setFocusable(true);
                campos.get(i).setFocusableInTouchMode(true);
                campos.get(i).setText("");
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_branco));
                campos.get(i).setTextColor(Color.BLACK);
            }
        }
    }

    public void liberarCamposSemApagar(List<String> resposta) {
        for (int i = 0; i < campos.size(); i++) {
            EditText campo = campos.get(i);
            //Liberar apenas os campos que não estejam bloqueados e não foram acertados
            if (!resposta.get(i).equals("*") && !campo.getText().toString().trim().equals(resposta.get(i))) {
                campo.setFocusable(true);
                campo.setFocusableInTouchMode(true);
                campo.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_branco)); // Restaura a cor de fundo original
                campo.setTextColor(Color.BLACK); // Restaura a cor do texto original
            }
        }
    }
    public boolean isAcertouTudo() {
        return acertouTudo;
    }

    public void getResposta() {
        // Limpa a lista antes de adicionar novas respostas
        respostaUsuario.clear();

        for (EditText campo : campos) {
            respostaUsuario.add(campo.getText().toString());
        }
    }


    public void VerificarResposta(List<String> resposta) {
        acertouTudo = true;
        for (int i = 0; i < resposta.size(); i++) {
            String respostaCorreta = resposta.get(i).toString();
            String respostaDoUsuario = respostaUsuario.get(i);

            //ACERTOU
            if (respostaCorreta.equals(respostaDoUsuario) && !resposta.get(i).equals("*")) {
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_verde_claro));
                campos.get(i).setTextColor(Color.parseColor("#006400"));
                if(!tentandoNovamente){
                    campos.get(i).setFocusable(false);
                }
            } else if (!respostaCorreta.equals(respostaDoUsuario) && !resposta.get(i).equals("*")) { //ERROU
                acertouTudo = false;
                campos.get(i).setBackground(ContextCompat.getDrawable(this, R.drawable.shape_arredondado_vermelho));
                campos.get(i).setTextColor(Color.RED);

                if(!tentandoNovamente){
                    campos.get(i).setFocusable(false);
                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        VibrationEffect effect = VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE);
                        vibrator.vibrate(effect);
                    } else {
                        vibrator.vibrate(500);
                    }
                }

            }
        }
    }

    public void VerificaResposta(boolean listiner) {
        getResposta();
        if(listiner){
            tentandoNovamente = true;
        }else{
            tentandoNovamente = false;
        }
        campos = Arrays.asList(
                campo1, campo2, campo3, campo4, campo5,
                campo6, campo7, campo8, campo9, campo10,
                campo11, campo12, campo13, campo14, campo15,
                campo16, campo17, campo18, campo19, campo20,
                campo21, campo22, campo23, campo24, campo25,
                campo26, campo27, campo28, campo29, campo30
        );


        switch (tipoExercicio) {
            case "aritmetico":
                if (numeroExercicio.equals("1")) {
                    VerificarResposta(respostasAritmetico.getExercicio1());
                } else if (numeroExercicio.equals("2")) {
                    VerificarResposta(respostasAritmetico.getExercicio2());
                } else {
                    VerificarResposta(respostasAritmetico.getExercicio3());
                }
                break;
            case "condicional":
                if (numeroExercicio.equals("1")) {
                    VerificarResposta(respostasCondicionais.getExercicio1());
                } else if (numeroExercicio.equals("2")) {
                    VerificarResposta(respostasCondicionais.getExercicio2());
                } else {
                    VerificarResposta(respostasCondicionais.getExercicio3());
                }
                break;
            case "repeticao":
                if (numeroExercicio.equals("1")) {
                    VerificarResposta(respostasEstruturaDeRepeticao.getExercicio1());
                } else if (numeroExercicio.equals("2")) {
                    VerificarResposta(respostasEstruturaDeRepeticao.getExercicio2());
                } else {
                    VerificarResposta(respostasEstruturaDeRepeticao.getExercicio3());
                }
                break;
            case "listas":
                if (numeroExercicio.equals("1")) {
                    VerificarResposta(respostasLista.getExercicio1());
                } else if (numeroExercicio.equals("2")) {
                    VerificarResposta(respostasLista.getExercicio2());
                } else {
                    VerificarResposta(respostasLista.getExercicio3());
                }

                break;
        }


    }



}