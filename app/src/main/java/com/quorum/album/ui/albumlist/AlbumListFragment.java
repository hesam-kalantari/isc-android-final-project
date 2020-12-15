package com.quorum.album.ui.albumlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.quorum.album.R;
import com.quorum.album.databinding.FragmentAlbumListBinding;
import com.quorum.album.domain.model.Album;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AlbumListFragment extends Fragment
{

    private FragmentAlbumListBinding binding;
    private AlbumListViewModel albumListViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_list, container, false);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        this.albumListViewModel = new ViewModelProvider(this).get(AlbumListViewModel.class);

        AlbumAdapter albumAdapter = new AlbumAdapter(album -> {
            AlbumListFragmentDirections.ActionAlbumListFragmentToAlbumDetailFragment action =
                    AlbumListFragmentDirections.actionAlbumListFragmentToAlbumDetailFragment(album);
            Navigation.findNavController(requireActivity(), R.id.main_nav_host_fragment)
                    .navigate(action);
        });

        this.binding.recyclerViewAlbumList.setAdapter(albumAdapter);

        this.albumListViewModel.album().observe(getViewLifecycleOwner(), albumAdapter::submitList);

        return this.binding.getRoot();
    }
}
