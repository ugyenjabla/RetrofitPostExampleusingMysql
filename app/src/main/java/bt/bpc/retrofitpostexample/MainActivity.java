package bt.bpc.retrofitpostexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {
    //Declaring views
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;

    private Button buttonRegister;

    //This is our root url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        buttonRegister = (Button) findViewById(R.id.buttonRegister);

        //Adding listener to button
        buttonRegister.setOnClickListener(this);
    }



    private  void insertUser(){




        //Defining the method insertuser of our interface


                //Passing the values by getting it from editTexts
                 String name = editTextName.getText().toString().trim();
               String username = editTextUsername.getText().toString().trim();
               String password = editTextPassword.getText().toString().trim();
               String email =  editTextEmail.getText().toString().trim();

        if (name.isEmpty()) {
            editTextName.setError("name is required");
            editTextName.requestFocus();
        }
        if (username.isEmpty()){
            editTextUsername.setError("username is required");
            editTextUsername.requestFocus();
        }
        if (password.isEmpty()){
            editTextPassword.setError("password is required");
            editTextPassword.requestFocus();
        }
        if (email.isEmpty()){
            editTextEmail.setError("email is required");
            editTextEmail.requestFocus();

        }

        Call<ResponseBody> call = RetrofitClient.getInstance().getApi().insertUser(name,username, password,email);
call.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        String s = null;
        try {
            s = response.body().string();
            Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
    }
});


    }



    @Override
    public void onClick(View v) {
        //Calling insertUser on button click
        insertUser();

    }
}
