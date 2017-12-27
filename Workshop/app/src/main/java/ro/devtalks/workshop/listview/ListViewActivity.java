package ro.devtalks.workshop.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ro.devtalks.workshop.R;
import ro.devtalks.workshop.models.Workshop;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        WorkshopListAdapter adapter = new WorkshopListAdapter();
        adapter.setWorkshops(generateWorkshopData());

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
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