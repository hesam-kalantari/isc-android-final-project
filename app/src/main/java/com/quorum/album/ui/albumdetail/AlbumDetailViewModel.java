package com.quorum.album.ui.albumdetail;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.ViewModel;

import com.quorum.album.repository.AlbumRepository;

public class AlbumDetailViewModel extends ViewModel
{

    private final AlbumRepository albumRepository;

    @ViewModelInject
    AlbumDetailViewModel(final AlbumRepository albumRepository)
    {
        this.albumRepository = albumRepository;
    }
}
