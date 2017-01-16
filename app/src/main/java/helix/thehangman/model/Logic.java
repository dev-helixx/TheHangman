package helix.thehangman.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Silas on 14-10-2016.
 */

public class Logic {

    private String wordToGuess;
    private ArrayList<String> usedLetters = new ArrayList<String>();
    private String visibleWord;
    private int noOfErrors;
    private int noOfTries;
    private boolean gameIsWon;
    public boolean gameIsLost;

    public Logic() {

        setCategory();
        nulstil();

    }

    public void nulstil() {
        noOfErrors = 0;
        noOfTries = 6;
        gameIsWon = false;
        gameIsLost = false;
        wordToGuess = GlobalData.possibleWords.get(new Random().nextInt(GlobalData.possibleWords.size()));
        updateVisibleWord();
    }

    private void updateVisibleWord() {

        visibleWord = "";
        gameIsWon = true;
        for (int n = 0; n < wordToGuess.length(); n++) {
            String letter = wordToGuess.substring(n, n + 1);
            if (usedLetters.contains(letter)) {
                visibleWord = visibleWord + letter;
            } else {
                visibleWord = visibleWord + " _ ";
                gameIsWon = false;
            }
        }
    }

    public void guessOnLetter(String letter) {
        if (usedLetters.contains(letter)) return;
        if (gameIsWon || gameIsLost) return;

        usedLetters.add(letter);

        if (wordToGuess.contains(letter)) {
        } else {
            noOfErrors++;
            noOfTries--;
            if (noOfTries <= 0) {
                gameIsLost = true;
            }
        }

        updateVisibleWord();
    }



    public void logStatus() {


        System.out.println("------------------------------- ");
        System.out.println("- Hidden Word = " + wordToGuess);
        System.out.println("- Wrong letters = " + noOfErrors);
        System.out.println("- Used letters = " + usedLetters);
        if (gameIsLost) System.out.println("- The Game Is Lost!");
        if (gameIsWon) System.out.println("- The Game is Won!");
        System.out.println("--------------------------------- ");

    }



    public static String fetchURL(String url) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line + "\n");
            line = br.readLine();
        }
        return sb.toString();

    }

    public void setCategory() {


        if(GlobalData.category.equals("Dyrearter")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("hund");GlobalData.possibleWords.add("kat");
            GlobalData.possibleWords.add("marsvin");GlobalData.possibleWords.add("giraf");
            GlobalData.possibleWords.add("får");GlobalData.possibleWords.add("hest");
            GlobalData.possibleWords.add("flodhest");GlobalData.possibleWords.add("gris");
            GlobalData.possibleWords.add("høne");GlobalData.possibleWords.add("fisk");
        }
        else if(GlobalData.category.equals("Bilmærker")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("ford");GlobalData.possibleWords.add("citroen");
            GlobalData.possibleWords.add("mazda");GlobalData.possibleWords.add("ferrari");
            GlobalData.possibleWords.add("lamborghini");GlobalData.possibleWords.add("nissan");
            GlobalData.possibleWords.add("peogeot");GlobalData.possibleWords.add("audi");
            GlobalData.possibleWords.add("bmw");GlobalData.possibleWords.add("landrover");
        }else if(GlobalData.category.equals("Fødevarer")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("smør");GlobalData.possibleWords.add("kylling");
            GlobalData.possibleWords.add("leverpostej");GlobalData.possibleWords.add("agurk");
            GlobalData.possibleWords.add("tomat");GlobalData.possibleWords.add("iceberg");
            GlobalData.possibleWords.add("spegepølse");GlobalData.possibleWords.add("ris");
            GlobalData.possibleWords.add("rugbrød");GlobalData.possibleWords.add("remoulade");
        } else if(GlobalData.category.equals("Drengenavne")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("mathias");GlobalData.possibleWords.add("henrik");
            GlobalData.possibleWords.add("dean");GlobalData.possibleWords.add("rasmus");
            GlobalData.possibleWords.add("mads");GlobalData.possibleWords.add("kasper");
            GlobalData.possibleWords.add("william");GlobalData.possibleWords.add("alexander");
            GlobalData.possibleWords.add("jonathan");GlobalData.possibleWords.add("emil");
        }else if(GlobalData.category.equals("Pigenavne")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("rikke");GlobalData.possibleWords.add("josephine");
            GlobalData.possibleWords.add("hanne");GlobalData.possibleWords.add("natasha");
            GlobalData.possibleWords.add("olivia");GlobalData.possibleWords.add("lotte");
            GlobalData.possibleWords.add("amalie");GlobalData.possibleWords.add("amanda");
            GlobalData.possibleWords.add("alberte");GlobalData.possibleWords.add("clara");
        }else if(GlobalData.category.equals("Byer")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("københavn");GlobalData.possibleWords.add("slagelse");
            GlobalData.possibleWords.add("holbæk");GlobalData.possibleWords.add("horsens");
            GlobalData.possibleWords.add("odense");GlobalData.possibleWords.add("korsør");
            GlobalData.possibleWords.add("næstved");GlobalData.possibleWords.add("køge");
            GlobalData.possibleWords.add("asnæs");GlobalData.possibleWords.add("kalundborg");
        }else if(GlobalData.category.equals("Lande")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("danmark");GlobalData.possibleWords.add("tyskland");
            GlobalData.possibleWords.add("albanien");GlobalData.possibleWords.add("slovakiet");
            GlobalData.possibleWords.add("sverige");GlobalData.possibleWords.add("norge");
            GlobalData.possibleWords.add("irland");GlobalData.possibleWords.add("holland");
            GlobalData.possibleWords.add("england");GlobalData.possibleWords.add("rusland");
        }else if(GlobalData.category.equals("Sportsgrene")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("badminton");GlobalData.possibleWords.add("fodbold");
            GlobalData.possibleWords.add("tennis");GlobalData.possibleWords.add("rugby");
            GlobalData.possibleWords.add("svømning");GlobalData.possibleWords.add("håndbold");
            GlobalData.possibleWords.add("ridning");GlobalData.possibleWords.add("højespring");
            GlobalData.possibleWords.add("længdespring");GlobalData.possibleWords.add("ishockey");
        }else if(GlobalData.category.equals("Computermærker")) {
            GlobalData.possibleWords.clear();
            GlobalData.possibleWords.add("asus");GlobalData.possibleWords.add("msi");
            GlobalData.possibleWords.add("acer");GlobalData.possibleWords.add("dell");
            GlobalData.possibleWords.add("hp");GlobalData.possibleWords.add("apple");
            GlobalData.possibleWords.add("samsung");GlobalData.possibleWords.add("razer");
            GlobalData.possibleWords.add("lenovo");GlobalData.possibleWords.add("medion");
        }

    }

    public String getVisibleWord() { return visibleWord;}
    public String getOrdet() {
        return wordToGuess;
    }
    public int getNoOfTries() {return noOfTries; }
    public int getNoOfErrors() { return noOfErrors;}
    public boolean erSpilletVundet() {
        return gameIsWon;
    }
    public boolean erSpilletTabt() {return gameIsLost;}
    public boolean erSpilletSlut() {
        return gameIsLost || gameIsWon;
    }


}
