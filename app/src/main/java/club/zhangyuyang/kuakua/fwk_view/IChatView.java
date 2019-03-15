package club.zhangyuyang.kuakua.fwk_view;

import java.util.List;

import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-15 下午4:35
 * @FileName : IChatView
 * Content   : TODO
 * Other     :
 */
public interface IChatView {
    void initView(List<FriendBean> list);
}
