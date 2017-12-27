package ro.devtalks.workshop.linearlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ro.devtalks.workshop.R;
import ro.devtalks.workshop.models.Workshop;

public class LinearLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        LinearLayout linearLayout = findViewById(R.id.linearLayout);

        List<Workshop> workshops = generateWorkshopData();

        for (Workshop workshop : workshops) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_workshop, linearLayout, false);

            TextView tvId = view.findViewById(R.id.tvId);
            TextView tvName = view.findViewById(R.id.tvName);
            TextView tvDescription = view.findViewById(R.id.tvDescription);

            tvId.setText(String.valueOf(workshop.getId()));
            tvName.setText(workshop.getName());
            tvDescription.setText(workshop.getDescription());

            linearLayout.addView(view);
        }
    }

    private List<Workshop> generateWorkshopData() {
        List<Workshop> workshops = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Workshop workshop = new Workshop(i, "Lists in Android", "Very interesting");
            workshops.add(workshop);
        }
        return workshops;
    }

}