package helix.thehangman.frontend.fragments;




import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import helix.thehangman.R;
import helix.thehangman.asynctasks.DownloadWebWords;
import helix.thehangman.model.GlobalData;
import helix.thehangman.frontend.activities.SingleplayerActivity;

public class CategoryFragment extends Fragment implements View.OnClickListener {

    private TextView animals_lbl, cars_lbl, foods_lbl, malenames_lbl,
            girlnames_lbl, cities_lbl, countries_lbl, sports_lbl, computers_lbl, web_words;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_1,
//                wordList);
//
//        listView.setAdapter(arrayAdapter);
//
//        listView.setOnItemClickListener(new OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//
//                Object object = listView.getItemAtPosition(position);
//                String selectedWords = object.toString();
//            }
//        });



        animals_lbl = (TextView) view.findViewById(R.id.animals_lbl);
        cars_lbl = (TextView) view.findViewById(R.id.cars_lbl);
        foods_lbl = (TextView) view.findViewById(R.id.foods_lbl);
        malenames_lbl = (TextView) view.findViewById(R.id.malenames_lbl);
        girlnames_lbl = (TextView) view.findViewById(R.id.girlnames_lbl);
        cities_lbl = (TextView) view.findViewById(R.id.cities_lbl);
        countries_lbl = (TextView) view.findViewById(R.id.countries_lbl);
        sports_lbl = (TextView) view.findViewById(R.id.sports_lbl);
        computers_lbl = (TextView) view.findViewById(R.id.computers_lbl);
        web_words = (TextView) view.findViewById(R.id.web_words);

        animals_lbl.setOnClickListener(this);
        cars_lbl.setOnClickListener(this);
        foods_lbl.setOnClickListener(this);
        malenames_lbl.setOnClickListener(this);
        girlnames_lbl.setOnClickListener(this);
        cities_lbl.setOnClickListener(this);
        countries_lbl.setOnClickListener(this);
        sports_lbl.setOnClickListener(this);
        computers_lbl.setOnClickListener(this);
        web_words.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == animals_lbl) {
            GlobalData.category = "Dyr";
        }else if (v == cars_lbl) {
            GlobalData.category = "Bilmærker";
        }else if (v == foods_lbl) {
            GlobalData.category = "Fødevarer";
        }else if (v == malenames_lbl) {
            GlobalData.category = "Drengenavne";
        }else if (v == girlnames_lbl) {
            GlobalData.category = "Pigenavne";
        }else if (v == cities_lbl) {
            GlobalData.category = "Byer";
        }else if (v == countries_lbl) {
            GlobalData.category = "Lande";
        }else if (v == sports_lbl) {
            GlobalData.category = "Sportsgrene";
        }else if (v == computers_lbl) {
            GlobalData.category = "Computermærker";
        }else if(v == web_words) {
            GlobalData.category = "Webwords";
            new DownloadWebWords().execute();
        }

        if(getFragmentManager().findFragmentById(R.id.fragment_container).isVisible()) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.push_down_in, R.anim.push_down_in);
            ft.remove(getFragmentManager().findFragmentById(R.id.fragment_container));
            ft.commit();
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.anim.push_up_in, R.anim.push_up_in);
        ft.replace(R.id.fragment_container, new NameBoxFragment());
//        ft.addToBackStack(null);
        ft.commit();


//

    }

}
