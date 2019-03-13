package club.zhangyuyang.kuakua.fwk_presenter;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午6:23
 * @FileName : IMainPresenter
 * Content   : TODO
 * Other     :
 */
public interface IMainPresenter {

    void initView();
    FragmentManager getFragmentManager();
    FragmentTransaction getFragmentTransaction();
}
