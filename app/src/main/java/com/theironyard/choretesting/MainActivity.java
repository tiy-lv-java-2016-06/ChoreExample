package com.theironyard.choretesting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.theironyard.choretesting.command.TokenCommand;
import com.theironyard.choretesting.command.UserCommand;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity{
    public static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.usernameTextField)
    EditText mUsernameTextField;

    @Bind(R.id.passwordTextField)
    EditText mPasswordTextField;

    @Bind(R.id.loginButton)
    Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.loginButton)
    public void onClick(View view) {
        Snackbar.make(view, "You clicked login!", Snackbar.LENGTH_LONG).show();

        ChoreService choreService = new ChoreService();
        String username = mUsernameTextField.getText().toString();
        String password = mPasswordTextField.getText().toString();
        UserCommand userCommand = new UserCommand(username, password);

        choreService.getLoginApi().getParentToken(userCommand)
                .enqueue(new Callback<TokenCommand>() {
            @Override
            public void onResponse(retrofit2.Call<TokenCommand> call, retrofit2.Response<TokenCommand> response) {
                if(response.code() == 200){
                    TokenCommand tokenCommand = response.body();
                    ChoreService.saveToken(tokenCommand.getToken());
                    startActivity(new Intent(MainActivity.this, YouAreAwesome.class));
                }
                else{
                    Snackbar.make(mLoginButton, "Unable to Login..Try again", Snackbar.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<TokenCommand> call, Throwable t) {
                Snackbar.make(mLoginButton, "System Failed..Try again", Snackbar.LENGTH_LONG);
                Log.e(TAG, "API is throwing errors", t);
            }
        });


    }
}
