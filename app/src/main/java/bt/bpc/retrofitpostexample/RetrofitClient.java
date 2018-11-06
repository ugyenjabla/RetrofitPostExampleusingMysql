package bt.bpc.retrofitpostexample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String ROOT_URL = "http://172.16.50.20/";
private static RetrofitClient mInstance;
private Retrofit retrofit;
private RetrofitClient() {
    retrofit = new Retrofit.Builder()
            .baseUrl(ROOT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}

public static synchronized RetrofitClient getInstance(){
    if (mInstance == null) {
        mInstance = new RetrofitClient();
    }
    return mInstance;
}
public RegisterAPI getApi(){
    return retrofit.create(RegisterAPI.class);

}

}
