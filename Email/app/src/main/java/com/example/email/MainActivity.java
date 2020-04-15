package com.example.email;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    List<ItemModel> listItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listItems= new ArrayList<>();
        listItems.add(new ItemModel("Instructables","12:59 PM", "Modern Ceiling LED Lamp", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Anstructables", "12:59 PM", "DropArt - Precision Two Drop Photographic Collider", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Onstructables", "12:59 PM", "Easy Tensegrity Sculpture: Floating Table Top", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Unstructables",  "12:59 PM", "Distance Learning With Tinkercad Contest ", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Enstructables", "12:59 PM", "How to 3D Print a Surfboard", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Dnstructables",  "12:59 PM", "Modern Ceiling LED Lamp", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        listItems.add(new ItemModel("Pnstructables", "12:59 PM", "Easy Tensegrity Sculpture: Floating Table Top", "Musical Instruments to Make at Home, Origami Infinite Supernova", R.drawable.ic_star_empty));
        ItemAdapter adapter = new ItemAdapter(listItems);
        ListView listView= findViewById(R.id.list_email);
        listView.setAdapter(adapter);
    }

}
