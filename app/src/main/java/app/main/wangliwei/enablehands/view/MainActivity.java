package app.main.wangliwei.enablehands.view;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private WeakReference<FragmentTransaction> ft;
    private Integer pos_tab = null;

    private static boolean enableExit = false;
    private static MyHandler myHandler = new MyHandler();

    @BindView(R.id.bottom_tab_layout)
    TabLayout bottmeTab;

    @BindView(R.id.nav_left)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    ImageView photoView;

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
        fragmentList.add(new WeakReference<>(new HomeFragment()).get());
        fragmentList.add(new WeakReference<>(new FavoriteFragment()).get());
        fragmentList.add(new WeakReference<>(new FriendsFragment()).get());
        fragmentList.add(new WeakReference<>(new PersonFragment()).get());

        bottmeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ft = new WeakReference<>(getSupportFragmentManager().beginTransaction());
                if(pos_tab != null) {
                    bottmeTab.getTabAt(pos_tab).setIcon(iconList.get(pos_tab));
                    Fragment preFragment = fragmentList.get(pos_tab);
                    Fragment fragment = fragmentList.get(tab.getPosition());
                    if(fragment.isAdded()) {
                        ft.get().hide(preFragment).show(fragment).commit();
                    }else {
                        ft.get().hide(preFragment)
                                .add(R.id.fragment_content,fragment).commit();
                    }
                }else {
                    ft.get().add(R.id.fragment_content,fragmentList.get(0))
                            .commit();
                }
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
        photoView = navigationView.getHeaderView(0)
                .findViewById(R.id.icon_person);
        photoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media
                        .EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intent, "请选择图片"), 101);
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            Uri uri = data.getData();
            ContentResolver cr = this.getContentResolver();
            try {
                Bitmap bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));
                photoView.setImageBitmap(bmp);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
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
