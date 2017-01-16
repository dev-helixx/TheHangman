package helix.thehangman.frontend.activities;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import helix.thehangman.R;
import helix.thehangman.frontend.fragments.CategoryFragment;
import helix.thehangman.model.GlobalData;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playBtn;
    Button optBtn;
    Button scoreBtn;
    LinearLayout main_layout;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setupUI(findViewById(R.id.activity_main));

        Typeface customFont = Typeface.createFromAsset(getAssets(), "airstrike.ttf");
        TextView logo = (TextView) findViewById(R.id.textView);
        logo.setTypeface(customFont);

        playBtn = (Button) findViewById(R.id.playBtn);
        optBtn = (Button) findViewById(R.id.optBtn);
        scoreBtn = (Button) findViewById(R.id.scoreBtn);
        main_layout = (LinearLayout) findViewById(R.id.main_layout);


        playBtn.setOnClickListener(this);
        optBtn.setOnClickListener(this);
        scoreBtn.setOnClickListener(this);
        main_layout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == playBtn) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.push_up_in, R.anim.push_up_in);
            ft.replace(R.id.fragment_container, new CategoryFragment());
            ft.addToBackStack(null);
            ft.commit();

        }else if (v == optBtn) {

            Intent optIntent = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(optIntent);

        }else if (v == scoreBtn) {


            Intent scoreIntent = new Intent(MainActivity.this, ScoreboardActivity.class);
            startActivity(scoreIntent);

        }
//        else if(v == main_layout) {
//
//            InputMethodManager inputMethodManager =
//                    (InputMethodManager) this.getSystemService(
//                            Activity.INPUT_METHOD_SERVICE);
//            if (inputMethodManager.isActive(findViewById(R.id.activity_main))) {
//                inputMethodManager.hideSoftInputFromWindow(
//                        this.getCurrentFocus().getWindowToken(), 0);
//            }else {
//                System.out.println("keyboard ikke åbent");
//            }

//            if (getSupportFragmentManager().findFragmentById(R.id.fragment_container).isVisible()){
//                System.out.println("is visible");
//                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//                ft.setCustomAnimations(R.anim.push_down_in, R.anim.push_down_in);
//                ft.remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
//                ft.commit();
//            }else {
//                System.out.println("fandtr ikke noget fragment");
//            }
//        }
}

    @Override
    protected void onStop() {

//        getSupportFragmentManager().popBackStack();

        super.onStop();
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container).isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.push_down_in, R.anim.push_down_in);
            ft.remove(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
            ft.commit();
        }else {
            finish(); // Closes app
        }
    }

//    public static void hideSoftKeyboard(Activity activity) {
//
//
//        InputMethodManager inputMethodManager =
//                (InputMethodManager) activity.getSystemService(
//                        Activity.INPUT_METHOD_SERVICE);
//        if (inputMethodManager.isActive()) {
//            inputMethodManager.hideSoftInputFromWindow(
//                    activity.getCurrentFocus().getWindowToken(), 0);
//        }else {
//            System.out.println("keyboard ikke åbent");
//        }
//    }
//
//    public void setupUI(View view) {
//
//        if (!(view instanceof EditText)) {
//            view.setOnTouchListener(new View.OnTouchListener() {
//                public boolean onTouch(View v, MotionEvent event) {
//                    hideSoftKeyboard(MainActivity.this);
//                    return false;
//                }
//            });
//        }
//
//        if (view instanceof ViewGroup) {
//            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
//                View innerView = ((ViewGroup) view).getChildAt(i);
//                setupUI(innerView);
//            }
//        }
//    }


}
