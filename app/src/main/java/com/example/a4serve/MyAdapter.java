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

import java.util.List;

import io.realm.Realm;

public class MyAdapter extends RecyclerView.Adapter {
    EventsList eventsList = new EventsList(10);
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.events, viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ListViewHolder) viewHolder).bindView(i);
    }

    @Override
    public int getItemCount() {

        return EventsList.getList().length;
    }

    public Events[] getList() {
        return EventsList.getList();
    }

    public void setList(EventsList events) {
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
            final Events x = EventsList.getList()[position];
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
                    button.setText("Hehe");
                    realm.commitTransaction();
                    realm.close();
                }
            });
        }

        public void onClick(View view){

        }
    }
}
