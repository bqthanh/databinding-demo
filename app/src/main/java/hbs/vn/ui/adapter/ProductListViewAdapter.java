package hbs.vn.ui.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

import hbs.vn.databinding.ItemProductBinding;
import hbs.vn.ui.main.home.ProductItemViewModel;
import hbs.vn.model.Product;
import hbs.vn.ui.base.AdapterEventListener;
import hbs.vn.util.AppLog;

/**
 * Created by thanhbui on 2018/10/20.
 */

public class ProductListViewAdapter extends RecyclerView.Adapter<ProductListViewAdapter.MyViewHolder>{
    private AdapterEventListener mAdapterEventListener;
    private List<Product> mProducts;

    public ProductListViewAdapter(AdapterEventListener listener) {
        this.mAdapterEventListener = listener;
    }

    public void setProducts(List products) {
        this.mProducts = products;
        notifyDataSetChanged();
        AppLog.d("TAG", String.format("Products size: %s", (products == null ? "null" : products.size())));
    }

    @Override
    public ProductListViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = ItemProductBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false).getRoot();
        return new ProductListViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductListViewAdapter.MyViewHolder holder, int position) {
        ProductItemViewModel vm = new ProductItemViewModel(mAdapterEventListener);
        vm.setProduct(mProducts.get(position));
        ItemProductBinding binding = holder.getBinding();
        binding.setVm(vm);
    }

    @Override
    public int getItemCount() {
        if (mProducts != null) {
            return mProducts.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemProductBinding mBinding;

        public MyViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public ItemProductBinding getBinding() {
            return this.mBinding;
        }
    }
}