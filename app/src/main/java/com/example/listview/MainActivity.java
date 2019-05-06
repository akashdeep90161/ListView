package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,View.OnClickListener {
    ListView listView;
   Button bt1;
   Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listView);


        final String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
        int flags[] = {R.drawable.india, R.drawable.chine, R.drawable.aus, R.drawable.purt, R.drawable.america, R.drawable.newz};


        final String aboutCountry[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags,aboutCountry);
        Log.d("xy",customAdapter.toString());
      /*  simpleList.setAdapter(customAdapter);
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,countryList);
*/
        listView.setAdapter(customAdapter);


    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onClick(View v) {

    }
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
            final TextView country = (TextView) view.findViewById(R.id.textView);
            Button bt1=(Button) view.findViewById(R.id.btnFirstChar1);
            Button bt2=(Button) view.findViewById(R.id.btnLastChar2);

            TextView aboutCountry = (TextView) view.findViewById(R.id.textView1);
            ImageView icon = (ImageView) view.findViewById(R.id.icon);
            //    Log.d("country",country.toString());
            country.setText(countryList[i]);
            icon.setImageResource(flags[i]);
            aboutCountry.setText(aboutCountryList[i]);

            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AboutCountry.class);
                    String str=country.getText().toString();
                    intent.putExtra("aboutCountry","FirstChar: "+ str.charAt(0));
                    startActivity(intent);

                }
            });

            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AboutCountry.class);
                    String str=country.getText().toString();
                    intent.putExtra("aboutCountry","LastChar: "+ str.charAt(str.length()-1));
                    startActivity(intent);

                }
            });



            return view;
        }
    }

}
