package com.example.mad_practical_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<User> Userlist = new ArrayList<>();

        for (int i=0 ; i<20 ; i++) {
            User Tu = new User();
            Tu.id = i;
            Userlist.add(Tu);
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        R_Adapter rAdapter = new R_Adapter(ListActivity.this, Userlist);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(rAdapter);

    }

    public void Alert_d(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage("MADness");

        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent VB = new Intent(ListActivity.this, MainActivity.class);

                Random rnd = new Random();
                Integer PN = rnd.nextInt(999999999);
                VB.putExtra("PN", PN);
                startActivity(VB);
            }
        });

        builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
            }
        });


        AlertDialog alert = builder.create();
        alert.show();
    }
}