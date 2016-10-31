package helix.thehangman;




import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class CategoryFragment extends Fragment implements View.OnClickListener {

    public TextView animals_lbl, cars_lbl, foods_lbl, malenames_lbl,
            girlnames_lbl, cities_lbl, countries_lbl, sports_lbl, computers_lbl;
    public static String category;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        animals_lbl = (TextView) view.findViewById(R.id.animals_lbl);
        cars_lbl = (TextView) view.findViewById(R.id.cars_lbl);
        foods_lbl = (TextView) view.findViewById(R.id.foods_lbl);
        malenames_lbl = (TextView) view.findViewById(R.id.malenames_lbl);
        girlnames_lbl = (TextView) view.findViewById(R.id.girlnames_lbl);
        cities_lbl = (TextView) view.findViewById(R.id.cities_lbl);
        countries_lbl = (TextView) view.findViewById(R.id.countries_lbl);
        sports_lbl = (TextView) view.findViewById(R.id.sports_lbl);
        computers_lbl = (TextView) view.findViewById(R.id.computers_lbl);

        animals_lbl.setOnClickListener(this);
        cars_lbl.setOnClickListener(this);
        foods_lbl.setOnClickListener(this);
        malenames_lbl.setOnClickListener(this);
        girlnames_lbl.setOnClickListener(this);
        cities_lbl.setOnClickListener(this);
        countries_lbl.setOnClickListener(this);
        sports_lbl.setOnClickListener(this);
        computers_lbl.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == animals_lbl) {
            category = "Dyr";
        }else if (v == cars_lbl) {
            category = "Bilmærker";
        }else if (v == foods_lbl) {
            category = "Fødevarer";
        }else if (v == malenames_lbl) {
            category = "Drengenavne";
        }else if (v == girlnames_lbl) {
            category = "Pigenavne";
        }else if (v == cities_lbl) {
            category = "Byer";
        }else if (v == countries_lbl) {
            category = "Lande";
        }else if (v == sports_lbl) {
            category = "Sportsgrene";
        }else if (v == computers_lbl) {
            category = "Computermærker";
        }



        Intent i = new Intent(getActivity(), SingleplayerActivity.class);
        getActivity().onBackPressed();
        startActivity(i);


    }

}
