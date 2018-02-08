package app.main.wangliwei.enablehands.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
        WebSettings settings = webView.getSettings();
        settings.setDomStorageEnabled(true);
        //解决图片加载问题
        settings.setJavaScriptEnabled(true);
        settings.setBlockNetworkImage(false);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.d("webview","url: "+url);
                view.loadUrl(url);
                return true;
            }
        });
        frameLayout.addView(webView);
        String url = bundle.getString("URL");
        Log.d("web","url: "+url);
        webView.loadUrl(url);
    }
}
