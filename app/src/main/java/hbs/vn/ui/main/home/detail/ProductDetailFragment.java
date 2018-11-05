package hbs.vn.ui.main.home.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hbs.vn.databinding.FragmentProductDetailBinding;

/**
 * Created by thanhbui on 2018/07/23.
 */

public class ProductDetailFragment extends Fragment {
    public static final String TAG = ProductDetailFragment.class.getSimpleName();

    public static final String ARG_PRODUCT_ID = "arg_product_id";
    private static int mProductId;

    public static Fragment newInstance(int productId) {
        Fragment fragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_PRODUCT_ID, productId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentProductDetailBinding binding = FragmentProductDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}