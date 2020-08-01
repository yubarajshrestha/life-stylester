package np.com.yubarajshrestha.lifestylester.api.Adapters

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.product_list_item.view.*
import np.com.yubarajshrestha.lifestylester.R
import np.com.yubarajshrestha.lifestylester.api.Models.ProductModel
import np.com.yubarajshrestha.lifestylester.ui.ProductDetailActivity

class ProductAdapter(private val products: ArrayList<ProductModel>, private val activity: FragmentActivity?): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var options: RequestOptions

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        options = RequestOptions().fitCenter().placeholder(R.color.cardBackground).error(R.drawable.gradient_red)

        val view = LayoutInflater.from(context).inflate(R.layout.product_list_item, parent, false)
        return ViewHolder(view, context, activity)
    }

    override fun getItemCount() = products.size

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindItem(products[position], options)
    }

    class ViewHolder(itemView: View, context: Context, activity: FragmentActivity?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        lateinit var product: ProductModel
        private var productImage = itemView.product_image
        private var productPrice = itemView.product_price
        private var productName = itemView.product_name
        private var mContext = context
        private var mActivity = activity

        init {
            itemView.setOnClickListener(this)
        }

        fun bindItem(item: ProductModel, options: RequestOptions) {
            this.product = item
            productName.text = item.title
            productPrice.text = item.price
            Glide.with(mContext).load(item.image).apply(options).into(productImage)
        }

        @SuppressLint("NewApi")
        override fun onClick(v: View?) {
            val productDetailActivity = Intent(mContext, ProductDetailActivity::class.java)
            productDetailActivity.putExtra("product_id", product.id)
            productDetailActivity.putExtra("product_title", product.title)
            productDetailActivity.putExtra("product_image", product.image)
            productDetailActivity.putExtra("product_price", product.price)
            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(
                    mActivity,
                    android.util.Pair<View, String>(productName, "product_title"),
                    android.util.Pair<View, String>(productImage, "product_image"),
                    android.util.Pair<View, String>(productPrice, "product_price"))
            itemView.context.startActivity(productDetailActivity, activityOptions.toBundle())
        }
    }

}