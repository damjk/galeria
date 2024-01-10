package APIs.EmailAPI;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.*;
//import sun.plugin.javascript.navig.JSObject;

import java.util.ArrayList;

public interface MailjetEmailAPI {

    @Headers(
            {
                    "Content-Type: application/json",
                    "Authorization: Basic YTA3OTk5MzQzNGM3ZjBjMTUwZGI4MmI1ZDM2YWI2MzM6NjNhMzU3ZTM1MzYyMzE3MmNiZTVhMzQ0M2U1ODEyODU="
            }
    )


    @POST("send")
    Call<Void> enviarMail(@Body JsonObject Messages);

}
