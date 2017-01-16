package helix.thehangman.frontend.activities;


import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import helix.thehangman.R;
import helix.thehangman.model.GlobalData;
import helix.thehangman.model.Logic;
import helix.thehangman.model.Highscore;


public class SingleplayerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView info, pointsLeft, timer, wordToGuess;
    private Button A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R_button,S,T,U,V,W,X,Y,Z,Æ,Ø,Å;
    private Logic logic;
    private ImageView image, bubble;
    private String letter;
//    private Chronometer chronometer;
    private CountDownTimer cdt;
    private int points = 2000;
    private ImageButton backButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleplayer);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        chronometer = (Chronometer) findViewById(R.id.chronometer1);
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.start();
        backButton = (ImageButton) findViewById(R.id.back_arrow);
        backButton.setOnClickListener(this);

        image = (ImageView) findViewById(R.id.gallow);
        bubble = (ImageView) findViewById(R.id.bubble);
        image.setImageResource(R.drawable.gallow);
        bubble.setVisibility(View.GONE);

        wordToGuess = (TextView) findViewById(R.id.wordToGuess);
        info = (TextView) findViewById(R.id.info);
        pointsLeft = (TextView) findViewById(R.id.pointsLeft);
        timer = (TextView) findViewById(R.id.timer_label);


        logic = new Logic();
        logic.logStatus();
        initButtons();
        reverseTimer(120, timer);
        updateScreen();

        info.setText("Gæt nedenstående ord.");



    }

    @Override
    public void onBackPressed(){

        if(logic.erSpilletSlut() == true) {
            finish();
        }else {
            AlertDialog.Builder myAlert = new AlertDialog.Builder(SingleplayerActivity.this);
            myAlert.setTitle("                     Advarsel!");
            myAlert.setMessage("Er du sikker på du gerne vil afslutte spillet? Alle data vil blive tabt.")
                    .setPositiveButton("Afslut", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    }).setNegativeButton("Bliv", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            myAlert.show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        cdt.cancel();
    }

    @Override
    public void onClick(View v) {
        if(v == A)
        {
            letter = "a";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            A.setVisibility(View.INVISIBLE);
        }
        else if (v == B )
        {
            letter = "b";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            B.setVisibility(View.INVISIBLE);
        }
        else if (v == C )
        {
            letter = "c";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            C.setVisibility(View.INVISIBLE);
        }
        else if (v == D )
        {
            letter = "d";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            D.setVisibility(View.INVISIBLE);
        }
        else if (v == E )
        {
            letter = "e";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            E.setVisibility(View.INVISIBLE);
        }
        else if (v == F )
        {
            letter = "f";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            F.setVisibility(View.INVISIBLE);
        }
        else if (v == G )
        {
            letter = "g";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            G.setVisibility(View.INVISIBLE);
        }
        else if (v == H )
        {
            letter = "h";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            H.setVisibility(View.INVISIBLE);
        }
        else if (v == I )
        {
            letter = "i";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            I.setVisibility(View.INVISIBLE);
        }
        else if (v == J )
        {
            letter = "j";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            J.setVisibility(View.INVISIBLE);
        }
        else if (v == K )
        {
            letter = "k";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            K.setVisibility(View.INVISIBLE);
        }
        else if (v == L )
        {
            letter = "l";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            L.setVisibility(View.INVISIBLE);
        }
        else if (v == M )
        {
            letter = "m";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            M.setVisibility(View.INVISIBLE);
        }
        else if (v == N )
        {
            letter = "n";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            N.setVisibility(View.INVISIBLE);
        }
        else if (v == O )
        {
            letter = "o";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            O.setVisibility(View.INVISIBLE);
        }
        else if (v == P )
        {
            letter = "p";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            P.setVisibility(View.INVISIBLE);
        }
        else if (v == Q )
        {
            letter = "q";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Q.setVisibility(View.INVISIBLE);
        }
        else if (v == R_button)
        {
            letter = "r";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            R_button.setVisibility(View.INVISIBLE);
        }
        else if (v == S )
        {
            letter = "s";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            S.setVisibility(View.INVISIBLE);
        }
        else if (v == T )
        {
            letter = "t";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            T.setVisibility(View.INVISIBLE);
        }
        else if (v == U )
        {
            letter = "u";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            U.setVisibility(View.INVISIBLE);
        }
        else if (v == V )
        {
            letter = "v";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            V.setVisibility(View.INVISIBLE);
        }
        else if (v == W )
        {
            letter = "w";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            W.setVisibility(View.INVISIBLE);
        }
        else if (v == X )
        {
            letter = "x";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            X.setVisibility(View.INVISIBLE);
        }
        else if (v == Y )
        {
            letter = "y";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Y.setVisibility(View.INVISIBLE);
        }
        else if (v == Z )
        {
            letter = "z";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Z.setVisibility(View.INVISIBLE);
        }
        else if (v == Æ )
        {
            letter = "æ";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Æ.setVisibility(View.INVISIBLE);
        }
        else if (v == Ø )
        {
            letter = "ø";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Ø.setVisibility(View.INVISIBLE);
        }
        else if (v == Å )
        {
            letter = "å";
            logic.guessOnLetter(letter);
            updateScreen();
            showBubble();
            Å.setVisibility(View.INVISIBLE);
        }
        else if(v == backButton)
        {
            this.onBackPressed();
        }
    }

    private void updateScreen() {

        wordToGuess.setText(logic.getVisibleWord());

        if(logic.getNoOfTries() == 5) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_head);
        }else if(logic.getNoOfTries() == 4) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_torso);
        }else if(logic.getNoOfTries() == 3) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_leftarm);
        }else if(logic.getNoOfTries() == 2) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_rightarm);
        }else if(logic.getNoOfTries() == 1) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_leftleg);
        }else if(logic.getNoOfTries() == 0) {
            points -= 100;
            image.setImageResource(R.drawable.gallow_rightleg);
        }


        if (logic.erSpilletVundet()) {

            saveHighscore();
            logic.logStatus();

            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("                   Tillykke!");
            myAlert.setMessage("Du gættede det rigtige ord :)");
            myAlert.setPositiveButton("Spil igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    recreate();
                }
            }).setNegativeButton("Afslut", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myAlert.show();

            cdt.cancel();

        }
        if (logic.erSpilletTabt()) {

            logic.logStatus();
            AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("                   Du tabte!");
            myAlert.setMessage("Det korrekte ord var: " + logic.getOrdet() + ".\nBedre held næste gang!");
            myAlert.setPositiveButton("Spil igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    recreate();
                }
            }).setNegativeButton("Afslut", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myAlert.show();
            cdt.cancel();
        }
    }

    public void hideImageAnimated(final ImageView bubble) {

        Animation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(500); // whatever duration you want

        // add AnimationListener
        alpha.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                bubble.setVisibility(View.GONE);

            }

            @Override
            public void onAnimationRepeat(Animation arg0) { }

            @Override
            public void onAnimationStart(Animation arg0) { }

        });

        bubble.startAnimation(alpha);
    }

    public void showBubble() {

        if (!logic.getOrdet().contains(letter)) {
            Animation myFadeInAnimation = AnimationUtils.loadAnimation(SingleplayerActivity.this, R.anim.fade_in);
            bubble.startAnimation(myFadeInAnimation);
            bubble.setVisibility(View.VISIBLE);


            Handler h = new Handler();
            h.postDelayed(new Runnable() {

                @Override
                public void run() {
                    hideImageAnimated(bubble);
                }
            }, 1000);
        }
    }

