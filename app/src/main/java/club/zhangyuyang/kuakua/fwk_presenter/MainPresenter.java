package club.zhangyuyang.kuakua.fwk_presenter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import club.zhangyuyang.kuakua.MainActivity;
import club.zhangyuyang.kuakua.R;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午6:26
 * @FileName : MainPresenter
 * Content   : TODO
 * Other     :
 */
public class MainPresenter {

    private MainActivity mActivity;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public MainPresenter(Context context) {
        mActivity = (MainActivity) context;
    }

    public void initView() {
        mActivity.initView();
    }

    public void showFragment(Fragment fragment) {

        mFragmentManager = getFragmentManager();
        mFragmentTransaction = getFragmentTransaction();
        mFragmentTransaction.replace(R.id.fragment_container, fragment);
        mFragmentTransaction.commit();
    }

    public FragmentManager getFragmentManager() {
        return mActivity.getSupportFragmentManager();
    }

    public FragmentTransaction getFragmentTransaction() {
        return mFragmentManager.beginTransaction();
    }
}
