package club.zhangyuyang.kuakua.fwk_view;

import java.util.List;

import club.zhangyuyang.kuakua.fwk_model.FriendBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午2:04
 * @FileName : ISettingView
 * Content   : TODO
 * Other     :
 */
public interface ISettingView {
    void initView(UserBean userBean, List<FriendBean> list);
}
