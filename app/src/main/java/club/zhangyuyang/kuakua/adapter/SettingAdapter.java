package club.zhangyuyang.kuakua.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import club.zhangyuyang.kuakua.R;
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
        if (i == 0) {
            vh.mTextView.setText(R.string.username_default);
        } else {
            vh.mTextView.setText(mList.get(i - 1).getNickname());
        }

    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
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
