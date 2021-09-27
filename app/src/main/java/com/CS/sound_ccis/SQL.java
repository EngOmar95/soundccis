package com.CS.sound_ccis;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SQL {

    JSONObject jsonObject;
    JSONArray jsonArray;
    StringRequest stringRequest;
    SharedPreferences sp;


    public void Insert_Update(final Context context , final String url, final ArrayList<DATA> data , final String flag){

        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    jsonObject = new JSONObject(response);



                    if(jsonObject.getString("AllValue").equals("true")){


                        if(flag.equals("1")) {
                            Toast.makeText(context, "تم التسجيل", Toast.LENGTH_SHORT).show();

                        }
                     else {
                            Toast.makeText(context, "تم تعديل البيانات", Toast.LENGTH_SHORT).show();
                        }  }
                    else if(jsonObject.getString("AllValue").equals("Email_already_exists")){
                        Toast.makeText(context, "الايميل مسجل بفعل", Toast.LENGTH_SHORT).show();
                        

                    }

                } catch (JSONException e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"تأكد من الاتصال بلأنترنت", Toast.LENGTH_SHORT).show();
            }
        }) {



            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                for(int i =0;i<data.size();i++) {
                    params.put(data.get(i).DataBase, data.get(i).Value);
                }


                params.put("Flag", flag);
                ;
                return params;
            }

        };
        Volley.newRequestQueue(context).add(stringRequest);




    }


    public void login (final Context context , final String Email , final String Password, final int UserORAdmin ) {





   

        stringRequest = new StringRequest(Request.Method.POST, "https://soundccis.000webhostapp.com/logIn.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    jsonObject = new JSONObject(response);
                    jsonArray = jsonObject.getJSONArray("AllValue");


                    sp = PreferenceManager.getDefaultSharedPreferences(context);
                    SharedPreferences.Editor edit=sp.edit();

                   // Toast.makeText(context, String.valueOf(jsonArray.length()), Toast.LENGTH_SHORT).show();
                    if (jsonArray.length() > 0) {

                       SQL.this.jsonObject =jsonArray.getJSONObject(0)     ;
                        Intent intent;
                      intent = new Intent(context, MainActivity.class);


                        if (UserORAdmin == 1) {    //User

                            edit.putString("first_name",SQL.this.jsonObject.getString("first_name"));
                            edit.putString("last_name",SQL.this.jsonObject.getString("last_name"));
                            edit.putString("Email",SQL.this.jsonObject.getString("Email"));
                            edit.putString("Password",SQL.this.jsonObject.getString("Password"));
                            edit.putString("checkIn",SQL.this.jsonObject.getString("user_id"));
                        

                          //  edit.apply();
                            //context.startActivity(intent);
                        } else if (UserORAdmin == 2) {  //Admin

                            edit.putString("first_name","Admin");
                            edit.putString("last_name","A");
                            edit.putString("Email", SQL.this.jsonObject.getString("Email"));
                            edit.putString("Password",SQL.this.jsonObject.getString("Password"));
                            edit.putString("checkIn",SQL.this.jsonObject.getString("admin_id"));





                          //  edit.apply();
                            //context.startActivity(intent);
                        }
                        edit.apply();
                        context.startActivity(intent);

                    } else {

                        Toast.makeText(context, "الايميل او الرقم السري غير صحيح ", Toast.LENGTH_SHORT).show();


                    }
                } catch (JSONException e) {
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"تأكد من الاتصال بلأنترنت", Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Email", Email);
                params.put("Password", Password);
                if (UserORAdmin == 1) {

                    params.put("flag", "1");
                }  else {
                    params.put("flag", "2");
                }
                return params;
            }

        };
        Volley.newRequestQueue(context).add(stringRequest);

    }

    public void Show_database(final Context context, String url, final ArrayList<DATA>data, final ArrayList<DATA>Values, final String flag) {


        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    jsonObject = new JSONObject(response);
                    jsonArray = jsonObject.getJSONArray("AllValue");

                    int y=0;
                    for (int i = 0; i < jsonArray.length(); i++) {
                       jsonObject = jsonArray.getJSONObject(i);



                      for (int j = 0; j<jsonObject.length()/2; j++) {

                        data.get(y).editText.setText(jsonObject.getString(data.get(y).DataBase));
                       y++;

                          }
                   }

                    


                } catch (JSONException e) {

                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"تأكد من الاتصال بلأنترنت", Toast.LENGTH_SHORT).show();
            }
        }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                    if(!flag.equals("3") && !flag.equals("4") ) {
                        for (int j = 0; j < Values.size(); j++) {
                            params.put(Values.get(j).DataBase, Values.get(j).Value);
                        }
                }
                if(flag.equals("1")){
                    params.put("flag", "1");

                }   if(flag.equals("2")) {

                    params.put("flag", "2");

                }               if(flag.equals("3")) {

                    params.put("flag", "3");
                }

               if(flag.equals("4")) {

                   params.put("flag", "4");
                }
                //    params.put("userName", user);


                return params;
            }

        };
        Volley.newRequestQueue(context).add(stringRequest);

    }

    public  void Forget_Password (final Context context , final String Email , final String new_password, final String Message ){



        stringRequest = new StringRequest(Request.Method.POST, "https://soundccis.000webhostapp.com/forgetPassword.php", new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {

                try {

                    jsonObject = new JSONObject(response);


                    if(jsonObject.getString("AllValue").equals("true")){


                        Toast.makeText(context, "تم ارسال الرقم السري الجديد الى ايميلك", Toast.LENGTH_SHORT).show();



                    }
                    if(jsonObject.getString("AllValue").equals("false")){
                        Toast.makeText(context, "الايميل غير صحيح", Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(context, "تXXX", Toast.LENGTH_SHORT).show();

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "تأكد بلأتصال بلانترنت", Toast.LENGTH_SHORT).show();
               


            }
        }) {



            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("Email",Email);
                params.put("Message", Message);
                params.put("new_password", new_password);





                return params;
            }

        };
        Volley.newRequestQueue(context).add(stringRequest);


    }


    
}
