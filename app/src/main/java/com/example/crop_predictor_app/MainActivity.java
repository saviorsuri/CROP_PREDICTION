package com.example.crop_predictor_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText air_humidity,temperature,rainfall,ph;
    Button predict;
    TextView result;
    String url = "https://crop-prediction-app-7806.herokuapp.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        air_humidity = findViewById(R.id.air_humidity);
        temperature = findViewById(R.id.temperature);

        rainfall = findViewById(R.id.rainfall);
        ph = findViewById(R.id.ph);
        predict=findViewById(R.id.button);
        result=findViewById(R.id.crop);

        predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // hit the API -> Volley
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("crop_name");
                                    result.setText(data);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("ah",air_humidity.getText().toString());
//                        params.put("shum",soil_humidity.getText().toString());
                        params.put("atemp",temperature.getText().toString());
                        params.put("ph",ph.getText().toString());
                        params.put("rain",rainfall.getText().toString());
                        return params;
                    }

                };
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
            }
        });
    }
    }
