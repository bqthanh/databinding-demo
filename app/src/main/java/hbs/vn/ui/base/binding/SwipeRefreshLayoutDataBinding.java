package hbs.vn.ui.base.binding;

import android.databinding.BindingAdapter;
import android.support.v4.widget.SwipeRefreshLayout;

import hbs.vn.ui.main.home.ProductListViewModel;

/**
 * Created by thanhbui on 2018/10/21.
 */

public class SwipeRefreshLayoutDataBinding {

    /**
     * Reloads the data when the pull-to-refresh is triggered.
     * <p>
     * Creates the {@code android:onRefresh} for a {@link SwipeRefreshLayout}.
     */
    @BindingAdapter("app:onRefreshListener")
    public static void setOnRefreshListener(SwipeRefreshLayout view, final ProductListViewModel vm) {
        view.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (vm != null) {
                    vm.loadProducts();
                }
            }
        });
    }
}