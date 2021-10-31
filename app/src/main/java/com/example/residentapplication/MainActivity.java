package com.example.residentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String MSG="com.residentapplication.msg";
    //public static String EncodedAadhaar="";
    int flag=0;
    String aadhar="";
    String username="";
    public void recieve(View view)
    {

        TextView textView=findViewById(R.id.editTextNumber);
        aadhar= textView.getText().toString();

        EditText ed=findViewById(R.id.editTextTextPersonName);
        username= ed.getText().toString();

        Button b=findViewById(R.id.button);
        if(username.equals(""))
        {
            Toast.makeText(this, "Username Cannot be empty ", Toast.LENGTH_SHORT).show();
            flag=1;
        }
        else
        {
            flag=0;
        }
        if(aadhar.length()==12 && flag==0)
        {
            Toast.makeText(this, " OTP Sent to Registered Number ", Toast.LENGTH_SHORT).show();
            b.setClickable(false);
            b.getBackground().setAlpha(100);
            ed.getBackground().setAlpha(100);
            textView.getBackground().setAlpha(100);
            TextView tx=findViewById(R.id.textView2);
            tx.setVisibility(View.VISIBLE);
            TextView t=findViewById(R.id.editTextNumber3);
            t.setVisibility(View.VISIBLE);
            Button button=findViewById(R.id.button2);
            button.setVisibility(View.VISIBLE);
            aadhar=aadhar.substring(8,12);
        }
        else
        {
            Toast.makeText(this, " Please Enter Valid Aadhar Number ", Toast.LENGTH_SHORT).show();
        }
    }

    public void verify(View view)
    {
        TextView tx=findViewById(R.id.editTextNumber3);
        String OTP=tx.getText().toString();
        if(OTP.length()==6)
        {
            if(OTP.equals("571632"))
            {
                Toast.makeText(this, " Vaild OTP ", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,MainPage.class);
                String message=" Welcome "+username;
                intent.putExtra(MSG,aadhar);
                //intent.putExtra(EncodedAadhaar,aadhar);
                startActivity(intent);

            }
            else
            {
                Toast.makeText(this, " Invalid OTP ", Toast.LENGTH_SHORT).show();
                EditText ed=findViewById(R.id.editTextTextPersonName);
                ed.setText("");
                username="";
                TextView textView=findViewById(R.id.editTextNumber);
                textView.setText("");
                aadhar="";
            }
        }
        else
        {
            Toast.makeText(this, " Please Enter Valid OTP ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed=findViewById(R.id.editTextTextPersonName);
        ed.setFocusable(true);
        /*RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, "https://jsonplaceholder.typicode.com/todos/1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    Log.d("myapp","The response is : "+response.getString("title"));
                }
                catch(JSONException e)
                {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("myapp","Something went Wrong");
            }
        });

        requestQueue.add(jsonObjectRequest);*/
    }
}