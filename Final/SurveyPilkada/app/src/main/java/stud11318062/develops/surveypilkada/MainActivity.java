package stud11318062.develops.surveypilkada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stud11318062.develops.surveypilkada.Autentifikasi.LoginActivity;
import stud11318062.develops.surveypilkada.Survey.KumpulanSurvey;
import stud11318062.develops.surveypilkada.adapter.PengumumanAdapter;
import stud11318062.develops.surveypilkada.model.ResponsePengumuman;
import stud11318062.develops.surveypilkada.model.SemuapengumumanItem;
import stud11318062.develops.surveypilkada.util.Constant;
import stud11318062.develops.surveypilkada.util.RecyclerItemClickListener;
import stud11318062.develops.surveypilkada.util.SharedPrefManager;
import stud11318062.develops.surveypilkada.util.api.BaseApiService;
import stud11318062.develops.surveypilkada.util.api.UtilsApi;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btnLogout)
    Button btnLogout;
    @BindView(R.id.tvBelumMatkul)
    TextView tvBelumMatkul;
    @BindView(R.id.pengumuman)
    RecyclerView rvPengumuman;
    ProgressDialog loading;
    Button msurvey;

    SharedPrefManager sharedPrefManager;
    Context mContext;
    List<SemuapengumumanItem> semuapengumumanItemList = new ArrayList<>();
    PengumumanAdapter pengumumanAdapter;
    BaseApiService mApiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Survei Pilkada");

        ButterKnife.bind(this);
        mApiService = UtilsApi.getAPIService();
        mContext = this;

        pengumumanAdapter = new PengumumanAdapter(this, semuapengumumanItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        rvPengumuman.setLayoutManager(mLayoutManager);
        rvPengumuman.setItemAnimator(new DefaultItemAnimator());

        getDataPengumuman();


        sharedPrefManager = new SharedPrefManager(this);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
        msurvey = findViewById(R.id.survey);
        msurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, KumpulanSurvey.class);
                startActivity(intent);
                finish();
            }
        });


    }
    private void getDataPengumuman(){
        loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);

        mApiService.getSemuaPengumuman().enqueue(new Callback<ResponsePengumuman>() {
            @Override
            public void onResponse(Call<ResponsePengumuman> call, Response<ResponsePengumuman> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    if (response.body().isError()) {
                        tvBelumMatkul.setVisibility(View.VISIBLE);
                    } else {
                        final List<SemuapengumumanItem> semuapengumumanItems = response.body().getSemuamatkul();
                        rvPengumuman.setAdapter(new PengumumanAdapter(mContext, semuapengumumanItems));
                        pengumumanAdapter.notifyDataSetChanged();

                        initDataIntent(semuapengumumanItems);
                    }
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data mata kuliah", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponsePengumuman> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDataIntent(final List<SemuapengumumanItem> pengumumanList){
        rvPengumuman.addOnItemTouchListener(
                new RecyclerItemClickListener(mContext, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        String id = pengumumanList.get(position).getId();
                        String judul = pengumumanList.get(position).getJudul();
                        String isi = pengumumanList.get(position).getIsi();

                        Intent detailMatkul = new Intent(mContext, PengumumanDetailActivity.class);
                        detailMatkul.putExtra(Constant.KEY_ID_SURVEIPILKADA, id);
                        detailMatkul.putExtra(Constant.KEY_JUDUL, judul);
                        detailMatkul.putExtra(Constant.KEY_ISI, isi);
                        startActivity(detailMatkul);
                    }
                }));
    }



}
