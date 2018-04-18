package app.main.wangliwei.enablehands.view;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import app.main.wangliwei.enablehands.R;
import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.qrcode.core.QRCodeView;

public class ScanQRCodeActivity extends AppCompatActivity implements QRCodeView.Delegate {
    private QRCodeView mQRCodeView;

    @BindView(R.id.text_start_scan)
    TextView textStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacn_qrcode);

        mQRCodeView = findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);
    }

    @OnClick(R.id.text_start_scan)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_start_scan :
                mQRCodeView.startSpot();
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();
        mQRCodeView.startSpot();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e("qrcode", "打开相机出错");
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
}
