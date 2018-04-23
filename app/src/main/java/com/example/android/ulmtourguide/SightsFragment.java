package com.example.android.ulmtourguide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Daniel on 15.04.2018.
 */

public class SightsFragment extends Fragment {

    public SightsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.location_list, container, false);

        final ArrayList<Destination> locations = new ArrayList<Destination>();
        //Pictures are from the internet from different websites and app will not be published
        locations.add (new Destination( getString(R.string.friedrichsau), getString(R.string.outer_city), getString(R.string.nature), R.drawable.friedrichsau));
        locations.add (new Destination( getString(R.string.rathaus), getString(R.string.city), getString(R.string.history), R.drawable.rathaus));
        locations.add (new Destination( getString(R.string.hfg), getString(R.string.outer_city), getString(R.string.design_museum), R.drawable.hfg));
        locations.add (new Destination( getString(R.string.munster), getString(R.string.city), getString(R.string.church), R.drawable.munster));
        locations.add (new Destination( getString(R.string.einstein_birthplace), getString(R.string.city), getString(R.string.history), R.drawable.einstein));
        locations.add (new Destination( getString(R.string.schiefes_haus), getString(R.string.fischerviertel), getString(R.string.history), R.drawable.schiefeshaus));
        locations.add (new Destination( getString(R.string.donau), getString(R.string.city), getString(R.string.nature), R.drawable.donau));
        locations.add (new Destination( getString(R.string.blautopf), getString(R.string.blaubeuren), getString(R.string.nature), R.drawable.blautopf));

        LocationsAdapter locationItemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_sights);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(locationItemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //put details into the intent:
                //1. the clicked position
                //2. the whole array
                Bundle details=new Bundle();
                details.putInt("pos",position);
                details.putSerializable("locations", locations);
                Intent sightsDetailActivity = new Intent(getActivity(), SightsActivity.class);
                sightsDetailActivity.putExtras(details);
                startActivity(sightsDetailActivity);
            }
        });
        return rootView;
    }
}
