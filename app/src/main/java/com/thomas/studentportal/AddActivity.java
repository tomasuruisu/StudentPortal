package com.thomas.studentportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {

    Button button;
    EditText urlText;
    EditText titleText;
    ArrayList<PortalObject> portals;
    PortalObject portal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent intent = getIntent();
        portals = intent.getParcelableArrayListExtra("PORTALS");
        if (portals == null) {
            portals = new ArrayList<>();
        }

        button = findViewById(R.id.button);
        urlText = findViewById(R.id.editURL);
        titleText = findViewById(R.id.editTitle);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                portal = new PortalObject(urlText.getText().toString(), titleText.getText().toString());
                portals.add(portal);
                intent.putExtra("PORTALS", portals);
                startActivity(intent);
            }
        }));
    }
}
