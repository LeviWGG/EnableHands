package app.main.wangliwei.enablehands.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


import java.util.ArrayList;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseActivity;
import app.main.wangliwei.enablehands.view.fragment.FavoriteFragment;
import app.main.wangliwei.enablehands.view.fragment.HomeFragment;
import app.main.wangliwei.enablehands.view.fragment.PersonFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private Fragment fragment;
    private List<Fragment> fragmentList;
    private FragmentTransaction ft;

    @BindView(R.id.bottom_tab_layout)
    TabLayout bottmeTab;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        //addFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FavoriteFragment());
        fragmentList.add(new PersonFragment());

        bottmeTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                fragment = fragmentList.get(tab.getPosition());
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_content,fragment).commit();
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
        bottmeTab.addTab(bottmeTab.newTab().setIcon(R.mipmap.account).setText("我"));
    }

    private void addFragment() {
        if(fragment == null) {
            fragment = new HomeFragment();
        }
        if(!fragment.isAdded()) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.fragment_content,fragment);
            ft.show(fragment).commit();
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
