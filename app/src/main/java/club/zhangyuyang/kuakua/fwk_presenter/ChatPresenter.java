package club.zhangyuyang.kuakua.fwk_presenter;

import android.support.v4.app.Fragment;

import club.zhangyuyang.kuakua.fragment.ChatFragment;
import club.zhangyuyang.kuakua.fwk_model.DataModel;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 上午10:45
 * @FileName : ChatPresenter
 * Content   : TODO
 * Other     :
 */
public class ChatPresenter {

    private ChatFragment mFragment;

    public ChatPresenter(Fragment fragment) {
        mFragment = (ChatFragment) fragment;
    }

    public void initView() {

        DataModel.initDatabase();
        DataModel.initFriendDatabase();
        mFragment.initView(DataModel.queryChatFriendList());
    }
}
