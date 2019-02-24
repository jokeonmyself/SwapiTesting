package com.example.testingswapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PersonActivity extends AppCompatActivity {

    public static final String PERSON_LIST = "person_number";

    ListView filmsListView;
    ListView speciesListView;
    ListView vehiclesListView;
    ListView starshipsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        filmsListView = (ListView) findViewById(R.id.films_list_view);
        speciesListView = (ListView) findViewById(R.id.species_list_view);
        vehiclesListView = (ListView) findViewById(R.id.vehicles_list_view);
        starshipsListView = (ListView) findViewById(R.id.starships_list_view);

        View filmsHeaderView = getLayoutInflater().inflate(R.layout.search_listview, null);
        TextView filmHeader = (TextView) filmsHeaderView.findViewById(R.id.textView);
        filmHeader.setText("films: ");
        filmsListView.addHeaderView(filmsHeaderView);
        filmsListView.setClickable(false);

        View speciesHeaderView = getLayoutInflater().inflate(R.layout.search_listview, null);
        TextView speciesHeader = (TextView) speciesHeaderView.findViewById(R.id.textView);
        speciesHeader.setText("Species: ");
        speciesListView.addHeaderView(speciesHeaderView);

        View vehiclesHeaderView = getLayoutInflater().inflate(R.layout.search_listview, null);
        TextView vehiclesHeader = (TextView) vehiclesHeaderView.findViewById(R.id.textView);
        vehiclesHeader.setText("Vehicles: ");
        vehiclesListView.addHeaderView(vehiclesHeaderView);

        View starshipsHeaderView = getLayoutInflater().inflate(R.layout.search_listview, null);
        TextView starshipsHeader = (TextView) starshipsHeaderView.findViewById(R.id.textView);
        starshipsHeader.setText("Starships: ");
        starshipsListView.addHeaderView(starshipsHeaderView);

        Person person = (Person) getIntent().getParcelableExtra(PERSON_LIST);

        String nameText = person.getName();
        setTitle(nameText);
        String heightText = person.getHeight();
        String massText = person.getMass();
        String hairColorText = person.getHairColor();
        String skinColorText = person.getSkinColor();
        String eyeColorText = person.getEyeColor();
        String birthYearText = person.getBirthYear();
        String genderText = person.getGender();
        String homeworldText = person.getHomeworld();
        String createdText = person.getCreated();
        String editedText = person.getEdited();
        String urlText = person.getUrl();
        List<String> filmsText = person.getFilms();
        List<String> speciesText = person.getSpecies();
        List<String> vehiclesText = person.getVehicles();
        List<String> starshipsText = person.getStarships();

        ArrayAdapter<String> filmsAdapter = new ArrayAdapter<String>(this,
               R.layout.listview_simple, filmsText);
        filmsListView.setAdapter(filmsAdapter);


        ArrayAdapter<String> speciesAdapter = new ArrayAdapter<String>(this,
                R.layout.listview_simple, speciesText);
        speciesListView.setAdapter(speciesAdapter);


        ArrayAdapter<String> vehiclesAdapter = new ArrayAdapter<String>(this,
                R.layout.listview_simple, vehiclesText);
        vehiclesListView.setAdapter(vehiclesAdapter);


        ArrayAdapter<String> starshipsAdapter = new ArrayAdapter<String>(this,
                R.layout.listview_simple, starshipsText);
        starshipsListView.setAdapter(starshipsAdapter);


        TextView name_TextView = (TextView) findViewById(R.id.name);
        TextView height_TextView = (TextView) findViewById(R.id.height);
        TextView mass_TextView = (TextView) findViewById(R.id.mass);
        TextView hairColor_TextView = (TextView) findViewById(R.id.hair_color);
        TextView skinColor_TextView = (TextView) findViewById(R.id.skin_color);
        TextView eyeColor_TextView = (TextView) findViewById(R.id.eye_color);
        TextView birthYear_TextView = (TextView) findViewById(R.id.birth_year);
        TextView gender_TextView = (TextView) findViewById(R.id.gender);
        TextView homeworld_TextView = (TextView) findViewById(R.id.homeworld);
        TextView created_TextView = (TextView) findViewById(R.id.created);
        TextView edited_TextView = (TextView) findViewById(R.id.edited);
        TextView url_TextView = (TextView) findViewById(R.id.url);


        name_TextView.setText("Name: " + nameText);
        height_TextView.setText("Height: " + heightText);
        mass_TextView.setText("Mass: " + massText);
        hairColor_TextView.setText("Hair color: " + hairColorText);
        skinColor_TextView.setText("Skin color: " + skinColorText);
        eyeColor_TextView.setText("Eye color: " + eyeColorText);
        birthYear_TextView.setText("Birth year: " +birthYearText);
        gender_TextView.setText("Gender: " + genderText);
        homeworld_TextView.setText("Homeworld: " + homeworldText);
        created_TextView.setText("Created: " + createdText);
        edited_TextView.setText("Edited: " + editedText);
        url_TextView.setText("Url: " + urlText);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
