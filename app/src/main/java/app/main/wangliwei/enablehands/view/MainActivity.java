package app.main.wangliwei.enablehands.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseActivity;
import app.main.wangliwei.enablehands.view.adapter.ViewPagerAdapter;
import app.main.wangliwei.enablehands.view.fragment.PictureFragment;
import butterknife.BindView;

public class MainActivity extends BaseActivity {
    private String[] tabTitle = {"福利","Android","IOS","视频","资源","前端"};

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initToolBar();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initToolBar() {
        toolbar.setNavigationIcon(R.mipmap.other);
        List<Fragment> list_fragment = new ArrayList<>();
        for(int i=0;i<6;i++) {
            list_fragment.add(new PictureFragment());
        }

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                list_fragment,Arrays.asList(tabTitle));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
