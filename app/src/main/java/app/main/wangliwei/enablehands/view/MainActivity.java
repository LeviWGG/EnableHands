package app.main.wangliwei.enablehands.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseActivity;
import app.main.wangliwei.enablehands.view.fragment.FavoriteFragment;
import app.main.wangliwei.enablehands.view.fragment.FriendsFragment;
import app.main.wangliwei.enablehands.view.fragment.HomeFragment;
import app.main.wangliwei.enablehands.view.fragment.PersonFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    //private Fragment fragment;
    private List<Fragment> fragmentList;
    private List<Integer> iconList;
    private Integer[] bottomTabIcon = {R.mipmap.home,R.mipmap.favorite,R.mipmap.friends,R.mipmap.account};
    private List<Integer> iconPressList;
    private Integer[] bottomIconPress = {R.mipmap.home_press,R.mipmap.favorite_press,
            R.mipmap.friends_press,R.mipmap.account_press};
    private FragmentTransaction ft;
    private Integer pos_tab = null;

    private static boolean enableExit = false;
    private static MyHandler myHandler = new MyHandler();

    @BindView(R.id.bottom_tab_layout)
    TabLayout bottmeTab;

    @BindView(R.id.nav_left)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        iconList = Arrays.asList(bottomTabIcon);
        iconPressList = Arrays.asList(bottomIconPress);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new FriendsFragment());
        fragmentList.add(new PersonFragment());

        bottmeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(pos_tab != null) {
                    bottmeTab.getTabAt(pos_tab).setIcon(iconList.get(pos_tab));
                }
                Fragment fragment = fragmentList.get(tab.getPosition());
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_content,fragment).commit();
                pos_tab = tab.getPosition();
                bottmeTab.getTabAt(pos_tab).setIcon(iconPressList.get(pos_tab));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.home).setText("首页"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.favorite).setText("关注"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.friends).setText("好友"));
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.account).setText("我"));

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //关闭左边导航
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private static class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    enableExit = false;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            if(!enableExit) {
                enableExit = true;
                Toast.makeText(this,"再按一次退出",Toast.LENGTH_LONG).show();
                myHandler.sendEmptyMessageDelayed(0,3000);
            }else {
//                finish();
                System.exit(0);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
