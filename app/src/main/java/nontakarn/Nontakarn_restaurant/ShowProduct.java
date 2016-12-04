package nontakarn.Nontakarn_restaurant;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import nontakarn.Nontakarn_restaurant.R;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class ShowProduct extends AppCompatActivity {
    //Explicit
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_product);
        //Bind widget
        listView = (ListView) findViewById(R.id.listview);
        SynJSON sysJSON = new SynJSON();
        sysJSON.execute();



    }//onCreate

    //Create inner class
    public class SynJSON extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {
            try {
                String strURL ="http://csclub.ssru.ac.th/s56122201013/android/php_get_foodTABLE.php";
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(strURL).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();




            }catch (Exception e){
                Log.d("Restarant","doIn ==>"+ e.toString());
                return null;

            }

        }//doInBackground

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                Log.d("Restarant","Response ==>"+s);
                JSONArray jsonArray= new JSONArray(s);
                String[] iconString = new  String[jsonArray.length()];
                String[] titleString = new String[jsonArray.length()];
                String[] priceString = new  String[jsonArray.length()];

                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    iconString[i]= jsonObject.getString("Source");
                    titleString[i]=jsonObject.getString("Food");
                    priceString[i]=jsonObject.getString("Price");
                }// for
                ProductAdapter productAdapter = new ProductAdapter(ShowProduct.this,
                        iconString,titleString,priceString);
                listView.setAdapter(productAdapter);
            }catch (Exception e){
                Log.d("Restarant","onPost ==>" + e.toString());
            }
        }
    }//onPostExecute

}//mainclass
