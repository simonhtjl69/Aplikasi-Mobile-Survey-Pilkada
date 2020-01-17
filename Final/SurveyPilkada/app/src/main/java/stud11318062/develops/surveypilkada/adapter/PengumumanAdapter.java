package stud11318062.develops.surveypilkada.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import stud11318062.develops.surveypilkada.R;
import stud11318062.develops.surveypilkada.model.SemuapengumumanItem;

public class PengumumanAdapter extends RecyclerView.Adapter<PengumumanAdapter.PengumumanHolder> {
    Context mContext;
    List<SemuapengumumanItem> semuapengumumanItemList;


    public PengumumanAdapter(Context context, List<SemuapengumumanItem> pengumumanList) {
        this.mContext = context;
        semuapengumumanItemList = pengumumanList;
    }

    @Override
    public PengumumanAdapter.PengumumanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pengumuman, parent, false);
        return new PengumumanHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PengumumanAdapter.PengumumanHolder holder, int position) {
        final SemuapengumumanItem semuarosterItem = semuapengumumanItemList.get(position);
        holder.tvHari.setText(semuarosterItem.getJudul());
        holder.tvNamaMatkul.setText(semuarosterItem.getIsi());

        String hari = semuarosterItem.getJudul();
        String firstCharHari = hari.substring(0,1);
    }

    @Override
    public int getItemCount() {
        return semuapengumumanItemList.size();
    }

    public class PengumumanHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tvJudul)
        TextView tvHari;
        @BindView(R.id.tvIsi)
        TextView tvNamaMatkul;

        public PengumumanHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }

}
