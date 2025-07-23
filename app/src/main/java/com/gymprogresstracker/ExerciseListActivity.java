package com.gymprogresstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseListActivity extends AppCompatActivity {

    private String muscleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        TextView title = findViewById(R.id.tvExerciseTitle);
        muscleGroup = getIntent().getStringExtra("muscleGroup");
        title.setText(muscleGroup + " Exercises");

        LinearLayout container = findViewById(R.id.exerciseContainer);

        // Dummy exercises based on muscle group
        if ("Chest".equals(muscleGroup)) {
            addExerciseButton(container, "Barbell Bench Press", "Barbell");
            addExerciseButton(container, "Cable Crossover", "Cable");
            addExerciseButton(container, "Dumbbell Press", "Dumbbell");
            addExerciseButton(container, "Machine Chest Fly", "Machine");
        }
        else if ("Biceps".equals(muscleGroup)) {
            addExerciseButton(container, "Dumbbell Curl", "Dumbbell");
            addExerciseButton(container, "Cable Curl", "Cable");
            addExerciseButton(container, "Barbell Curl", "Barbell");
        }
        // Add more groups similarly...
    }

    private void addExerciseButton(LinearLayout parent, String exerciseName, String type) {
        TextView exercise = new TextView(this);
        exercise.setText("• " + exerciseName);
        exercise.setTextSize(18);
        exercise.setTextColor(getResources().getColor(android.R.color.white));
        exercise.setPadding(16, 24, 16, 24);
        exercise.setBackgroundResource(R.drawable.exercise_item_background);

        exercise.setOnClickListener(view -> {
            Intent intent = new Intent(ExerciseListActivity.this, LogWorkoutActivity.class);
            intent.putExtra("exerciseName", exerciseName);
            intent.putExtra("exerciseType", type);
            startActivity(intent);
        });

        parent.addView(exercise);
    }
}
