package helix.thehangman;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Silas on 14-10-2016.
 */

public class Logic {

    private ArrayList<String> possibleWords = new ArrayList<String>();
    private String wordToGuess;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private int antalForsøg;
    private boolean spilletErVundet;
    private boolean spilletErTabt;
    public String getSynligtOrd() { return synligtOrd;}
    public String getOrdet() {
        return wordToGuess;
    }
    public int getAntalForsøg() {return antalForsøg; }
    public int getAntalForkerteBogstaver() { return antalForkerteBogstaver;}
    public boolean erSpilletVundet() {
        return spilletErVundet;
    }
    public boolean erSpilletTabt() {return spilletErTabt;}
    public boolean erSpilletSlut() {
        return spilletErTabt || spilletErVundet;
    }
    public String category = CategoryFragment.category;


    public Logic() {

        if(category.equals("Dyr")) {
            possibleWords.add("hund");possibleWords.add("kat");
            possibleWords.add("marsvin");possibleWords.add("giraf");
            possibleWords.add("får");possibleWords.add("hest");
            possibleWords.add("flodhest");possibleWords.add("gris");
            possibleWords.add("høne");possibleWords.add("fisk");
        }else if(category.equals("Bilmærker")) {
            possibleWords.add("ford");possibleWords.add("citroen");
            possibleWords.add("mazda");possibleWords.add("ferrari");
            possibleWords.add("lamborghini");possibleWords.add("nissan");
            possibleWords.add("peogeot");possibleWords.add("audi");
            possibleWords.add("bmw");possibleWords.add("landrover");
        }else if(category.equals("Fødevarer")) {
            possibleWords.add("smør");possibleWords.add("kylling");
            possibleWords.add("leverpostej");possibleWords.add("agurk");
            possibleWords.add("tomat");possibleWords.add("iceberg");
            possibleWords.add("spegepølse");possibleWords.add("ris");
            possibleWords.add("rugbrød");possibleWords.add("remoulade");
        }else if(category.equals("Drengenavne")) {
            possibleWords.add("mathias");possibleWords.add("henrik");
            possibleWords.add("dean");possibleWords.add("rasmus");
            possibleWords.add("mads");possibleWords.add("kasper");
            possibleWords.add("william");possibleWords.add("alexander");
            possibleWords.add("jonathan");possibleWords.add("emil");
        }else if(category.equals("Pigenavne")) {
            possibleWords.add("rikke");possibleWords.add("josephine");
            possibleWords.add("hanne");possibleWords.add("natasha");
            possibleWords.add("olivia");possibleWords.add("lotte");
            possibleWords.add("amalie");possibleWords.add("amanda");
            possibleWords.add("alberte");possibleWords.add("clara");
        }else if(category.equals("Byer")) {
            possibleWords.add("københavn");possibleWords.add("slagelse");
            possibleWords.add("holbæk");possibleWords.add("horsens");
            possibleWords.add("odense");possibleWords.add("korsør");
            possibleWords.add("næstved");possibleWords.add("køge");
            possibleWords.add("asnæs");possibleWords.add("kalundborg");
        }else if(category.equals("countries")) {
            possibleWords.add("danmark");possibleWords.add("tyskland");
            possibleWords.add("albanien");possibleWords.add("slovakiet");
            possibleWords.add("sverige");possibleWords.add("norge");
            possibleWords.add("irland");possibleWords.add("holland");
            possibleWords.add("england");possibleWords.add("rusland");
        }else if(category.equals("Sportsgrene")) {
            possibleWords.add("badminton");possibleWords.add("fodbold");
            possibleWords.add("tennis");possibleWords.add("rugby");
            possibleWords.add("svømning");possibleWords.add("håndbold");
            possibleWords.add("ridning");possibleWords.add("højespring");
            possibleWords.add("længdespring");possibleWords.add("ishockey");
        }else if(category.equals("Computermærker")) {
            possibleWords.add("asus");possibleWords.add("msi");
            possibleWords.add("acer");possibleWords.add("dell");
            possibleWords.add("hp");possibleWords.add("apple");
            possibleWords.add("samsung");possibleWords.add("razer");
            possibleWords.add("lenovo");possibleWords.add("medion");
        }

        nulstil();
    }

    public void nulstil() {
        antalForkerteBogstaver = 0;
        antalForsøg = 6;
        spilletErVundet = false;
        spilletErTabt = false;

        wordToGuess = possibleWords.get(new Random().nextInt(possibleWords.size()));

        opdaterSynligtOrd();
    }


    private void opdaterSynligtOrd() {

        synligtOrd = "";
        spilletErVundet = true;
        for (int n = 0; n < wordToGuess.length(); n++) {
            String bogstav = wordToGuess.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + " _ ";
                spilletErVundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {
        if (brugteBogstaver.contains(bogstav)) return;
        if (spilletErVundet || spilletErTabt) return;

        brugteBogstaver.add(bogstav);


        if (wordToGuess.contains(bogstav)) {
        } else {
            antalForkerteBogstaver++;
            antalForsøg--;
            if (antalForsøg <= 0) {
                spilletErTabt = true;
            }
        }

        opdaterSynligtOrd();
    }



    public void logStatus() {


            System.out.println("---------- ");
            System.out.println("- ordet (skjult) = " + wordToGuess);
            System.out.println("- synligtOrd = " + synligtOrd);
            System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
            System.out.println("- brugeBogstaver = " + brugteBogstaver);
            if (spilletErTabt) System.out.println("- SPILLET ER TABT");
            if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
            System.out.println("---------- ");

    }




    /*

    public static String hentUrl(String url) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
        StringBuilder sb = new StringBuilder();
        String linje = br.readLine();
        while (linje != null) {
            sb.append(linje + "\n");
            linje = br.readLine();
        }
        return sb.toString();
    }

    */

    /*

    public void hentOrdFraDr() throws Exception {
        String data = hentUrl("http://dr.dk");
        //System.out.println("data = " + data);

        data = data.substring(data.indexOf("<body")). // fjern headere
                replaceAll("<.+?>", " ").toLowerCase(). // fjern tags
                replaceAll("[^a-zæøå]", " "). // fjern tegn der ikke er bogstaver
                replaceAll(" [a-zæøå] "," "). // fjern 1-bogstavsord
                replaceAll(" [a-zæøå][a-zæøå] "," "); // fjern 2-bogstavsord

        System.out.println("data = " + data);
        easyWords.clear();
        easyWords.addAll(new HashSet<String>(Arrays.asList(data.split(" "))));

        System.out.println("muligeOrd = " + easyWords);
        nulstil();
    }

    */

}
