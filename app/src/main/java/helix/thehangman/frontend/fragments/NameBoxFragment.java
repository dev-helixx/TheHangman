package helix.thehangman.frontend.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import helix.thehangman.R;
import helix.thehangman.frontend.activities.SingleplayerActivity;
import helix.thehangman.model.GlobalData;

/**
 * A simple {@link Fragment} subclass.
 */
public class NameBoxFragment extends Fragment implements  View.OnClickListener{

    private Button okBtn;
    private EditText playerName;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name_box, container, false);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {

        playerName = (EditText) view.findViewById(R.id.playerName);
        okBtn = (Button) view.findViewById(R.id.okBtn);
        okBtn.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if(view == okBtn) {
//            new Handler().postDelayed(new Runnable()
//        {
//            @Override
//            public void run()
//            {
                Intent i = new Intent(getActivity(), SingleplayerActivity.class);
                GlobalData.playerName = playerName.getText().toString();
                startActivity(i);
                getActivity().onBackPressed();
//            }
//        }, 500);
        }
    }
}
