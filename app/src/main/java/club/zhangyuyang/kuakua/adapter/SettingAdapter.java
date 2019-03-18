package club.zhangyuyang.kuakua.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.ReplyActivity;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-18 上午9:53
 * @FileName : SettingAdapter
 * Content   : TODO
 * Other     :
 */
public class SettingAdapter extends RecyclerView.Adapter<SettingAdapter.VH> {
    private static final String TAG = "SettingAdapter";

    private Context mContext;
    private List<FriendBean> mList;

    public SettingAdapter(Context context, List<FriendBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public SettingAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_setting, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingAdapter.VH vh, int i) {
        final FriendBean friendBean = mList.get(i);

        vh.mTextView.setText(friendBean.getNickname());
        vh.mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplyActivity.startReplyActivity(mContext, friendBean.getUsername());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class VH extends RecyclerView.ViewHolder {
        private LinearLayout mLayout;
        private TextView mTextView;

        public VH(@NonNull View itemView) {
            super(itemView);

            mLayout = itemView.findViewById(R.id.layout_item_fragment_setting);
            mTextView = itemView.findViewById(R.id.tv_username_friend_fragment_setting);
        }
    }
}
