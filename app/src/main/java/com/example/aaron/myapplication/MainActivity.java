package com.example.aaron.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView homeTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    homeTextMessage.setText(R.string.title_home);
                    removeAllelements();
                    return true;
                case R.id.navigation_dashboard:
                    homeTextMessage.setText(R.string.title_dashboard);
                    removeAllelements();
                    return true;
                case R.id.navigation_notifications:
                    homeTextMessage.setText(R.string.title_notifications);
                    removeAllelements();
                    return true;
            }
            return false;
        }
    };

    private void removeAllelements() {
        for (View v: GUIelements
             ) {
            v.setVisibility(View.GONE);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //if (!RootUtil.isDeviceRooted()) {
        if (false){

            ShowphoneNotRootedDialogAndExit();


        }else {

            setupGUIandListeners();
        }



    }
    ArrayList<View> GUIelements = new ArrayList<>();
    TextView hParams;
    TextView hTextView;
    private void setupGUIandListeners() {

        Button btn;

        homeTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        hTextView = (TextView)findViewById(R.id.htextView);
        btn = (Button) findViewById(R.id.btn);
        hParams = (TextView) findViewById(R.id.hParams);

        GUIelements.add(homeTextMessage);
        GUIelements.add(hTextView);
        GUIelements.add(hParams);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // v.setBackgroundColor(65);
                hTextView.append(hParams.getText());
                triggerStartEvent(findViewById(R.id.hParams).toString().split(" "));

            }

            private void triggerStartEvent(String[] args) {




            }


        });

    }

    private void ShowphoneNotRootedDialogAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setTitle("Not rooted");
        builder.setMessage("Phone is not rooted. Exiting...");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
                System.exit(0);



            }
        });

        builder.show();
    }


}
