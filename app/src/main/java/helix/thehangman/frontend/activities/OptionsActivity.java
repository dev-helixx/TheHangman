package helix.thehangman.frontend.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import helix.thehangman.R;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener{



    private Button reset_highscore, rulesBtn;
    private TextView gameRules;
    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        reset_highscore = (Button) findViewById(R.id.reset_highscore);
        reset_highscore.setOnClickListener(this);
        gameRules = (TextView) findViewById(R.id.gameRules);
        rulesBtn = (Button) findViewById(R.id.gameRulesBtn);

        backButton = (ImageButton) findViewById(R.id.back_arrow);
        backButton.setOnClickListener(this);
        rulesBtn.setOnClickListener(this);


        gameRules.setText("Reglerne for spillet er simple. Når der trykkes på 'Spil' knappen, " +
                "vil en popup menu blive vist med en række kategorier der kan vælges. Når man " +
                "har valgt kategori, vil man blive mødt med en dialogboks der beder om ens navn, " +
                "som benyttes til highscoren. Når der trykkes OK vil spillet herefter starte.\n\n" +
                "Når et spil startes, vil en timer tælle ned fra 2 minutter.\n" +
                "Man starter altid med 2000 point. Efterhånden som tiden går, vil ens point mindskes.\n\n" +
                "For hvert sekund der går, mister man 10 point.\n\n" +
                "For hvert forkert bogstav der gættes på, mister man 100 point.");
        gameRules.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onClick(View view) {
        if(view == reset_highscore) {

            final AlertDialog.Builder myAlert = new AlertDialog.Builder(OptionsActivity.this);
            myAlert.setTitle("                  Advarsel!");
            myAlert.setMessage("Du er ved at slette alle gemte highscores. Er du sikker på, at du vil fortsætte?");
            myAlert.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences preferences = getSharedPreferences("Highscore", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.clear();
                    editor.commit();

                    Toast.makeText(OptionsActivity.this, "Highscore cleared", Toast.LENGTH_SHORT).show();

                }
            }).setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            myAlert.show();



        }else if(view == backButton) {
            this.onBackPressed();

        }else if( view == rulesBtn){
            System.out.println("test");
            if(gameRules.getVisibility() == View.INVISIBLE) {
                gameRules.setVisibility(View.VISIBLE);
            }else {
                gameRules.setVisibility(View.INVISIBLE);
            }

        }

    }
}

