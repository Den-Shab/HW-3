package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database;
import com.example.myapplication.R;
import com.example.myapplication.entities.Player;
import com.example.myapplication.repositories.PlayerDAO;

import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    private List<Player> players;

    private EditText editName;
    private EditText editNation;
    private EditText editClub;
    private Button findAll;
    private Button add;
    private Button findByName;
    private Button editByName;
    private Button delete;
    private Button findByNationality;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        config();
    }

    private void config() {
        PlayerDAO dao = Database.getDatabase(getApplicationContext()).playerDAO();

        editName = findViewById(R.id.editName);
        editNation = findViewById(R.id.editNation);
        editClub = findViewById(R.id.editClub);

        listView = findViewById(R.id.playersListView);

        add = findViewById(R.id.addPlayer);
        add.setOnClickListener(v -> {
            String nat = editNation.getText().toString();
            int nat_id = dao.findNation(nat);
            Player player = new Player(editName.getText().toString(), nat_id,
                    editClub.getText().toString());
            dao.insert(player);
        });


        findAll = findViewById(R.id.findAll);
        findAll.setOnClickListener(v -> {
            players = dao.findAll();
            if (players != null) {
                listView.setAdapter(new ArrayAdapter<>(PlayerActivity.this,
                        android.R.layout.simple_list_item_1, show(players)));
            }
        });

        findByName = findViewById(R.id.findPlayerByName);
        findByName.setOnClickListener(v -> {
            players = dao.findByName(editName.getText().toString());
            listView.setAdapter(new ArrayAdapter<>(PlayerActivity.this,
                    android.R.layout.simple_list_item_1, show(players)));
        });

        findByNationality = findViewById(R.id.findByNation);
        findByNationality.setOnClickListener(v -> {
            players = dao.findByNation(editNation.getText().toString());
            if (players != null) {
                listView.setAdapter(new ArrayAdapter<>(PlayerActivity.this,
                        android.R.layout.simple_list_item_1, show(players)));
            }
        });

        editByName = findViewById(R.id.editPlayersByName);
        editByName.setOnClickListener(v -> {
            String nat = editNation.getText().toString();
            int nat_id = dao.findNation(nat);
            Player player = dao.findByName(editName.getText().toString()).get(0);
            player.setClub(editClub.getText().toString());
            player.setNation(nat_id);
            dao.update(player);
        });

        delete = findViewById(R.id.deletePlayer);
        delete.setOnClickListener(v -> {
            Player player = dao.findByName(editName.getText().toString()).get(0);
            dao.delete(player);

        });
    }

    private <E> String[] show(List<E> array) {
        return array.stream().map(E::toString).toArray(String[]::new);
    }
}