package helix.thehangman.model;

import android.app.Application;
import android.widget.ImageButton;

import java.util.ArrayList;

/**
 * Created by Silas on 14-01-2017.
 */

public class GlobalData  extends Application {
    public static ArrayList<String> possibleWords = new ArrayList<String>();
    public static String category;
    public static String playerName;
    public static ImageButton backButton;


}
