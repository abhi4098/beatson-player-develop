package com.hotpepper.beatzon.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hotpepper.beatzon.R;
import com.hotpepper.beatzon.activities.interfaces.RecyclerViewOnClick;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Abhinandan on 3/5/17.
 */

public class ArtistMostPopularTracksAdapter extends RecyclerView.Adapter<ArtistMostPopularTracksAdapter.ViewHolder> {


    Context mContext;
    List<String> artistMostPopularTrackList;
    RecyclerViewOnClick recyclerViewOnClick;

    public ArtistMostPopularTracksAdapter(Context mContext, List<String> artistMostPopularTrackList, RecyclerViewOnClick recyclerViewOnClick) {
        this.mContext = mContext;
        this.artistMostPopularTrackList =artistMostPopularTrackList;
        this.recyclerViewOnClick = recyclerViewOnClick;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_artist_page_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.imgTrack.setBackgroundResource(R.drawable.play_icon);
        holder.imgTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewOnClick.onItemClick(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artistMostPopularTrackList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.imgTrack)
        ImageView imgTrack;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
