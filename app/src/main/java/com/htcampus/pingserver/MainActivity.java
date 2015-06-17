package com.htcampus.pingserver;


import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private LinearLayout ip;

    private ListView listViewMessages;

    private Button submit;

    private IPAdapter adapter;

    private List<LinearLayout> listMessages;

    private InetAddress address;
/*
    public static final Pattern IP_ADDRESS
            = Pattern.compile(
            "((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4]"
                    + "[0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]"
                    + "[0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}"
                    + "|[1-9][0-9]|[0-9]))");*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*
        Matcher matcher = IP_ADDRESS.matcher("172.16.64");
        boolean IPcheck = matcher.matches();
        if (IPcheck){
            Toast.makeText(getApplicationContext(), "correct ip", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "not correct", Toast.LENGTH_SHORT).show();
        }

        */


        listViewMessages = (ListView) findViewById(R.id.list_view_messages);
        listMessages = new ArrayList<LinearLayout>();
        adapter = new IPAdapter(this, listMessages);

        listViewMessages.setAdapter(adapter);



        submit = (Button) findViewById(R.id.button1);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "submit ip", Toast.LENGTH_SHORT).show();
                //new getNewContact().execute(String.valueOf(ip.getText()));

            }
        });



        findViewById(R.id.pink_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(), "Floating button pressed", Toast.LENGTH_SHORT).show();

                listMessages.add(ip);
                adapter.notifyDataSetChanged();


            }
        });


    }


    private class getNewContact extends AsyncTask<String, Void, String> {


        protected String doInBackground(String... ip_address) {

            boolean reachable = false;
            String status = "Sorry";


            try {

                address = InetAddress.getByName(ip_address[0]);


                reachable = address.isReachable(3000);

            } catch (UnknownHostException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }

            if (reachable) {
                status = "SUCCESS";

            } else {
                status = "FAILED";

            }
            return status;
        }

        @Override
        protected void onPostExecute(String st) {
            Toast.makeText(getApplicationContext(), String.valueOf(address), Toast.LENGTH_SHORT).show();
            Log.e("Http Response:", st);
            TextView txt = (TextView) findViewById(R.id.info);
            txt.setText(st);


        }


    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }


