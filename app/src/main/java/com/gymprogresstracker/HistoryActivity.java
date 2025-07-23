package com.gymprogresstracker;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;



import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private Spinner spinner;
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        spinner = findViewById(R.id.exerciseSpinner);
        chart = findViewById(R.id.lineChart);

        // Dummy list of exercises
        List<String> exercises = new ArrayList<>();
        exercises.add("Barbell Bench Press");
        exercises.add("Dumbbell Curl");
        exercises.add("Cable Row");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, exercises);
        spinner.setAdapter(adapter);

        // Dummy chart data (replace with Firebase data later)
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 40));
        entries.add(new Entry(2, 45));
        entries.add(new Entry(3, 50));
        entries.add(new Entry(4, 52));

        LineDataSet dataSet = new LineDataSet(entries, "Weight Lifted (kg)");
        dataSet.setColor(getResources().getColor(android.R.color.holo_blue_light));
        dataSet.setValueTextColor(getResources().getColor(android.R.color.white));

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.getDescription().setEnabled(false);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getAxisLeft().setTextColor(getResources().getColor(android.R.color.white));
        chart.getXAxis().setTextColor(getResources().getColor(android.R.color.white));
        chart.getAxisRight().setEnabled(false);
        chart.invalidate();
    }
}
