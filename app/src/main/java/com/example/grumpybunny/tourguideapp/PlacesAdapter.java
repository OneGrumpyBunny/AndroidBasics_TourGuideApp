package com.example.grumpybunny.tourguideapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.core.content.ContextCompat.startActivity;

public class PlacesAdapter extends RecyclerView.Adapter<BaseViewHolder>  {

    private List<Places> PlacesList;

    public PlacesAdapter(List<Places> placesList) {

        PlacesList = placesList;
    }

    // define view holder and bind data to it
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // inflate the places_list layout

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.places_list, parent, false));
    }

    // get the site of the arraylist
    @Override
    public int getItemCount() {
        return PlacesList.size();
    }

    // add data to the array
    public void addItems(ArrayList<Places> placesList) {
        PlacesList.addAll(placesList);
    }

    public class ViewHolder extends BaseViewHolder {

        // Bind views within the view holder
        @BindView(R.id.name)  TextView name;
        @BindView(R.id.address) TextView address;
        @BindView(R.id.addressURI) Button addressURI;
        @BindView(R.id.phone) Button phone;
        @BindView(R.id.website) Button website;
        @BindView(R.id.reviewStars)   TextView reviewStars;
        @BindView(R.id.photo) ImageView photo;
//        @BindView(R.id.twitter) Button twitter;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


        protected void clear() {
            name.setText("");
            address.setText("");
            photo.setImageDrawable(null);
        }

        // populate the views using methods in the custom class
        public void onBind(int position) {
            super.onBind(position);

            final Places places = PlacesList.get(position);

            if (places.getPlaceName() != null) {
                name.setText(places.getPlaceName());
            }

            if (places.getplaceAddress() != null) {
                address.setText(places.getplaceAddress());
            }
            if (places.getAddressURI() != null) {
                addressURI.setOnClickListener(view -> {
                        // grab the value entered in the webText field
                        String mapLoc = places.getAddressURI().toString();
                        Uri addressUri = Uri.parse("geo:0,0?q=" + mapLoc);
                        Log.d("ImplicitIntents", "Opening Map Location: " + addressUri);
                        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                        startActivity(intent);
                });
            }

            if (places.getPhone() != null) {
                website.setOnClickListener(view -> {
                        String phoneNum = places.getPhone().toString();
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phoneNum));
                        startActivity(intent);

                });
            }


            if (places.getWebsiteURI() != null) {
                website.setOnClickListener(view -> {
                    String url = places.getAddressURI();
                    // Parse the URI and create the intent.
                    Uri webpage = Uri.parse(url);
                   Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(intent);
                });

            }

            if (places.getReviewStars() != null) {
                reviewStars.setText(places.getReviewStars());
            }


            if (places.getPhoto() != 0) {
                photo.setImageResource(places.getPhoto());
            }

        }

    }
}
