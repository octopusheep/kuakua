package club.zhangyuyang.kuakua.fwk_view.assets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import club.zhangyuyang.kuakua.R;
import club.zhangyuyang.kuakua.fwk_view.IMainView;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午5:57
 * @FileName : BottomBarItem1
 * Content   : TODO
 * Other     :
 */
public class BottomBarItem4 extends LinearLayout {

    public BottomBarItem4(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_bottom_bar_4, this);
    }
}
