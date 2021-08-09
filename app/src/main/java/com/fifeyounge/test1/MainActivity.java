package com.fifeyounge.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    ProgressBar P1;
    EditText ed1;
    EditText ed2;
    TextView tv1;
    String ed,edd,z;
    Float Result,x,y;
   RadioButton tr,dr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tr=findViewById(R.id.tr);
        dr=findViewById(R.id.dr);
        dr.setChecked(true);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        tv1=findViewById(R.id.tv1);
        ed1.setHint("المبلغ بالدولار");


    }


    public void b1(View view) {

       ed=ed1.getText().toString();
        if(tr.isChecked()==true)
        {

            x=Float.parseFloat(ed);
            y=Float.parseFloat(edd);

            Result=x/y;
            tv1.setText(Result+"");
        }
        else
        {
            x=Float.parseFloat(ed);
            y=Float.parseFloat(edd);

            Result=x*y;
            tv1.setText(Result+"");
        }


        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://api.currencylayer.com/live?access_key=6317736084be0ad542b112c6c62c30b7&format=1";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject obj= null;
                        try {
                            obj = new JSONObject(response);

                            JSONObject obj1=obj.getJSONObject("quotes");
                            String str=obj1.getString("USDTRY");
                            Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        queue.add(stringRequest);






    }

    public void r1(View view) {
        ed1.setHint("المبلغ بالتركي");
    }

    public void r2(View view) {
        ed1.setHint("المبلغ بالدولار");
    }
}