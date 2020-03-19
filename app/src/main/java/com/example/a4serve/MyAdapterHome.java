package com.example.a4serve;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyAdapterHome extends RecyclerView.Adapter{
    private Realm realm = Realm.getDefaultInstance();
    private RealmResults<Events> realmList = realm.where(Events.class).findAll();
    private ArrayList<Events> eventsList = new ArrayList<Events>();
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events, viewGroup,false);
        eventsList.addAll(realmList);
        return new MyAdapterHome.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyAdapterHome.ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return realmList.size();
    }

    public ArrayList<Events> getList() {
        return eventsList;
    }

    public void setList(ArrayList<Events> events) {
        eventsList = events;
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

            final Events x = realmList.get(position);
            if(x.getFollow()) {
                mItemText.setText(x.name());
                itemImage.setImageResource(x.getImg());
                button.setText("Unfollow");
            }
            else{
                itemView.setVisibility(View.GONE);
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
                realm.insertOrUpdate(x);
                realm.close();
                }
            });
        }
        public void onClick(View view){

        }
    }
}
