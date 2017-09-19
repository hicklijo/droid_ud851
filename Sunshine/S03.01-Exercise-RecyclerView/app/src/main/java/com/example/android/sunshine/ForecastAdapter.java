package com.example.android.sunshine;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by john.hicklin on 9/18/2017.
 */
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// COMPLETE (15) Add a class file called ForecastAdapter
// COMPLETE (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

// COMPLETE (23) Create a private string array called mWeatherData

// COMPLETE (47) Create the default constructor (we will pass in parameters in a later lesson)

// COMPLETE (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
// COMPLETE (17) Extend RecyclerView.ViewHolder

// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
// TODO (18) Create a public final TextView variable called mWeatherTextView

// TODO (19) Create a constructor for this class that accepts a View as a parameter
// TODO (20) Call super(view) within the constructor for ForecastAdapterViewHolder
// TODO (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView
// Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////


// TODO (24) Override onCreateViewHolder
// TODO (25) Within onCreateViewHolder, inflate the list item xml into a view
// TODO (26) Within onCreateViewHolder, return a new ForecastAdapterViewHolder with the above view passed in as a parameter

// TODO (27) Override onBindViewHolder
// TODO (28) Set the text of the TextView to the weather for this list item's position

// TODO (29) Override getItemCount
// TODO (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null

// TODO (31) Create a setWeatherData method that saves the weatherData to mWeatherData
// TODO (32) After you save mWeatherData, call notifyDataSetChanged
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
    private String[] mWeatherData;


    public ForecastAdapter(){

    }

    public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
        public final TextView mWeatherTextView;

        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
        }

    }

    public ForecastAdapter.ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttatchToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttatchToParentImmediately);

        return new ForecastAdapterViewHolder(view);
    }

    // COMPLETED (27) Override onBindViewHolder
    // COMPLETED (28) Set the text of the TextView to the weather for this list item's position
    @Override
    public void onBindViewHolder(ForecastAdapterViewHolder forecastAdapterViewHolder, int position) {
        String weatherForThisDay = mWeatherData[position];
        forecastAdapterViewHolder.mWeatherTextView.setText(weatherForThisDay);
    }

    // COMPLETED (29) Override getItemCount
    // COMPLETED (30) Return 0 if mWeatherData is null, or the size of mWeatherData if it is not null
    @Override
    public int getItemCount() {
        if(null == mWeatherData) return 0;
        return mWeatherData.length;
    }

    public void setWeatherData(String[] weatherData){
        mWeatherData = weatherData;
        notifyDataSetChanged();
    }
}
