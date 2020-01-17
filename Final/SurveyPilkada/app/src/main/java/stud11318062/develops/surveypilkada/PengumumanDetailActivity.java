package stud11318062.develops.surveypilkada;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import stud11318062.develops.surveypilkada.util.Constant;
import stud11318062.develops.surveypilkada.util.api.BaseApiService;
import stud11318062.develops.surveypilkada.util.api.UtilsApi;

public class PengumumanDetailActivity extends AppCompatActivity {
    @BindView(R.id.tvJudul)
    TextView tvJudul;
    @BindView(R.id.tvIsi)
    TextView tvIsi;
    ProgressDialog loading;

    String mId;
    String mJudul;
    String mIsi;

    Context mContext;
    BaseApiService mApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengumuman_detail);
        getSupportActionBar().setTitle("Pengumuman Detail");
        getSupportActionBar().hide();
        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        Intent intent = getIntent();
        mId = intent.getStringExtra(Constant.KEY_ID_SURVEIPILKADA);
        mJudul = intent.getStringExtra(Constant.KEY_JUDUL);
        mIsi = intent.getStringExtra(Constant.KEY_ISI);

        tvJudul.setText(mJudul);
        tvIsi.setText(mIsi);

    }

}
