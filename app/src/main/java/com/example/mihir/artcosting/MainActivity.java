package com.example.mihir.artcosting;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText amcEt;
    EditText alcEt;
    EditText gpEt;
    Button button;
    Button buttonclr;
    TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amcEt = (EditText)findViewById(R.id.amcEt);
        alcEt = (EditText)findViewById(R.id.alcEt);
        gpEt = (EditText)findViewById(R.id.gpEt);
        button = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textViewFinal);
        buttonclr = (Button)findViewById(R.id.buttonclr);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amcEt !=null && alcEt!=null && gpEt!=null)
                {

                    double amc = Double.parseDouble(amcEt.getText().toString());
                    double alc = Double.parseDouble(amcEt.getText().toString());
                    double gp = Double.parseDouble(gpEt.getText().toString());

                    final double ade = amc+alc + 0.5*(amc+alc);
                    Log.d("ade", String.valueOf(ade));
                    Log.d("gp", String.valueOf(gp));
                    double fgp1 = (ade*gp)/100;
                    Log.d("fgp1", String.valueOf(fgp1));
                    double fgp2 = 0.2*fgp1; //20% VAT on gallery price
                    Log.d("fgp2", String.valueOf(fgp2));
                    final double fgp = fgp1 + fgp2;
                    Log.d("fgp", String.valueOf(fgp));
                    final double listPrice = ade + fgp;
                    Log.d("lp", String.valueOf(listPrice));
                    final double retailPrice = listPrice + 0.2*(listPrice);
                    Log.d("rp", String.valueOf(retailPrice));
                    tv.setText("RETAIL PRICE: "+retailPrice);
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            intent.putExtra("artistspricetogallery", String.valueOf(ade));
                            intent.putExtra("gallerycommission", String.valueOf(fgp));
                            intent.putExtra("listprice", String.valueOf(listPrice));
                            intent.putExtra("retailprice", String.valueOf(retailPrice));
                            startActivity(intent);
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Incomplete Fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonclr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amcEt.setText(null);
                alcEt.setText(null);
                gpEt.setText(null);
                tv.setText("RETAIL PRICE: ");
            }
        });
    }
}