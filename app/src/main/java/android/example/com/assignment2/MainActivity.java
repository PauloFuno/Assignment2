package android.example.com.assignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpinner;
    private ImageView mImage;
    private TextView mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = findViewById(R.id.movies_spinner);
        mDescription = findViewById(R.id.textView);
        mImage = findViewById(R.id.imageView);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] movies = getResources().getStringArray(R.array.movies);
                String[] movieP = getResources().getStringArray(R.array.movieP);/////////////////
                updateTheView(movieP[position]);/////////////////////////////////////////////////////

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });


        int id = getResources().getIdentifier("the_god_father", "drawable", getPackageName());

    }

    private void updateTheView(String name) {
        int idDrawable = getResources().getIdentifier(name, "drawable", getPackageName());
        int idRaw = getResources().getIdentifier(name, "raw", getPackageName());
        Scanner in = new Scanner(getResources().openRawResource(idRaw));
        StringBuilder build = new StringBuilder();
        while (in.hasNext()) {
            build.append(in.nextLine());
        }
        this.mImage.setImageResource(idDrawable);
        this.mDescription.setText(build.toString());


    }
}
