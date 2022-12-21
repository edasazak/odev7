package com.example.odev7.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.odev7.R;
import com.example.odev7.databinding.FragmentAnasayfaBinding;
import com.example.odev7.ui.adapter.YapilacaklarAdapter;
import com.example.odev7.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AnasayfaFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false);

        binding.setAnasayfaToolbarBaslik("Yapılacaklar");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarAnasayfa);


        viewModel.yapilacaklarList.observe(getViewLifecycleOwner(), yapilacaklarList -> {
            YapilacaklarAdapter adapter = new YapilacaklarAdapter(requireContext(), yapilacaklarList, viewModel);
            binding.setYapilacaklarAdapter(adapter);
        });

        binding.setAnasayfaFragment(this);

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu, menu);

                MenuItem item = menu.findItem(R.id.action_ara);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(AnasayfaFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }

    public void fabTikla(View v){
       Navigation.findNavController(v).navigate(R.id.kayitGecis);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.ara(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.ara(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.yapilacaklariYukle();
    }
}
