package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import club.zhangyuyang.kuakua.MainActivity;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午6:26
 * @FileName : MainPresenter
 * Content   : TODO
 * Other     :
 */
public class MainPresenter implements IMainPresenter {

    private MainActivity mActivity;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public MainPresenter(Context context) {
        mActivity =(MainActivity) context;
    }

    @Override
    public void initView() {
        mActivity.initView();
    }

    @Override
    public FragmentManager getFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    @Override
    public FragmentTransaction getFragmentTransaction() {
        return mFragmentManager.beginTransaction();
    }
}
