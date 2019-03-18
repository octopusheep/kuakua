package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Intent;

import club.zhangyuyang.kuakua.ConversationActivity;
import club.zhangyuyang.kuakua.adapter.ConversationAdapter;
import club.zhangyuyang.kuakua.fwk_model.DataModel;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_model.MessageBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午6:53
 * @FileName : ConversationPresenter
 * Content   : TODO
 * Other     :
 */
public class ConversationPresenter {
    private ConversationActivity mActivity;
    private Intent mIntent;
    private String mGuestUsername;
    private ConversationAdapter mAdapter;
    private MessageBean mMessageBean;

    public ConversationPresenter(ConversationActivity activity) {
        mActivity = activity;
        mIntent = mActivity.getIntent();
        mGuestUsername = mIntent.getStringExtra(ConversationActivity.EXTRA_USERNAME_GUEST);
    }

    public void initView() {

        DataModel.initDB();
        mActivity.initView(
                DataModel.queryMessageList(mGuestUsername),
                DataModel.queryNicknameByUsername(mGuestUsername),
                DataModel.queryUserInformation());

    }


    public void sendMessage(String message) {
        mMessageBean = new MessageBean(mGuestUsername, message, true);
        mMessageBean.save();

        FriendBean friendBean = new FriendBean();
        friendBean.setStatus1("true"); // raise the price
        friendBean.updateAll("username = ?", mGuestUsername);
    }

    public ConversationAdapter getAdapter() {
        mAdapter = new ConversationAdapter(
                DataModel.queryMessageList(mGuestUsername),
                DataModel.queryUserInformation());
        return mAdapter;
    }

    public int getAdapterLastIndex() {
        return mAdapter.getItemCount() - 1;
    }

    public boolean isInvaildMessage(String message) {
        return message.equals("");
    }

    public void excuteMessage(String message) {
        mMessageBean = new MessageBean(mGuestUsername, DataModel.queryAnswer(mGuestUsername, message), false);
        mMessageBean.save();
        mActivity.refreshRecyclerViewWithDelay();
    }


}
