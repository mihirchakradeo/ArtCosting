package com.example.mihir.artcosting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String artistspricetogallery = getIntent().getStringExtra("artistspricetogallery");
        String gallerycommission = getIntent().getStringExtra("gallerycommission");
        String listprice = getIntent().getStringExtra("listprice");
        String retailprice = getIntent().getStringExtra("retailprice");
        Log.d("artistspricetogallery",artistspricetogallery);
        Log.d("gallerycommission",gallerycommission);


        tv1 = (TextView)findViewById(R.id.textView);
        tv1.setText("Artist's price to gallery: "+artistspricetogallery);
        tv2 = (TextView)findViewById(R.id.textView5);
        tv2.setText("Gallery's Commission: "+gallerycommission);
        tv3 = (TextView)findViewById(R.id.textView6);
        tv3.setText("List Price: "+listprice);
        tv4 = (TextView)findViewById(R.id.textView7);
        tv4.setText("Retail Price: "+retailprice);

    }
}
