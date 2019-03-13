package club.zhangyuyang.kuakua.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import club.zhangyuyang.kuakua.util.ActivityManager;

/**
 * @Author :   yuyang
 * @Email :    octopusheep@gmail.com
 * @website :  www.zhangyuyang.club
 * @Date :     19-3-13 下午4:58
 * @FileName : BaseActicity
 * Content   : TODO
 * Other     :
 */
public class BaseActicity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityManager.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        ActivityManager.remove(this);
    }
}
