package club.zhangyuyang.kuakua.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;
import java.util.zip.Inflater;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_model.MessageBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午7:53
 * @FileName : ConversationAdapter
 * Content   : TODO
 * Other     :
 */
public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.VH> {
    private static final String TAG = "ConversationAdapter";
    private List<MessageBean> mList;
    private FriendBean mFriendBean;
    private UserBean mUserBean;

    public ConversationAdapter(List<MessageBean> list, UserBean bean) {

        for (MessageBean messageBean : list) {
            Log.d(TAG, ": "+messageBean.getUsername());
            Log.d(TAG, ": "+messageBean.getMessage());
            Log.d(TAG, ": "+messageBean.isSendBySelf());
        }
        mList = list;
        mUserBean = bean;
    }

    @NonNull
    @Override
    public ConversationAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationAdapter.VH vh, int i) {
        MessageBean messageBean = mList.get(i);
        mFriendBean = LitePal.where("username like ?", messageBean.getUsername()).find(FriendBean.class).get(0);
        vh.mImageViewGuest.setImageResource(mFriendBean.getUsericon());
        vh.mImageViewUser.setImageResource(mUserBean.getUsericon());
        if (messageBean.isSendBySelf()) {
            vh.mLayoutGuest.setVisibility(View.GONE);
            vh.mLayoutUser.setVisibility(View.VISIBLE);
            vh.mTextViewUser.setText(messageBean.getMessage());
        } else {
            vh.mLayoutUser.setVisibility(View.GONE);
            vh.mLayoutGuest.setVisibility(View.VISIBLE);
            vh.mTextViewGuest.setText(messageBean.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class VH extends RecyclerView.ViewHolder {

        private LinearLayout mLayoutGuest;
        private LinearLayout mLayoutUser;
        private ImageView mImageViewGuest;
        private ImageView mImageViewUser;
        private TextView mTextViewGuest;
        private TextView mTextViewUser;

        public VH(@NonNull View itemView) {
            super(itemView);

            mLayoutGuest = (LinearLayout) itemView.findViewById(R.id.layout_guest_activity_conversation);
            mLayoutUser = (LinearLayout) itemView.findViewById(R.id.layout_user_activity_conversation);
            mImageViewGuest = (ImageView) itemView.findViewById(R.id.iv_icon_guest_item_message);
            mImageViewUser = (ImageView) itemView.findViewById(R.id.iv_icon_user_item_message);
            mTextViewGuest = (TextView) itemView.findViewById(R.id.tv_icon_guest_item_message);
            mTextViewUser = (TextView) itemView.findViewById(R.id.tv_icon_user_item_message);
        }
    }
}
