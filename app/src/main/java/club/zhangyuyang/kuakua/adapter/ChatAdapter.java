package club.zhangyuyang.kuakua.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.litepal.LitePal;

import java.util.List;
import java.util.zip.Inflater;

import club.zhangyuyang.kuakua.ConversationActivity;
import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fwk_model.DataModel;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_model.MessageBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-15 下午4:30
 * @FileName : ChatAdapter
 * Content   : TODO
 * Other     :
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.VH> {
    private Context mContext;
    private List<FriendBean> mList;

    public ChatAdapter(Context context, List<FriendBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public ChatAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_chat, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.VH vh, int i) {
        final FriendBean friendBean = mList.get(i);
        vh.mImageView.setImageResource(friendBean.getUsericon());
        vh.mTextView1.setText(friendBean.getNickname());
        vh.mTextView2.setText(DataModel.queryLastMessageByUsername(friendBean.getUsername()));

        vh.mLayout.setOnClickListener(new View.OnClickListener() {
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

    public class VH extends RecyclerView.ViewHolder {
        private LinearLayout mLayout;
        private ImageView mImageView;
        private TextView mTextView1;
        private TextView mTextView2;

        public VH(@NonNull View itemView) {
            super(itemView);

            mLayout = (LinearLayout) itemView.findViewById(R.id.layout_item_fragment_chat);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_usericon_fragment_chat);
            mTextView1 = (TextView) itemView.findViewById(R.id.tv_nickname_fragment_chat);
            mTextView2 = (TextView) itemView.findViewById(R.id.tv_message_fragment_chat);
        }
    }
}
