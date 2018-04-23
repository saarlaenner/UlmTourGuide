package com.example.android.ulmtourguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 15.04.2018.
 */

public class BarsActivity extends AppCompatActivity {

    public int mDestinationID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_category);

        //get the Extra Data from the intent
        Bundle gotDetails = getIntent().getExtras();
        mDestinationID = gotDetails.getInt("pos");
        ArrayList<Destination> Destinations = (ArrayList<Destination>) getIntent().getSerializableExtra("locations");

        // Get the {@link Destination} object located at this position in the list
        Destination currentDestination = Destinations.get(mDestinationID);

        //Set the corresponding Background color
        LinearLayout containerLayout = findViewById(R.id.container);
        containerLayout.setBackgroundColor(getResources().getColor(R.color.category_bars));

        // Find the TextView in the list_item.xml layout with the ID LocationName
        TextView locationNameTextView = findViewById(R.id.details_destination_name);
        // Get the location name from the current Destination object and 
        // set this text on the LocationName TextView
        locationNameTextView.setText(getString(R.string.name) + currentDestination.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID LocationName
        TextView locationDestinationTextView = findViewById(R.id.details_destination_location);
        // Get the location name from the current Destination object and
        // set this text on the LocationName TextView
        locationDestinationTextView.setText(getString(R.string.destination) + currentDestination.getLocationDestination());

        // Find the TextView in the list_item.xml layout with the ID LocationName
        TextView locationCategoryTextView = findViewById(R.id.details_destination_category);
        // Get the location name from the current Destination object and
        // set this text on the LocationName TextView
        locationCategoryTextView.setText(getString(R.string.category) + currentDestination.getLocationCategory());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView locationImageView = findViewById(R.id.details_image);
        // Get the image resource ID from the current Destination object and
        // set the image to iconView
        if (currentDestination.hasImage()) {
            locationImageView.setImageResource(currentDestination.getImageResourceID());
        } else {
            locationImageView.setVisibility(View.GONE);
        }
    }
}
