package com.example.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.myapplication.Database;
import com.example.myapplication.R;
import com.example.myapplication.entities.Club;
import com.example.myapplication.repositories.ClubDAO;

import java.util.List;

public class ClubActivity extends AppCompatActivity {

    private List<Club> clubs;

    private EditText editName;
    private EditText editLocation;
    private Button findAll;
    private Button add;
    private Button findByName;
    private Button editByName;
    private Button delete;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);
        config();
    }

    private void config() {
        ClubDAO dao = Database.getDatabase(getApplicationContext()).clubDAO();

        editName = findViewById(R.id.editClubName);
        editLocation = findViewById(R.id.editLocation);

        listView = findViewById(R.id.clubListView);

        add = findViewById(R.id.addClub);
        add.setOnClickListener(v -> {
            Club club = new Club(editName.getText().toString(), editLocation.getText().toString());
            dao.insert(club);
        });


        findAll = findViewById(R.id.findAllClubs);
        findAll.setOnClickListener(v -> {
            clubs = dao.findAll();
            if (clubs != null) {
                listView.setAdapter(new ArrayAdapter<>(ClubActivity.this,
                        android.R.layout.simple_list_item_1, show(clubs)));
            }
        });

        findByName = findViewById(R.id.findClubByName);
        findByName.setOnClickListener(v -> {
            clubs = dao.findByName(editName.getText().toString());
            listView.setAdapter(new ArrayAdapter<>(ClubActivity.this,
                    android.R.layout.simple_list_item_1, show(clubs)));
        });

        editByName = findViewById(R.id.editClubByName);
        editByName.setOnClickListener(v -> {
            Club club = dao.findByName(editName.getText().toString()).get(0);
            club.setLocation(editLocation.getText().toString());
            dao.update(club);
        });

        delete = findViewById(R.id.deleteClub);
        delete.setOnClickListener(v -> {
            Club club = dao.findByName(editName.getText().toString()).get(0);
            dao.delete(club);

        });
    }

    private <E> String[] show(List<E> array) {
        return array.stream().map(E::toString).toArray(String[]::new);
    }
}