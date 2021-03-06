package com.example.premal2.travelagency;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;

public class flightlist extends MainActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightlist);
        final FloatingActionButton back=(FloatingActionButton) findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(flightlist.this,flightselect.class));
            }
        });
        final FloatingActionButton message=(FloatingActionButton) findViewById(R.id.mess_btn);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(flightlist.this,enquiry.class));
            }
        });
        final TextView[] option=new TextView[10];
        option[0] =(TextView) findViewById(R.id.option1);
        option[1] =(TextView) findViewById(R.id.option2);
        option[2] =(TextView) findViewById(R.id.option3);
        option[3] =(TextView) findViewById(R.id.option4);
        option[4] =(TextView) findViewById(R.id.option5);
        option[5] =(TextView) findViewById(R.id.option6);
        option[6] =(TextView) findViewById(R.id.option7);
        option[7] =(TextView) findViewById(R.id.option8);
        option[8] =(TextView) findViewById(R.id.option9);
        option[9] =(TextView) findViewById(R.id.option10);
        option[0].setText("");
        option[1].setText("");
        option[2].setText("");
        option[3].setText("");
        option[4].setText("");
        option[5].setText("");
        option[6].setText("");
        option[7].setText("");
        option[8].setText("");
        option[9].setText("");
        int c=0;
        /*Iterator<flightdetail> itr=GRAPH.graph.adjListArray[source].iterator();
        while (itr.hasNext())
        {
            if((itr.next().dest==dest))
            option1.setText(option1.getText().toString()+" "+itr.next().departtime);
            c++;
        }*/
       // Toast.makeText(getApplicationContext(),itr.next().departtime+"", Toast.LENGTH_SHORT).show();
        int i=0;
        for(final flightdetail p: GRAPH.graph.adjListArray[source])
        {

            if((p.dest==dest)&&(p.day==deptday))
            {
                option[i].setText(city(source)+" to "+city(dest)+"                                                 ₹"+p.fare+"\n Departure Time: "+p.departtime/100+":"+p.departtime%100+"    Arrival Time "+p.returntime/100+":"+p.returntime%100);
            option[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dtime=p.departtime;
                    rtime=p.returntime;
                    flightfare=p.fare;
                    startActivity(new Intent(flightlist.this,bookflight.class));
                }
            });
                i++;
            }
        }
        //Toast.makeText(getApplicationContext(),c+"", Toast.LENGTH_SHORT).show();



    }
}
