package com.example.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Notifications extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notications);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.Messages) {
            Intent intent = new Intent(Notifications.this, Message.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.Notification) {
            Intent intent = new Intent(Notifications.this, Notifications.class);
            startActivity(intent);
        }
        else if (item.getItemId() == R.id.Post) {
            Intent intent = new Intent(Notifications.this, Post.class);
            startActivity(intent);}
        else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
