package hbs.vn.ui.main.home;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hbs.vn.R;
import hbs.vn.databinding.FragmentProductListBinding;
import hbs.vn.ui.adapter.ProductListViewAdapter;
import hbs.vn.ui.base.AdapterEventListener;
import hbs.vn.ui.base.FragmentEventListener;
import hbs.vn.ui.main.MainActivity;
import hbs.vn.ui.main.home.detail.ProductDetailFragment;

/**
 * Created by thanhbui on 2018/10/20.
 */

public class ProductListFragment extends Fragment implements AdapterEventListener {
    private FragmentEventListener mFragmentEventListener;
    private Parcelable mLayoutManagerState;

    private RecyclerView mProductRecycleView;
    private ProductListViewAdapter mProductListViewAdapter;
    private ProductListViewModel mViewModel;

    public static Fragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof FragmentEventListener) {
            mFragmentEventListener = (FragmentEventListener) activity;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentProductListBinding binding = FragmentProductListBinding.inflate(inflater, container, false);
        if (mViewModel == null) {
            mViewModel = new ProductListViewModel();
        }
        binding.setVm(mViewModel);
        View rootView = binding.getRoot();
        mProductRecycleView = rootView.findViewById(R.id.recycler_product);
        setupWidgets();
        return rootView;
    }

    public void setupWidgets() {
        mProductRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mProductRecycleView.setHasFixedSize(true);
        mProductListViewAdapter = new ProductListViewAdapter(this);
        mProductRecycleView.setAdapter(mProductListViewAdapter);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mViewModel != null
                && mLayoutManagerState == null) {
            mViewModel.loadProducts();
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClicked(View view, final Object obj, final Object optional) {
        ProductItemViewModel item = (ProductItemViewModel) obj;

        if (optional != null) {
            int flag = (int) optional;
            switch (flag) {
                case ProductListViewModel.FLAG_LIKE:
                    mViewModel.like(item);
                    break;

                case ProductListViewModel.FLAG_UNLIKE:
                    mViewModel.unlike(item);
                    break;
            }
            return;
        }

        if (mFragmentEventListener != null) {
            Uri.Builder builder = new Uri.Builder();
            builder.authority(MainActivity.PRODUCT_DETAIL);
            builder.appendQueryParameter(ProductDetailFragment.ARG_PRODUCT_ID, String.valueOf(item.product.get().id));
            mFragmentEventListener.onPageChanged(builder.build(), this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mProductRecycleView.getLayoutManager().onRestoreInstanceState(mLayoutManagerState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mLayoutManagerState = mProductRecycleView.getLayoutManager().onSaveInstanceState();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFragmentEventListener = null;
    }
}