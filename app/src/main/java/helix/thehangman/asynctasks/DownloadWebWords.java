package helix.thehangman.asynctasks;

import android.os.AsyncTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import helix.thehangman.model.GlobalData;
import helix.thehangman.model.Logic;

/**
 * Created by Silas on 10-01-2017.
 */

public class DownloadWebWords extends AsyncTask<Void, Void, ArrayList<String>> {

    private Logic logic;

    @Override
    protected ArrayList<String> doInBackground(Void... params)
    {
        ArrayList<String> downloadedWordList = new ArrayList<String>();

        try
        {
            String data = logic.fetchURL("http://dr.dk");
            data = data.replaceAll("<.+?>", " ").toLowerCase().replaceAll("[^a-zæøå]", " ");
            downloadedWordList.clear();l
            downloadedWordList.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

            System.out.println("doInBackground: Mulige ord efter de er tilføjet til listen = " + downloadedWordList);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return downloadedWordList;

    }



    @Override
    protected void onPostExecute(ArrayList<String> downloadedWordList)
    {
        GlobalData.possibleWords.clear();
        GlobalData.possibleWords = downloadedWordList;
    }
}