package club.zhangyuyang.kuakua.fwk_presenter;

import android.database.sqlite.SQLiteDatabase;

import org.litepal.LitePal;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fragment.FriendFragment;
import club.zhangyuyang.kuakua.fwk_model.DataModel;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午2:54
 * @FileName : FriendPresenter
 * Content   : TODO
 * Other     :
 */
public class FriendPresenter {

    private FriendFragment mFragment;

    public FriendPresenter(FriendFragment fragment) {
        mFragment = fragment;
    }

    public void initView() {

        DataModel.initDatabase();
        DataModel.initFriendDatabase();
        mFragment.initView(DataModel.queryAllFriendList());
    }
}
