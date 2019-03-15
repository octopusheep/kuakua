package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.util.Log;

import org.litepal.LitePal;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fragment.SettingFragment;
import club.zhangyuyang.kuakua.fwk_model.DataModel;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午2:03
 * @FileName : SettingPresenter
 * Content   : TODO
 * Other     :
 */
public class SettingPresenter {

    private SettingFragment mFragment;
    private Context mContext;

    public SettingPresenter(Fragment fragment) {
        mFragment = (SettingFragment) fragment;
        mContext = mFragment.getActivity();
    }

    public void initView() {
        mFragment.initView(DataModel.queryUserInformation());
    }

}
