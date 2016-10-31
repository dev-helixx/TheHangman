package helix.thehangman;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playBtn;
    Button optBtn;
    Button scoreBtn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Typeface customFont = Typeface.createFromAsset(getAssets(), "airstrike.ttf");
        TextView logo = (TextView) findViewById(R.id.textView);
        logo.setTypeface(customFont);

        playBtn = (Button) findViewById(R.id.playBtn);
        optBtn = (Button) findViewById(R.id.optBtn);
        scoreBtn = (Button) findViewById(R.id.scoreBtn);

        playBtn.setOnClickListener(this);
        optBtn.setOnClickListener(this);
        scoreBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == playBtn) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.push_up_in, R.anim.push_up_in);
            ft.add(R.id.fragment_container, new CategoryFragment());
            ft.addToBackStack(null);
            ft.commit();

        }else if (v == optBtn) {


            Intent optIntent = new Intent(MainActivity.this, OptionsActivity.class);
            startActivity(optIntent);

        }else if (v == scoreBtn) {

            final AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
            myAlert.setTitle("                       Info!");
            myAlert.setMessage("Denne side er stadig under udvikling, og er derfor ikke komplet.");
            myAlert.setPositiveButton("Fortsæt", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent scoreIntent = new Intent(MainActivity.this, ScoreboardActivity.class);
                    startActivity(scoreIntent);
                }
            }).setNegativeButton("Afslut", new DialogInterface.OnClickListener() {
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

       getSupportFragmentManager().popBackStack();

        super.onStop();
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().findFragmentById(R.id.fragment_container).isVisible()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.push_down_in, R.anim.push_down_in);
            ft.hide(getSupportFragmentManager().findFragmentById(R.id.fragment_container));
            ft.commit();
        }else {
            finish(); // Closes app
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //No call for super(). Bug on API Level > 11.
    }

}
