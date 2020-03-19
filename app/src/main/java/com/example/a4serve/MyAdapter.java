package com.example.a4serve;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter {
    Realm realm = Realm.getDefaultInstance();
    RealmResults<Events> realmList = realm.where(Events.class).findAll();
    private ArrayList<Events> eventslist = new ArrayList<Events>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events, viewGroup,false);
        eventslist.addAll(realmList);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {

        return eventslist.size();
    }

    public ArrayList<Events> getList() {
        return eventslist;
    }

    public void setList(ArrayList<Events> events) {
        eventslist = events;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mItemText;
        private ImageView itemImage;
        private Button button;

        public ListViewHolder(View itemView){
            super(itemView);
            mItemText = (TextView) itemView.findViewById(R.id.text_wi);
            itemImage = (ImageView) itemView.findViewById(R.id.im_view);
            button = (Button) itemView.findViewById(R.id.follow_button);
            itemView.setOnClickListener(this);
        }
        public void bindView(int position){

            final Events x = eventslist.get(position);
            x.storeEvents();
            mItemText.setText(x.name());
            itemImage.setImageResource(x.getImg());
            if(x.getFollow()) {
                button.setText("Unfollow");
            }
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    x.switchFollow();
                    if(x.getFollow()){
                        button.setText("Unfollow");
                    }
                    else{
                        button.setText("+Follow");
                    }
                    realm.commitTransaction();
                    realm.close();
                }
            });
        }
        public void onClick(View view){

        }
    }
}