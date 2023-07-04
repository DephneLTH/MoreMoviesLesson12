package sg.edu.rp.c346.id22035660.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etSongTitle, etSingers, etYear;
    private Button btnInsert, btnShowList;
    private RadioButton rb1, rb2, rb3, rb4, rb5;

    private DBHelper dbHelper;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.button);
        btnShowList = findViewById(R.id.button2);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);
        rb5 = findViewById(R.id.radioButton5);
        listView = findViewById(R.id.lv);

        dbHelper = new DBHelper(this);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etSongTitle.getText().toString();
                String singers = etSingers.getText().toString();
                String yearString = etYear.getText().toString().trim();

                int year = Integer.parseInt(yearString);
                int stars = getSelectedStars();

                dbHelper.insertSong(title, singers, year, stars);
                Toast.makeText(MainActivity.this, "Song saved successfully", Toast.LENGTH_SHORT).show();

                // Clearing the input after saving the song
                etSongTitle.setText("");
                etSingers.setText("");
                etYear.setText("");
                rb1.setChecked(true); // Reset the radio button selection
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> songList = dbHelper.getAllSongs();
                ArrayAdapter<Song> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, songList);
                listView.setAdapter(adapter);
            }
        });
    }



    private int getSelectedStars() {
        if (rb1.isChecked()) {
            return 1;
        } else if (rb2.isChecked()) {
            return 2;
        } else if (rb3.isChecked()) {
            return 3;
        } else if (rb4.isChecked()) {
            return 4;
        } else if (rb5.isChecked()) {
            return 5;
        }
        return 0;
    }



}
