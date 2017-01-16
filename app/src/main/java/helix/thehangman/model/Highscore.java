package helix.thehangman.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Silas on 15-01-2017.
 */

public class Highscore {


    private SharedPreferences preferences;
    public String[] categories, playerName;;

    public Integer[] points, numberOnList;

    public Highscore(Context context)
    {

        preferences = context.getSharedPreferences("Highscore", Context.MODE_PRIVATE);
        categories = new String[10];
        points = new Integer[10];
        playerName = new String[10];
        numberOnList = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 0; i < 10; i++)
        {
            categories[i] = preferences.getString("Category"+i, "-");
            playerName[i] = preferences.getString("playerName"+i, "-");
            points[i] = preferences.getInt("points"+i, 0);
        }

    }


    public boolean addHighScore(String category, String playerName, int points)
    {

        int position;

        for (position = 0; position < 10 && this.points[position] > points; position++);

        if (position==10) return false;

        for (int x = 9; x > position; x--)
        {
            this.playerName[x] = this.playerName[x-1];
            categories[x]= categories[x-1];
            this.points[x]=this.points[x-1];
        }

        this.playerName[position] = new String(playerName);
        this.categories[position] = new String(category);
        this.points[position] = points;

        SharedPreferences.Editor editor = preferences.edit();
        for (int x = 0; x < 10; x++)
        {
            editor.putString("playerName"+x, this.playerName[x]);
            editor.putString("Category"+x, this.categories[x]);
            editor.putInt("points"+x, this.points[x]);
        }
        editor.commit();
        return true;

    }

    // Metode til at resette array lister

    public  void resetHighscore () {

    }


}
