package com.quorum.album.ui.albumdetail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.RequestManager;
import com.quorum.album.R;
import com.quorum.album.databinding.FragmentAlbumDetailBinding;
import com.quorum.album.domain.model.Album;
import com.quorum.album.ui.albumlist.AlbumListFragment;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class AlbumDetailFragment extends Fragment
{

    private FragmentAlbumDetailBinding binding;
    private AlbumDetailViewModel albumDetailViewModel;

    private Album album;

    @Inject
    RequestManager glideInstance;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        this.binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_detail, container, false);
        this.binding.setLifecycleOwner(getViewLifecycleOwner());
        this.album = AlbumDetailFragmentArgs.fromBundle(requireArguments()).getSelectedAlbum();
        this.albumDetailViewModel = new ViewModelProvider(this).get(AlbumDetailViewModel.class);

        this.binding.textName.setText(this.album.getName());
        this.binding.textArtist.setText(this.album.getArtist());
        this.binding.textPublishDate.setText(this.album.getPublishDate());

        glideInstance.load(this.album.getImageUrl()).into(this.binding.imageAlbum);

        return this.binding.getRoot();
    }
}
