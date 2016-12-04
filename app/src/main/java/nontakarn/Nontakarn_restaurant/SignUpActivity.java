package nontakarn.Nontakarn_restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import nontakarn.Nontakarn_restaurant.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class SignUpActivity extends AppCompatActivity {

    // explicit
    private EditText userEditText, passwordEditText, nameEditText;
    private String userString, passwordString, nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // bindwidget
        bindWidget();

    } //onCreate

    public void clickSignUp (View view){
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();
        nameString = nameEditText.getText().toString().trim();

        // check space
        if (userString.equals("") || passwordString.equals("") || nameString.equals("")){
            // have space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกให้ครบ");
        }else {
            // no space
            updateValueToServer();
        }

    } // clickSignUp

    private void updateValueToServer(){
        String strURL = "http://www.csclub.ssru.ac.th/s56122201013/android/php_add_user.php";
        OkHttpClient okHttpClient = new OkHttpClient();
        RequestBody requestBody = new FormEncodingBuilder()
                .add("isAdd","true")
                .add("User",userString)
                .add("Password",passwordString)
                .add("Name",nameString)
                .build();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(strURL).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    finish();
                }catch (Exception e){
                    Log.d("Restaurant", "error " + e.toString());
                }

            }
        });
    } // updateValueToServer

    private void bindWidget(){
        userEditText = (EditText) findViewById(R.id.signupuser);
        passwordEditText = (EditText) findViewById(R.id.signuppassword);
        nameEditText = (EditText) findViewById(R.id.signupname);
    } //bindWidget

}
