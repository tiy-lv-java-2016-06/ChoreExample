package com.theironyard.choretesting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YouAreAwesome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_are_awesome);

        Toast.makeText(this, "KEY IS " + ChoreService.getCurrentToken(), Toast.LENGTH_LONG).show();

        try {
            ChoreService.getParentApi().getChildren().enqueue(new Callback<ArrayList<Child>>() {
                @Override
                public void onResponse(Call<ArrayList<Child>> call, Response<ArrayList<Child>> response) {

                }

                @Override
                public void onFailure(Call<ArrayList<Child>> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            startActivity(new Intent(YouAreAwesome.this, MainActivity.class));
        }
    }
}
