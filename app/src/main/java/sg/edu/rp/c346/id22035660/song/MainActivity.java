package sg.edu.rp.c346.id22035660.song;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMovieTitle, etGenre, etYear;
    private Button btnInsert, btnShowList;
    private Spinner spinnerRatings;

    private DBHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovieTitle = findViewById(R.id.etMovie);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        btnInsert = findViewById(R.id.InsertBtn);
        btnShowList = findViewById(R.id.button2);
        spinnerRatings = findViewById(R.id.spinner);

        dbHelper = new DBHelper(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ratings_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRatings.setAdapter(adapter);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etMovieTitle.getText().toString();
                String genre = etGenre.getText().toString();
                String yearString = etYear.getText().toString().trim();

                if (title.isEmpty() || genre.isEmpty() || yearString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int year = Integer.parseInt(yearString);
                String rating = getSelectedRating();

                dbHelper.insertMovie(title, genre, year, rating);
                Toast.makeText(MainActivity.this, "Movie added to database.", Toast.LENGTH_SHORT).show();

                // Clearing the input after adding the movie
                etMovieTitle.setText("");
                etGenre.setText("");
                etYear.setText("");
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MovieListActivity.class);
                startActivity(intent);
            }
        });
    }

    private String getSelectedRating() {
        return spinnerRatings.getSelectedItem().toString();
    }
}

