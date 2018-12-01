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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!RootUtil.isDeviceRooted()) {
            //ShowphoneNotRootedDialogAndExit();
        }else {setupGUIandListeners();}



    }

    private void setupGUIandListeners() {
        final TextView textView;
        Button btn;

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        textView = (TextView)findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btn);
        final TextView params = (TextView) findViewById(R.id.params);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // v.setBackgroundColor(65);
                textView.append(params.getText());
                triggerStartEvent(findViewById(R.id.params).toString().split(" "));

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
