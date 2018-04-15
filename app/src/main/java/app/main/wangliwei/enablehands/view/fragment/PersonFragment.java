package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import app.main.wangliwei.baselib.widgets.OrderDialog;
import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseMVPFragment;
import app.main.wangliwei.enablehands.presenter.IPersonContract;
import app.main.wangliwei.enablehands.presenter.PersonPresenterImp;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseMVPFragment<IPersonContract.IPersonPresenter> implements IPersonContract.IPersonView {
    private View view;

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView() {
    }

    @OnClick({R.id.btn_clear_memory,R.id.text_about})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_clear_memory :
                mPresenter.clearMemory();
                break;
            case R.id.text_about :
                OrderDialog orderDialog = new OrderDialog(getActivity());
                orderDialog.show();
                orderDialog.setTitleCustom("这是自定义标题")
                        .setContent("这是自定义内容")
                        .setLeft("取消").setRight("确认")
                        .setCheckBox("勾选")
                        .setOnItemOnClickListener(new OrderDialog.OnItemOnClickListener() {
                            @Override
                            public void onItemOnClick(View view, OrderDialog orderDialog) {
                                //orderDialog.dismiss();
                            }
                        });
                break;
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this.getActivity(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public IPersonContract.IPersonPresenter initPresenter() {
        return new PersonPresenterImp(this);
    }
}
