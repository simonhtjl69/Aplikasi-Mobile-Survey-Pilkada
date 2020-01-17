package stud11318062.develops.surveypilkada.util.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import stud11318062.develops.surveypilkada.model.ResponsePengumuman;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("login.php")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);
//    @FormUrlEncoded
//    @POST("register.php")
//    Call<ResponseBody> registerRequest(@Field("nama") String nama,
//                                       @Field("email") String email,
//                                       @Field("password") String password);
    @GET("pengumuman")
    Call<ResponsePengumuman> getSemuaPengumuman();

    @FormUrlEncoded
    @POST("pengumuman")
    Call<ResponseBody> simpanRosterRequest(@Field("judul") String judul,
                                           @Field("isi") String isi);

    @DELETE("pengumuman/{idpengumuman}")
    Call<ResponseBody> deteleMatkul(@Path("idpengumuman") String idpengumuman);




//
//
//    @GET("tugas")
//    Call<ResponseTugas> getSemuaTugas();
//
//    @FormUrlEncoded
//    @POST("tugas")
//    Call<ResponseBody> simpanTugasRequest(@Field("matkul") String matkul,
//                                          @Field("tugas") String tugas);
//
//    @DELETE("tugas/{idtugas}")
//    Call<ResponseBody> deteleTugas(@Path("idmatkul") String idmatkul);

}
