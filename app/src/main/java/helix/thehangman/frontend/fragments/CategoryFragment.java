package helix.thehangman.frontend.fragments;




import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import helix.thehangman.R;
import helix.thehangman.asynctasks.DownloadWebWords;
import helix.thehangman.model.GlobalData;
import helix.thehangman.frontend.activities.SingleplayerActivity;

public class CategoryFragment extends Fragment {

    private ArrayList<String> categoryArray = new ArrayList<String>();
    private ListView category_listview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        category_listview = (ListView) view.findViewById(R.id.category_listview);

        categoryArray.add("Ord fra www.dr.dk");
        categoryArray.add("Dyrearter");
        categoryArray.add("Fødevarer");
        categoryArray.add("Bilmærker");
        categoryArray.add("Drengenavne");
        categoryArray.add("Pigenavne");
        categoryArray.add("Byer");
        categoryArray.add("Lande");
        categoryArray.add("Sportsgrene");
        categoryArray.add("Computermærker");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.listview_centered, R.id.textItem5, categoryArray);

        category_listview.setAdapter(arrayAdapter);

        category_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                Object object = category_listview.getItemAtPosition(position);
                String selectedCategory = object.toString();

                if(selectedCategory.equals("Ord fra www.dr.dk"))
                {
                    GlobalData.category = "Web-ord";
                    new DownloadWebWords().execute();

                }else {
                    GlobalData.category = selectedCategory;
                }

                System.out.println("category: " + GlobalData.category);


                if(getFragmentManager().findFragmentById(R.id.fragment_container).isVisible()) {
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.setCustomAnimations(R.anim.push_down_in, R.anim.push_down_in);
                    ft.remove(getFragmentManager().findFragmentById(R.id.fragment_container));
                    ft.commit();
                }

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.setCustomAnimations(R.anim.push_up_in, R.anim.push_up_in);
                ft.replace(R.id.fragment_container, new NameBoxFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }

}

