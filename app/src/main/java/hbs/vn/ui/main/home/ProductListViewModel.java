package hbs.vn.ui.main.home;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.os.Handler;

import hbs.vn.model.Product;
import hbs.vn.source.product.ProductsRepository;
import hbs.vn.util.AppLog;

/**
 * Created by thanhbui on 2018/05/29.
 */

public class ProductListViewModel extends BaseObservable {
    public static final int FLAG_LIKE = 0;
    public static final int FLAG_UNLIKE = 1;

    private ProductsRepository mProductsRepository;
    private Handler mHandler;

    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    public final ObservableBoolean inProgress = new ObservableBoolean(false);

    public final ObservableList<Product> products = new ObservableArrayList<>();

    public ProductListViewModel() {
        mProductsRepository = new ProductsRepository();
        mHandler = new Handler();
    }

    public void loadProducts() {
        isLoading.set(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                products.clear();
                products.addAll(mProductsRepository.getProducts());
                isLoading.set(false);
            }
        }, 5000);
    }

    public void like(final ProductItemViewModel item) {
        AppLog.d("TAG", "Like");
        inProgress.set(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProductsRepository.like(item.product.get());
                item.liked.set(true);
                inProgress.set(false);
            }
        }, 2000);

    }

    public void unlike(final ProductItemViewModel item) {
        AppLog.d("TAG", "Un like");
        inProgress.set(true);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProductsRepository.unlike(item.product.get());
                item.liked.set(false);
                inProgress.set(false);
            }
        }, 2000);
    }
}