//        public String getElapsedTime(){
//
//            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
//            String time = Long.toString(elapsedMillis);
//            time = time.format("%02d:%02d",
//                    TimeUnit.MILLISECONDS.toMinutes(elapsedMillis),
//                    TimeUnit.MILLISECONDS.toSeconds(elapsedMillis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(elapsedMillis))
//            );
//
//            return time;
//        }

    public void saveHighscore() {

        Highscore highscore = new Highscore(this);
        highscore.addHighScore(GlobalData.category, GlobalData.playerName, points);

    }

    public void initButtons() {
        A = (Button) findViewById(R.id.A); B = (Button) findViewById(R.id.B);
        C = (Button) findViewById(R.id.C); D = (Button) findViewById(R.id.D);
        E = (Button) findViewById(R.id.E); F = (Button) findViewById(R.id.F);
        G = (Button) findViewById(R.id.G); H = (Button) findViewById(R.id.H);
        I = (Button) findViewById(R.id.I); J = (Button) findViewById(R.id.J);
        K = (Button) findViewById(R.id.K); L = (Button) findViewById(R.id.L);
        M = (Button) findViewById(R.id.M); N = (Button) findViewById(R.id.N);
        O = (Button) findViewById(R.id.O); P = (Button) findViewById(R.id.P);
        Q = (Button) findViewById(R.id.Q); R_button = (Button) findViewById(R.id.R_letter);
        S = (Button) findViewById(R.id.S); T = (Button) findViewById(R.id.T);
        U = (Button) findViewById(R.id.U); V = (Button) findViewById(R.id.V);
        W = (Button) findViewById(R.id.W); X = (Button) findViewById(R.id.X);
        Y = (Button) findViewById(R.id.Y); Z = (Button) findViewById(R.id.Z);
        Æ = (Button) findViewById(R.id.Æ); Ø = (Button) findViewById(R.id.Ø);
        Å = (Button) findViewById(R.id.Å);

        A.setOnClickListener(this); B.setOnClickListener(this); C.setOnClickListener(this);
        D.setOnClickListener(this); E.setOnClickListener(this); F.setOnClickListener(this);
        G.setOnClickListener(this); H.setOnClickListener(this); I.setOnClickListener(this);
        A.setOnClickListener(this); A.setOnClickListener(this); A.setOnClickListener(this);
        J.setOnClickListener(this); K.setOnClickListener(this); L.setOnClickListener(this);
        M.setOnClickListener(this); N.setOnClickListener(this); O.setOnClickListener(this);
        P.setOnClickListener(this); Q.setOnClickListener(this); R_button.setOnClickListener(this);
        S.setOnClickListener(this); T.setOnClickListener(this); U.setOnClickListener(this);
        V.setOnClickListener(this); W.setOnClickListener(this); X.setOnClickListener(this);
        Y.setOnClickListener(this); Z.setOnClickListener(this); Æ.setOnClickListener(this);
        Ø.setOnClickListener(this);Å.setOnClickListener(this);
    }

    public void reverseTimer(int Seconds,final TextView tv){

        cdt = new CountDownTimer(Seconds* 1000+1000, 500) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000);
                int minutes = seconds / 60;
                seconds = seconds % 60;
                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

                points -= 5;
                pointsLeft.setText("Point tilbage: " + points);
            }

            public void onFinish() {
                // Implement Dialog
                AlertDialog.Builder myAlert = new AlertDialog.Builder(SingleplayerActivity.this);
                myAlert.setTitle("      Desværre, tiden løb fra dig!");
                myAlert.setMessage("Det korrekte ord var: \n\n" + logic.getOrdet() + ".\n\nBedre held næste gang!");
                myAlert.setPositiveButton("Spil igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recreate();
                    }
                }).setNegativeButton("Afslut", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                myAlert.show();
            }
        }.start();
    }


}
