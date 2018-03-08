package app.main.wangliwei.enablehands.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import app.main.wangliwei.enablehands.R;
import app.main.wangliwei.enablehands.base.BaseFragment;
import app.main.wangliwei.enablehands.presenter.IPersonContract;
import app.main.wangliwei.enablehands.presenter.PersonPresenterImp;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonFragment extends BaseFragment implements IPersonContract.IPersonView {
    private View view;
    private IPersonContract.IPersonPresenter iPersonPresenter;


    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = super.onCreateView(inflater, container, savedInstanceState);
        iPersonPresenter = new PersonPresenterImp(this);

        return view;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView() {
    }

    @OnClick({R.id.btn_clear_memory})
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_clear_memory :
                iPersonPresenter.clearMemory();
                break;
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this.getActivity(),text,Toast.LENGTH_SHORT).show();
    }
}
