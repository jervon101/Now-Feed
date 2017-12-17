package nyc.c4q.nowfeed;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import nyc.c4q.nowfeed.API.INFO;
import nyc.c4q.nowfeed.network.Api;
import nyc.c4q.nowfeed.sports.model.Fullgameschedule;
import nyc.c4q.nowfeed.sports.model.Game;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    String encode;
    TextView textView;
//    Retrofit retrofit1;

    List<Fullgameschedule.GameEntry> mygame = new ArrayList<>();


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        CreateRetrofit();

        textView = (TextView) findViewById(R.id.text);

        DoStuff doStuff = new DoStuff();

        doStuff.execute();

        Log.e("Im Running", mygame.size()+"");

    }






    @RequiresApi(api = Build.VERSION_CODES.O)
    public void CreateRetrofit() {
        final String authHeader = Base64.encodeToString(INFO.getUserCredentials().getBytes(), Base64.NO_WRAP);


//        encode = Base64.encodeToString(step1.getBytes(), Base64.NO_WRAP);


//        OkHttpClient.Builder buidler = new OkHttpClient.Builder();
//
//        buidler.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//
//                Request request = chain.request();
//
//                Request.Builder newRequest = request.newBuilder()
//                        .header("Authorization", "Basic " + encode);
//                return chain.proceed(newRequest.build());
//            }
//        });

        String jay = "jervonc4q:whatidk2";
        String encoding = Base64.encodeToString(jay.getBytes(), Base64.NO_WRAP);
        String hello = "Basic " + encoding;


        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl(Api.FULL_GAME_API)
//                .client(buidler.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api user = retrofit1.create(Api.class);


        Call<Game> call = user.getGameSchedule(hello);
        Log.d("CreateRetrofit: ", call.request().toString());

        call.enqueue(new Callback<Game>() {
            @Override
            public void onResponse(Call<Game> call, Response<Game> response) {
                Game game = response.body();
                Log.e("Success", response.message());
//                Log.e("This is Game result", game.getFullgameschedule().getLastUpdatedOn());
            }

            @Override
            public void onFailure(Call<Game> call, Throwable t) {
                Log.e("Failure", t.getMessage());
                Log.e("Failure", t.getLocalizedMessage());

            }
        });


    }

    class DoStuff extends AsyncTask<Void, Void, Void> {






        @Override
        protected Void doInBackground(Void... voids) {

            try {
                URL url = new URL("https://api.mysportsfeeds.com/v1.1/pull/nba/2017-2018-regular/full_game_schedule.json");
                String user = "jervonc4q:whatidk2";
                String encoding = Base64.encodeToString(user.getBytes(), Base64.NO_WRAP);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
//                connection.setDoOutput(true);
                connection.setRequestProperty("Authorization", "Basic " + encoding);
                InputStream content = connection.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(content));
                String line;




                while ((line = in.readLine()) != null) {

                    JSONObject test = new JSONObject(line);

                    JSONArray game = test.getJSONObject("fullgameschedule").getJSONArray("gameentry");


                    for (int i = 0; i < game.length(); i++) {
                        Fullgameschedule.GameEntry member = new Fullgameschedule.GameEntry();

                        Fullgameschedule.GameEntry.AwayTeam away = new Fullgameschedule.GameEntry.AwayTeam();
                        Fullgameschedule.GameEntry.HomeTeam home = new Fullgameschedule.GameEntry.HomeTeam();

                        member.setId((String) game.getJSONObject(i).get("id"));
                        member.setScheduleStatus((String) game.getJSONObject(i).get("scheduleStatus"));
                        member.setDate((String) game.getJSONObject(i).get("date"));
                        member.setTime((String) game.getJSONObject(i).get("time"));

                            away.setID((String) game.getJSONObject(i).getJSONObject("awayTeam").get("ID"));
                            away.setCity((String) game.getJSONObject(i).getJSONObject("awayTeam").get("City"));
                            away.setName((String) game.getJSONObject(i).getJSONObject("awayTeam").get("Name"));
                            away.setAbbreviation((String) game.getJSONObject(i).getJSONObject("awayTeam").get("Abbreviation"));


                            home.setID((String) game.getJSONObject(i).getJSONObject("awayTeam").get("ID"));
                            home.setCity((String) game.getJSONObject(i).getJSONObject("awayTeam").get("City"));
                            home.setName((String) game.getJSONObject(i).getJSONObject("awayTeam").get("Name"));
                            home.setAbbreviation((String) game.getJSONObject(i).getJSONObject("awayTeam").get("Abbreviation"));


                        member.setLocation((String) game.getJSONObject(i).get("location"));

                        member.setAwayTeam(away);
                        member.setHomeTeam(home);

                        mygame.add(member);


                    }


                }



//                JSONObject test =  new JSONObject(line);
//                JSONArray game = test.getJSONObject("fullgameschedule").getJSONArray("gameentry");
//
//


            } catch (Exception e) {
                e.printStackTrace();
            }


            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


}


//    InputStream content = (InputStream) connection.getInputStream();
//    InputStream content = (InputStream) connection.getInputStream();









