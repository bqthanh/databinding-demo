package hbs.vn.ui.main.home;

import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import hbs.vn.model.Product;
import hbs.vn.ui.base.AdapterEventListener;
import hbs.vn.util.AppLog;

import static hbs.vn.ui.main.home.ProductListViewModel.FLAG_LIKE;
import static hbs.vn.ui.main.home.ProductListViewModel.FLAG_UNLIKE;

/**
 * Created by thanhbui on 2018/10/20.
 */

public class ProductItemViewModel extends BaseObservable {
    private AdapterEventListener mAdapterEventListener;

    public final ObservableField<Product> product = new ObservableField<>();
    public final ObservableBoolean liked = new ObservableBoolean(true);

    public ProductItemViewModel(AdapterEventListener listener) {
        mAdapterEventListener = listener;

        OnPropertyChangedCallback callback = new OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                liked.set(product.get().liked);
                AppLog.d("TAG", "On property change: " + liked.get());
            }
        };
        product.addOnPropertyChangedCallback(callback);
    }

    public void setProduct(Product product) {
        this.product.set(product);
    }

    public void onItemClicked(View view) {
        AppLog.d("TAG", "onItemClicked");
        mAdapterEventListener.onItemClicked(view, this, null);
    }

    public void onLikeButtonClick(View view) {
        AppLog.d("TAG", "onLikeButtonClick");
        mAdapterEventListener.onItemClicked(view, this, FLAG_LIKE);
    }

    public void onUnLikeButtonClick(View view) {
        AppLog.d("TAG", "onUnLikeButtonClick");
        mAdapterEventListener.onItemClicked(view, this, FLAG_UNLIKE);
    }
}