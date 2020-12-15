package com.quorum.album.ui.albumlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.quorum.album.databinding.CardAlbumItemBinding;
import com.quorum.album.domain.model.Album;

public class AlbumAdapter extends ListAdapter<Album, RecyclerView.ViewHolder>
{

    private final AlbumListener listener;

    public AlbumAdapter(final AlbumListener listener) {
        super(new AlbumItemDiffCallback());
        this.listener = listener;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return AlbumViewHolder.from(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        ((AlbumViewHolder) holder).bind(this.getItem(position), this.listener);
    }

    static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private final CardAlbumItemBinding binding;

        public AlbumViewHolder(CardAlbumItemBinding binding)
        {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(final Album album, final AlbumListener listener) {
            this.binding.setAlbum(album);
            this.binding.setListener(listener);
            this.binding.executePendingBindings();
        }

        public static AlbumViewHolder from(final ViewGroup parent) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            CardAlbumItemBinding binding = CardAlbumItemBinding.inflate(layoutInflater, parent, false);
            return new AlbumViewHolder(binding);
        }
    }

    static class AlbumItemDiffCallback extends DiffUtil.ItemCallback<Album> {

        @Override
        public boolean areItemsTheSame(@NonNull Album oldItem, @NonNull Album newItem)
        {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Album oldItem, @NonNull Album newItem)
        {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    public interface AlbumListener {
        void onChooseAlbum(final Album album);
    }
}
