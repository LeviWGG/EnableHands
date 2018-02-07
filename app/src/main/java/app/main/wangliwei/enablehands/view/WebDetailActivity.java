package app.main.wangliwei.enablehands.view;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseActivity;
import butterknife.BindView;

public class WebDetailActivity extends BaseActivity {
    private Bundle bundle;

    @BindView(R.id.web_frame)
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getIntent().getExtras();
        initView();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_web_detail;
    }

    private void initView() {
        WebView webView = new WebView(this);
        //解决图片加载问题
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);
        frameLayout.addView(webView);
        String url = bundle.getString("URL");
        Log.d("web","url: "+url);
        webView.loadUrl(url);
    }
}
