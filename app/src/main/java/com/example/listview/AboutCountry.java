package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutCountry extends AppCompatActivity {
    TextView myTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_country);
        Bundle bundle = getIntent().getExtras();
        String s=bundle.get("aboutCountry").toString();
        myTextView=(TextView) findViewById(R.id.textViewAboutCountry);
        myTextView.setText(s);

    }
}
