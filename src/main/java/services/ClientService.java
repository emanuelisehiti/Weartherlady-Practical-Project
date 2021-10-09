package services;

import beans.Root;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import constants.UrlConstants;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClientService {

     public Root getInformationFromWeather (String city) throws IOException {
          OkHttpClient mOkHpptClient = new OkHttpClient();
          mOkHpptClient.setConnectTimeout(1000, TimeUnit.MILLISECONDS);
          mOkHpptClient.setReadTimeout(1000,TimeUnit.MILLISECONDS);
          String getWeatherByCity = UrlConstants.OpenWeatherUrl + "?q=" +city+ "&appid=" + UrlConstants.OpenWeatherApiKey;
          Request request = new Request.Builder()
                  .url(getWeatherByCity)
                  .get()
                  .build();
          Response response = mOkHpptClient.newCall(request).execute();
          System.out.println(response);

          if(response.isSuccessful()){
               ObjectMapper objectMapper = new ObjectMapper();
               String res = response.body().string();
               return objectMapper.readValue(res,Root.class);
          }
          else return new Root();
     }
}
