package bt.bpc.retrofitpostexample;

import okhttp3.ResponseBody;
import retrofit2.Call;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("/RetrofitExample/insert.php")
    Call<ResponseBody> insertUser
    (
            @Field("name") String name,
            @Field("username") String username,
            @Field("password") String password,
            @Field("email") String email
    );

}
