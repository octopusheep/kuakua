package club.zhangyuyang.kuakua.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.ConversationActivity;
import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午3:34
 * @FileName : FriendAdapter
 * Content   : TODO
 * Other     :
 */
public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.VH>{

    private List<FriendBean> mList;
    private Context mContext;

    public FriendAdapter(Context context, List<FriendBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_friend, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH vh, int i) {
        final FriendBean friendBean = mList.get(i);
        vh.mImageView.setImageResource(friendBean.getUsericon());
        vh.mTextView.setText(friendBean.getNickname());
        vh.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConversationActivity.startConversationActivity(mContext,friendBean.getUsername());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
        private View mView;

        public VH(@NonNull View itemView) {
            super(itemView);

            mView = itemView.findViewById(R.id.layout_item_fragment_friend);
            mImageView = itemView.findViewById(R.id.iv_usericon_fragment_friend);
            mTextView = itemView.findViewById(R.id.tv_nickname_fragment_friend);
        }
    }
}
