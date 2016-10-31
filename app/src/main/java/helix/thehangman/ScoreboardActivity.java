package helix.thehangman;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardActivity extends AppCompatActivity {


    TextView category_then, time_then, no_of_errors_then;
    //ArrayList<String> stringData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Initializing string array list;
        //stringData = new ArrayList<String>();

        category_then = (TextView) findViewById(R.id.category_then);
        time_then = (TextView) findViewById(R.id.time_then);
        no_of_errors_then = (TextView) findViewById(R.id.no_of_errors_then);

        displayHighscore();
    }



    public void displayHighscore() {
        SharedPreferences sharedPrefs = getSharedPreferences("highscore", Context.MODE_PRIVATE);
        String category = sharedPrefs.getString("category", "");
        String time = sharedPrefs.getString("time", "");
        String errors = sharedPrefs.getString("noOfErrors", "");


        category_then.setText(category);
        time_then.setText(time);
        no_of_errors_then.setText(errors);


        // Dynamically add new highscores to the screen

        // stringData.add(category);


        //for(int i=0; i < stringData.size(); i++){
        //    category_then.setText(category_then.getText() + stringData.get(i)+"\n");
        //}


    }
}
