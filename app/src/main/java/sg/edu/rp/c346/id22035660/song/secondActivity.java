package sg.edu.rp.c346.id22035660.song;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class secondActivity extends AppCompatActivity {
    Button btnShowSongs;
    ListView listview;
    DBHelper dbHelper;
    ArrayAdapter<Song> arrayAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnShowSongs = findViewById(R.id.btnShowSongs);
        listview = findViewById(R.id.lv);

        dbHelper = new DBHelper(this);

        ArrayList<Song> songArrayList = dbHelper.getAllSongs();
        arrayAdapter = new CustomAdapter(this, R.layout.row, songArrayList);
        listview.setAdapter(arrayAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView <?> parent, View view,int position, long id){
                Song clickedSong = (Song) parent.getItemAtPosition(position);
                Intent intent = new Intent(secondActivity.this,
                        ThirdActivity.class);
                intent.putExtra("song", clickedSong);
                startActivity(intent);
            }
        });

        btnShowSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Song> fivestar = dbHelper.getSongWith5Star();
                arrayAdapter.clear();
                arrayAdapter.addAll(fivestar);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
        protected void onResume() {
            super.onResume();
            ArrayList<Song> songList = dbHelper.getAllSongs();
            arrayAdapter.clear();
            arrayAdapter.addAll(songList);
            arrayAdapter.notifyDataSetChanged();

        }
    }



