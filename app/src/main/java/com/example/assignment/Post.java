package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Post extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        recyclerView = findViewById(R.id.recyclerViews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this,getMyList());
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Messages) {
            Intent intent = new Intent(Post.this, Message.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.Notification) {
            Intent intent = new Intent(Post.this, Notifications.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.Post) {
            Intent intent = new Intent(Post.this, Post.class);
            startActivity(intent);}
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model>models = new ArrayList<>();
        Model m = new Model();
        m.setContent("MYSTERY ABOUT DRAUPADI AND PANDAVAS DEATH: WHILE THEIR JOURNEY TO HEAVEN.");
        m.setImg(R.drawable.image1);
        models.add(m);

        m = new Model();
        m.setContent("WEARING PANNA (EMERALD) STONE CAN MAKE YOU THE HAPPIEST PERSON IN.");
        m.setImg(R.drawable.image2);
        models.add(m);

        m = new Model();
        m.setContent("THE 12 JYOTIRLINGAS OF INDIA: THE TEMPLES OF LORD SHIVA FOR.");
        m.setImg(R.drawable.image3);
        models.add(m);

        m = new Model();
        m.setContent("KASHI VISHWANATH TEMPLE – TOP 10 AMAZING FACTS OF KASHI VISHWANATH");
        m.setImg(R.drawable.image4);
        models.add(m);

        m = new Model();
        m.setContent("THESE ANCIENT SHIVA TEMPLES ON DIFFERENT LOCATIONS, LIE ON STRAIGHT LINE");
        m.setImg(R.drawable.image5);
        models.add(m);

        m = new Model();
        m.setContent("MAHAKALESHWAR JYOTIRLINGAM: LORD OF TIME AND DEATH");
        m.setImg(R.drawable.image6);
        models.add(m);
        return models;
    }
}
