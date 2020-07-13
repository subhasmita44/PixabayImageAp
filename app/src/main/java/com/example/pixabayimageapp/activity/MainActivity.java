package com.example.pixabayimageapp.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pixabayimageapp.R;
import com.example.pixabayimageapp.adapter.PhotoAdapter;
import com.example.pixabayimageapp.model.Photo;
import com.example.pixabayimageapp.viewmodel.PhotoViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.google.gson.reflect.TypeToken.get;

public class MainActivity extends AppCompatActivity {

    ArrayList<Photo> photoArrayList = new ArrayList<>();
    PhotoAdapter PhotoAdapter;
    RecyclerView rvPhto;
    PhotoViewModel photoViewModel;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.text);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");
        rvPhto = findViewById(R.id.rvPhoto);
        photoViewModel = ViewModelProviders.of(MainActivity.this).get(PhotoViewModel.class);
        photoViewModel.init();

        photoViewModel.getPhotoRepository().observe(this, newsResponse -> {

            List<Photo> newsArticles = newsResponse.getHits();
            photoArrayList.addAll(newsArticles);
            setupRecyclerView(photoArrayList);
        });
    }

    private void setupRecyclerView(ArrayList<Photo> photoArrayList1) {
        if (PhotoAdapter == null) {
            LinearLayoutManager manager = new LinearLayoutManager(this);
            rvPhto.setLayoutManager(manager);
            rvPhto.setHasFixedSize(true);
            PhotoAdapter photoAdapter= new PhotoAdapter(MainActivity.this, this.photoArrayList);
            rvPhto.setAdapter(photoAdapter);
            rvPhto.setItemAnimator(new DefaultItemAnimator());
            rvPhto.setNestedScrollingEnabled(true);

        } else {
            PhotoAdapter.notifyDataSetChanged();
        }
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                builder = new AlertDialog.Builder(this);
                 builder.setMessage("") .setTitle("");

                //Setting message manually and performing action on button click
                builder.setMessage("Do you want to close this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();


                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.cancel();

                            }
                        });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.setTitle("Close Application");
                alert.show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }


}