package com.example.android.ulmtourguide;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Daniel on 15.04.2018.
 */

public class LocationsAdapter extends ArrayAdapter<Destination> {

    private int mColorResourceID;

    public LocationsAdapter(Activity context, ArrayList<Destination> Locations, int colorResourceID) {
        //initialization of adapter
        super(context, 0, Locations);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Destination} object located at this position in the list
        Destination currentDestination = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID text_container
        RelativeLayout textContainer = (RelativeLayout) listItemView.findViewById(R.id.text_container);
        // Get the version name from the current Destination object and
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // set this color on the corresponding TextView
        textContainer.setBackgroundColor(color);

        // Find the TextView in the list_item.xml layout with the ID LocationName
        TextView locationNameTextView = (TextView) listItemView.findViewById(R.id.locationName);
        // Get the location name from the current Destination object and
        // set this text on the LocationName TextView
        locationNameTextView.setText(currentDestination.getLocationName());

        // Find the TextView in the list_item.xml layout with the ID locationDestination
        TextView locationDestinationTextView = (TextView) listItemView.findViewById(R.id.locationDestination);
        // Get the location destination from the current Destination object and
        // set this text on the locationDestination TextView
        locationDestinationTextView.setText(currentDestination.getLocationDestination());
        locationDestinationTextView.setTypeface(Typeface.defaultFromStyle(1));

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Destination object and
        // set the image to iconView
        if (currentDestination.hasImage()) {
            imageView.setImageResource(currentDestination.getImageResourceID());
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView playIcon = (ImageView) listItemView.findViewById(R.id.playIC);
        // Get the image resource ID from the current Destination object and
        // set the image to iconView
        playIcon.setImageResource(R.drawable.ic_play_arrow_white_24dp);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;

    }
}