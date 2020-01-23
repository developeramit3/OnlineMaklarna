package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinemaklarna.R;

public class Adapter_msg extends RecyclerView.Adapter<Adapter_msg.Adapter_recommendViewHolder> {

    Context mContext;

    public Adapter_msg(FragmentActivity activity) {

        this.mContext =  activity ;
    }

    @NonNull
    @Override
    public Adapter_recommendViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view  = LayoutInflater.from(mContext).inflate(R.layout.adapter_inboxmsg,null,false);
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

       Button Btn_bid ;

        public Adapter_recommendViewHolder(@NonNull View itemView) {
            super(itemView);

           // Btn_bid =  itemView.findViewById(R.id.Btn_bid);

        }
    }


}
