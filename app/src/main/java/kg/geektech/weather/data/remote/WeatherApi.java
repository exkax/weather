package kg.geektech.weather.data.remote;


import kg.geektech.weather.data.models.MainResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<MainResponse> getApi(
            @Query("q") String city,
            @Query("appid") String appId,
            @Query("units") String units
    );

}
