package jos.huuduan.hinhnenchuagiesu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jos.huuduan.hinhnenchuagiesu.R;
import jos.huuduan.hinhnenchuagiesu.my_interface.IClickItemUserListener;
import jos.huuduan.hinhnenchuagiesu.user.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHoder>{

    private List<User> mListUser;
    private IClickItemUserListener iClickItemUserListener;

    //public UserAdapter(Context mContext) {
    // this.mContext = mContext;
    //}

    public UserAdapter(List<User> list,IClickItemUserListener listener) {
        this.mListUser = list ;
        this.iClickItemUserListener = listener;
    }

    public  void  setData(List<User> list){
        this.mListUser = list ;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);


        return new UserViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoder holder, int position) {
            //Glide.with(context).load(arrayList.get(position)).into(holder.imageView);
        final User user = mListUser.get(position);
        if (user==null){
            return;
        }

       holder.imgUser.setImageResource(user.getResouceImage());


        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickItemUserListener.onClickItemUser(user);
            }
        });
    }



    //public void release(){
    //  mContext =null;
    //}

    @Override
    public int getItemCount() {
        if (mListUser != null)
        {
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHoder extends RecyclerView.ViewHolder{


        private ImageView imgUser;
        private CardView layoutItem ;


        public UserViewHoder(@NonNull View itemView) {
            super(itemView);

            imgUser = itemView.findViewById(R.id.img_user);
            layoutItem = itemView.findViewById(R.id.layout_item);

        }
    }
}

