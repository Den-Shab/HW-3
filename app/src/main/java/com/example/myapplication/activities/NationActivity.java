package com.example.myapplication.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Database;
import com.example.myapplication.R;
import com.example.myapplication.entities.Nation;
import com.example.myapplication.repositories.NationDAO;

import java.util.List;

public class NationActivity extends AppCompatActivity {

    private List<Nation> nations;

    private EditText editName;
    private Button findAll;
    private Button add;
    private Button findByName;
    private Button editByName;
    private Button delete;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nation);
        config();
    }

    private void config() {
        NationDAO dao = Database.getDatabase(getApplicationContext()).nationDAO();

        editName = findViewById(R.id.editName);

        listView = findViewById(R.id.nationsListView);

        add = findViewById(R.id.addNation);
        add.setOnClickListener(v -> {
            Nation nation = new Nation(editName.getText().toString());
            System.out.println(nation);
            dao.insert(nation);
        });


        findAll = findViewById(R.id.findAllNations);
        findAll.setOnClickListener(v -> {
            nations = dao.findAll();
            if (nations != null) {
                listView.setAdapter(new ArrayAdapter<>(NationActivity.this,
                        android.R.layout.simple_list_item_1, show(nations)));
            }
        });

        findByName = findViewById(R.id.findNationByName);
        findByName.setOnClickListener(v -> {
            nations = dao.findByName(editName.getText().toString());
            listView.setAdapter(new ArrayAdapter<>(NationActivity.this,
                    android.R.layout.simple_list_item_1, show(nations)));
        });

        delete = findViewById(R.id.deleteNation);
        delete.setOnClickListener(v -> {
            Nation nation = dao.findByName(editName.getText().toString()).get(0);
            dao.delete(nation);
        });
    }

    private <E> String[] show(List<E> array) {
        return array.stream().map(E::toString).toArray(String[]::new);
    }


}