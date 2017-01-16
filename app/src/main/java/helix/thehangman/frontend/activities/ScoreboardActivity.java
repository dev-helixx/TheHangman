package helix.thehangman.frontend.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import helix.thehangman.R;
import helix.thehangman.model.Highscore;

public class ScoreboardActivity extends AppCompatActivity implements View.OnClickListener {


    TextView category_then, time_then, no_of_errors_then;
    ListView lv_category, lv_time, lv_errors, lv_number;
    ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        lv_category = (ListView) findViewById(R.id.lv_category);
        lv_errors = (ListView) findViewById(R.id.lv_errors);
        lv_time = (ListView) findViewById(R.id.lv_name);
        lv_number = (ListView) findViewById(R.id.lv_number);

        backButton = (ImageButton) findViewById(R.id.back_arrow);
        backButton.setOnClickListener(this);

        category_then = (TextView) findViewById(R.id.category_then);
        time_then = (TextView) findViewById(R.id.time_then);
        no_of_errors_then = (TextView) findViewById(R.id.no_of_errors_then);


        displayHighscore();

    }



    public void displayHighscore() {

        Highscore highscore = new Highscore(this);

        ArrayAdapter<String> categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, highscore.categories);
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, highscore.playerName);
        ArrayAdapter<Integer> errorsAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, highscore.points);
        ArrayAdapter<Integer> numberAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, highscore.numberOnList);

        lv_category.setAdapter(categoryAdapter);
        lv_time.setAdapter(timeAdapter);
        lv_errors.setAdapter(errorsAdapter);
        lv_number.setAdapter(numberAdapter);


    }

    @Override
    public void onClick(View view) {
        if (view == backButton) {
            this.onBackPressed();
        }
    }
}
