package com.quorum.album.ui.albumlist;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.quorum.album.domain.Result;
import com.quorum.album.domain.model.Album;
import com.quorum.album.repository.AlbumRepository;

import java.util.List;

public class AlbumListViewModel extends ViewModel
{

    private final AlbumRepository albumRepository;
    private MutableLiveData<List<Album>> _album = new MutableLiveData<>();
    private MutableLiveData<String> _message = new MutableLiveData<>();

    @ViewModelInject
    AlbumListViewModel(final AlbumRepository albumRepository)
    {
        this.albumRepository = albumRepository;
        this.getAlbums();
    }

    private void getAlbums() {
        this.albumRepository.getAllAlbums(new Result<List<Album>>()
        {
            @Override
            public void success(List<Album> result)
            {
                _album.setValue(result);
            }

            @Override
            public void error(String message)
            {
                _message.setValue(message);
            }
        });
    }

    public void onRefresh() {

    }

    LiveData<List<Album>> album() {
        return this._album;
    }

    LiveData<String> message() {
        return this._message;
    }
}
