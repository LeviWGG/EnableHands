package app.main.wangliwei.baselib.widgets;


import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import app.main.wangliwei.baselib.R;
import app.main.wangliwei.baselib.base.BaseMVPFragment;
import app.main.wangliwei.baselib.base.BasePresenter;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.QRCodeDecoder;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static android.content.Context.VIBRATOR_SERVICE;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanQRCodeFragment extends BaseMVPFragment implements QRCodeView.Delegate{

    QRCodeView mQRCodeView;

    TextView textStartScan;

    TextView textGetPhoto;

    @Override
    public BasePresenter initPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_scan_qrcode;
    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState) {
        mQRCodeView = getView().findViewById(R.id.zxingview);
        textStartScan = getView().findViewById(R.id.text_start_scan);
        textGetPhoto = getView().findViewById(R.id.text_get_photo);

        mQRCodeView.setDelegate(this);

        textStartScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mQRCodeView.startSpot();
            }
        });
        textGetPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentA = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media
                        .EXTERNAL_CONTENT_URI);
                startActivityForResult(Intent.createChooser(intentA, "请选择图片"), 101);
            }
        });
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Bundle bundle = new Bundle();
        bundle.putString("QRCODE",result);
        setFragmentResult(RESULT_OK,bundle);
        pop();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Toast.makeText(_mActivity, "打开相机出错", Toast.LENGTH_SHORT).show();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) _mActivity.getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }

    @Override
    public void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (RESULT_OK != resultCode)return;
            if (data == null) return;
            Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                    Uri uri = data.getData();
                    String result = null;
                    ContentResolver cr = getActivity().getContentResolver();
                    try {
                        Bitmap bmp = BitmapFactory.decodeStream(cr.openInputStream(uri));

                        result = QRCodeDecoder.syncDecodeQRCode(bmp);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    emitter.onNext(result);
                }
            }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            Bundle bundle = new Bundle();
                            bundle.putString("QRCODE",s);
                            setFragmentResult(RESULT_OK,bundle);
                            pop();
                        }
                    });
        }
    }
}
