package com.example.aaron.myapplication;

import android.graphics.Color;
import android.widget.Button;
import android.widget.LinearLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TableLayout;

import java.util.ArrayList;

public class GameSpace extends AppCompatActivity {
    ArrayList<ArrayList<Button>> gameBtns;
    MainActivity context;

    public GameSpace(MainActivity context) {
        this.context = context;
        generateGamseSpace();
    }

    private void generateGamseSpace() {
        for (int i =0; i< 4;i++){
            gameBtns.add(new ArrayList<Button>());
            for (int j= 0 ;j < 4 ;j++){

                Button tempBtn = new Button(context) ;
                tempBtn.setBackgroundColor(getRandomColor());


                TableLayout tblLayout = (TableLayout) findViewById(R.id.tableLayout);
                tblLayout.addView(tempBtn);



                //tempBtn.set
                gameBtns.get(i).add(tempBtn);
            }
        }
    }


    private int getRandomColor() {

    return Color.BLUE;
    }
}
