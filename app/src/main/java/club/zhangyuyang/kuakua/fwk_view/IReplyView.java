package club.zhangyuyang.kuakua.fwk_view;

import java.util.List;

import club.zhangyuyang.kuakua.fwk_model.AnswerBean;
import club.zhangyuyang.kuakua.fwk_model.FriendBean;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-18 上午11:08
 * @FileName : IReplyView
 * Content   : TODO
 * Other     :
 */
public interface IReplyView {
    void initView(String username, List<AnswerBean> list, FriendBean friendBean);

}
