package com.gymprogresstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MuscleGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_group);

        setupButton(R.id.btnChest, "Chest");
        setupButton(R.id.btnBiceps, "Biceps");
        setupButton(R.id.btnTriceps, "Triceps");
        setupButton(R.id.btnShoulders, "Shoulders");
        setupButton(R.id.btnBack, "Back");
        setupButton(R.id.btnLegs, "Legs");
    }

    private void setupButton(int buttonId, String groupName) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MuscleGroupActivity.this, ExerciseListActivity.class);
            intent.putExtra("muscleGroup", groupName);
            startActivity(intent);
        });
    }
}
