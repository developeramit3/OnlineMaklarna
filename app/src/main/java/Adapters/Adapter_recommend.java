package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemaklarna.R;

import Activity.Activity_loadfrag;

public class Adapter_recommend extends RecyclerView.Adapter<Adapter_recommend.Adapter_recommendViewHolder> {

    Context mContext;

    public Adapter_recommend(FragmentActivity activity) {

        this.mContext =  activity ;
    }

    @NonNull
    @Override
    public Adapter_recommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.adapter_recommand,null,false);
        return new Adapter_recommendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter_recommendViewHolder holder, final int i) {

    }

    @Override
    public int getItemCount() {

        return 10;
    }

    public class Adapter_recommendViewHolder extends RecyclerView.ViewHolder{

       ImageView recomnd_img ;

        public Adapter_recommendViewHolder(@NonNull View itemView) {
            super(itemView);

            recomnd_img =  itemView.findViewById(R.id.recomnd_img);
            recomnd_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mContext.startActivity(new Intent(mContext, Activity_loadfrag.class).putExtra("type","one"));



                }
            });

        }
    }


}
