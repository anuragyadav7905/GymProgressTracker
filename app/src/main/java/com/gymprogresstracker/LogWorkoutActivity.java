package com.gymprogresstracker;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class LogWorkoutActivity extends AppCompatActivity {

    private LinearLayout setContainer;
    private String exerciseName, exerciseType;
    private List<View> setViews = new ArrayList<>();
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_workout);

        exerciseName = getIntent().getStringExtra("exerciseName");
        exerciseType = getIntent().getStringExtra("exerciseType");

        tvTitle = findViewById(R.id.tvExerciseTitle);
        setContainer = findViewById(R.id.setContainer);
        tvTitle.setText(exerciseName);

        findViewById(R.id.btnAddSet).setOnClickListener(v -> addSetView());

        findViewById(R.id.btnLogWorkout).setOnClickListener(v -> {
            Toast.makeText(this, "Workout Logged!", Toast.LENGTH_SHORT).show();
            finish();
        });

        addSetView(); // Start with one set
    }

    private void addSetView() {
        View setView = getLayoutInflater().inflate(R.layout.item_set_input, null);

        // Show/hide input fields based on type
        if (!exerciseType.equals("Barbell")) {
            setView.findViewById(R.id.etLeft).setVisibility(View.GONE);
            setView.findViewById(R.id.etRight).setVisibility(View.GONE);
        }

        if (exerciseType.equals("Bodyweight")) {
            setView.findViewById(R.id.etRodOrWeight).setVisibility(View.GONE);
        }

        setContainer.addView(setView);
        setViews.add(setView);
    }
}
