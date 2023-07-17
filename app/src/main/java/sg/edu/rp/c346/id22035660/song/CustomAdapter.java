package sg.edu.rp.c346.id22035660.song;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

import sg.edu.rp.c346.id22035660.song.Song;


public class CustomAdapter extends ArrayAdapter<Song> {

    private Context context;
    private int resource;
    private ArrayList<Song> songList;
    public CustomAdapter(Context context, int resource, ArrayList<Song> songList) {
        super(context, resource, songList);
        this.context = context;
        this.resource = resource;
        this.songList = songList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);

            view = inflater.inflate(resource, null);
        }

        Song song = songList.get(position);
        TextView songTitle = view.findViewById(R.id.songTitle);
        TextView songYear = view.findViewById(R.id.yearsReleased);
        TextView songRating = view.findViewById(R.id.stars);
        TextView songSinger = view.findViewById(R.id.singers);
        songTitle.setText(song.getTitle());
        songYear.setText("Release Year: " + song.getYear());
        songRating.setText("Song Rating: " + song.getStars() + " Star/s");
        songSinger.setText("Singer: " + song.getSingers());
        return view;
    }
}

