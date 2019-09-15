package com.example.grumpybunny.tourguideapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    private List<Places> PlacesList;

    public PlacesAdapter(List<Places> placesList) {
        this.PlacesList = placesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate the places_list layout
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.places_list, parent, false));
    }


    // populate the views using methods in the custom class
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Places places = PlacesList.get(position);

        if (places.getPlaceName() != null) {
            holder.name.setText(places.getPlaceName());
        }

        if (places.getplaceAddress() != null) {
            holder.address.setText(places.getplaceAddress());
            String mapLoc = places.getplaceAddress();
            openMaps(holder.addressURI, mapLoc);
        }

        // Phone is present in only 3 of the 4 lists
        // therefore hide the button when not in use
        if (places.getPhone() != null) {
            String phoneNum = places.getPhone();
            openPhone(holder.phone, phoneNum);
        } else {
            holder.phone.setVisibility(View.GONE);
        }

        // Calendar is present in only 1 of the 4 lists
        // therefore hide the button when not in use
        if (places.getICalBegin() != 0) {
            int ICalBegin = places.getICalBegin();
            int ICalEnd = places.getICalEnd();
            String eventTitle = places.getPlaceName();
            String eventLocation = places.getplaceAddress();
            openICal(holder.ICal, eventTitle, eventLocation, ICalBegin, ICalEnd);
        } else {
            holder.ICal.setVisibility(View.GONE);
        }

        if (places.getWebsiteURI() != null) {
            String url = places.getWebsiteURI();
            openWebsite(holder.website, url);
        }

        if (places.getPhoto() != 0) {
            holder.photo.setImageResource(places.getPhoto());
        }

    }

    // get the site of the arraylist
    @Override
    public int getItemCount() {
        return PlacesList.size();
    }

    // this opens a URL from the current list when the website button is tapped
    private void openWebsite(Button website, String url) {
        website.setOnClickListener(v -> {
            Uri webpage = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            v.getContext().startActivity(intent);
        });

    }

    // this opens a Phone app when the phone button is tapped
    private void openPhone(Button phone, String phoneNum) {
        phone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + phoneNum));
            v.getContext().startActivity(intent);

        });
    }

    // this opens a Maps app when the map button is tapped
    private void openMaps(Button address, String mapLoc) {
        address.setOnClickListener(v -> {
            Uri addressUri = Uri.parse("geo:0,0?q=" + mapLoc);
            Log.d("ImplicitIntents", "Opening Map Location: " + addressUri);
            Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
            v.getContext().startActivity(intent);
        });
    }

    // this opens a Calendar app when the calendar button is tapped
    private void openICal(Button iCal, String title, String location, int dateBegin, int dateEnd) {
        Calendar beginDate = Calendar.getInstance();
        beginDate.set(2019, 8, dateBegin, 8, 0);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 8, dateEnd, 20, 0);
        iCal.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_EDIT)
                    .setType("vnd.android.cursor.item/event")
                    .putExtra(CalendarContract.Events.TITLE, title)
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginDate.getTimeInMillis())
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endDate.getTimeInMillis());
            v.getContext().startActivity(intent);
        });
    }

    // set up the recycler view
    public class ViewHolder extends RecyclerView.ViewHolder {

        // Bind views within the view holder
        @BindView(R.id.parent_layout)
        ConstraintLayout parentLayout;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.address)
        TextView address;
        @BindView(R.id.addressURI)
        Button addressURI;
        @BindView(R.id.phone)
        Button phone;
        @BindView(R.id.website)
        Button website;
        @BindView(R.id.photo)
        ImageView photo;
        @BindView(R.id.ICal)
        Button ICal;

        // bind the view
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
