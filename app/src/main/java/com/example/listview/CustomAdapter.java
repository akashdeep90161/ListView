package com.example.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String countryList[];
    int flags[];
    String[] aboutCountryList;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] countryList, int[] flags,String[] aboutCountryList) {
        this.context = context;
        this.countryList = countryList;
        this.flags = flags;
        this.aboutCountryList=aboutCountryList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return countryList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_list_view, null);
        TextView country = (TextView) view.findViewById(R.id.textView);
       Button bt1=(Button) view.findViewById(R.id.btnFirstChar1);
       Button bt2=(Button) view.findViewById(R.id.btnLastChar2);

        TextView aboutCountry = (TextView) view.findViewById(R.id.textView1);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
    //    Log.d("country",country.toString());
        country.setText(countryList[i]);
        icon.setImageResource(flags[i]);
        aboutCountry.setText(aboutCountryList[i]);
        return view;
    }
}
