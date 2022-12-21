package com.example.odev7.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.odev7.R;
import com.example.odev7.data.entity.Yapilacaklar;
import com.example.odev7.databinding.CardTasarimBinding;
import com.example.odev7.ui.fragment.AnasayfaFragmentDirections;
import com.example.odev7.ui.viewmodel.AnasayfaViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class YapilacaklarAdapter extends RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Yapilacaklar> yapilacaklarList;
    private AnasayfaViewModel viewModel;

    public YapilacaklarAdapter(Context mContext, List<Yapilacaklar> yapilacaklarList, AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.yapilacaklarList = yapilacaklarList;
        this.viewModel = viewModel;
    }
    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;

        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //card tasarımın viewBinding kurulumu
        CardTasarimBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Yapilacaklar yapilacaklar = yapilacaklarList.get(position);
        CardTasarimBinding t = holder.binding;
        t.setYapilacakNesnesi(yapilacaklar);
        t.satirCard.setOnClickListener(v -> {
            AnasayfaFragmentDirections.DetayGecis gecis = AnasayfaFragmentDirections.detayGecis(yapilacaklar);
            Navigation.findNavController(v).navigate(gecis);
        });
        t.imageViewSil.setOnClickListener(v -> {
            Snackbar.make(v, yapilacaklar.getName()+" silinsin mi?", Snackbar.LENGTH_SHORT).setAction("EVET", v1 -> {
                viewModel.sil(yapilacaklar.getId());
            }).show();
        });
    }

    @Override
    public int getItemCount() {
        return yapilacaklarList.size();
    }
}
