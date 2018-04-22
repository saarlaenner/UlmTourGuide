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
        locations.add (new Destination( "Friedrichsau", "Outer city", "Nature", R.drawable.friedrichsau));
        locations.add (new Destination( "Rathaus", "City", "History", R.drawable.rathaus));
        locations.add (new Destination( "Hochschule für Gestaltung (HfG)", "Kuhberg", "Design/Museum", R.drawable.hfg));
        locations.add (new Destination( "Munster", "City", "Church", R.drawable.munster));
        locations.add (new Destination( "Albert Einstein Birthplace", "City", "History", R.drawable.einstein));
        locations.add (new Destination( "Schiefes Haus", "Fischerviertel", "History", R.drawable.schiefeshaus));
        locations.add (new Destination( "Donau", "City", "Nature", R.drawable.donau));
        locations.add (new Destination( "Blautopf", "Blaubeuren", "Nature", R.drawable.blautopf));

        LocationsAdapter itemsAdapter = new LocationsAdapter(getActivity(), locations, R.color.category_sights);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Destination location = locations.get(position);
                Bundle details=new Bundle();
                details.putInt("pos",position);
                details.putSerializable("locations", locations);
                Intent a = new Intent(getActivity(), SightsActivity.class);
                a.putExtras(details);
                startActivity(a);
            }
        });
        return rootView;
    }
}
