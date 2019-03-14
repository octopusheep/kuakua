package club.zhangyuyang.kuakua.fwk_view;

import java.util.List;

import club.zhangyuyang.kuakua.fwk_model.MessageBean;
import club.zhangyuyang.kuakua.fwk_model.UserBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-14 下午6:55
 * @FileName : IConversationView
 * Content   : TODO
 * Other     :
 */
public interface IConversationView {
    void initView(List<MessageBean> list, String nickname, UserBean userBean);
}
