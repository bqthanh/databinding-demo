package hbs.vn.ui.main.home.detail;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

public class ProductDetailViewModel extends BaseObservable {

    public ObservableField<Integer> productId = new ObservableField<>();
    public ObservableField<String> productName = new ObservableField<>();
}