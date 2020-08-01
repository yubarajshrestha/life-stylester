package np.com.yubarajshrestha.lifestylester.ui


import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_product.*
import kotlinx.android.synthetic.main.fragment_product.view.*

import np.com.yubarajshrestha.lifestylester.R
import np.com.yubarajshrestha.lifestylester.api.Adapters.ProductAdapter
import np.com.yubarajshrestha.lifestylester.api.Models.ProductModel


/**
 * A simple [Fragment] subclass.
 */
class ProductFragment : Fragment() {

    lateinit var products: ArrayList<ProductModel>
    lateinit var refreshLayout: SwipeRefreshLayout
    lateinit var layout: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        layout = inflater.inflate(R.layout.fragment_product, container, false)
        val title = arguments?.getString("category")

        setUpProducts()
        setUpLayouts()

        return layout
    }

    private fun setUpLayouts() {
        refreshLayout = layout.refresh_products
        refreshLayout.setColorSchemeColors(resources.getColor(R.color.colorAccent), resources.getColor(R.color.cardBackground), resources.getColor(R.color.colorPrimary))

        setUpAdapter()

        refreshLayout.setOnRefreshListener {
            setUpAdapter()
        }
    }

    private fun setUpProducts() {
        products = ArrayList<ProductModel>()

        products.add(ProductModel(1, "First Lady", "$220", "http://www.freepngimg.com/thumb/women_bag/8-2-women-bag-high-quality-png-thumb.png"))
        products.add(ProductModel(2, "Caring Paula", "$108", "http://www.pngmart.com/files/1/Women-Bag-PNG-Clipart.png"))
        products.add(ProductModel(3, "Young Miss Anna", "$200", "http://www.pngmart.com/files/1/Women-Bag-Transparent-Background.png"))
        products.add(ProductModel(4, "Travelon", "$350", "http://www.pngmart.com/files/1/Women-Bag-PNG-File.png"))
        products.add(ProductModel(5, "American West", "$192", "https://www.aquascutum.com/media/catalog/product/cache/1/small_image/460x611/2046f34530a263677f8bb5adc8f2880d/g/h/xghnc17saufm_lacquer_red_front.png.pagespeed.ic.x5pHgLeaN1.png"))
        products.add(ProductModel(6, "Gucci", "$160", "http://www.discountreview.co.uk/images/row/guccibag.png"))
        products.add(ProductModel(7, "Chic Buds", "$190", "https://www.tilley.com/media/catalog/category/thumbnail/women_accessories_bags-belts.png"))
        products.add(ProductModel(8, "Hunting", "$130", "https://www.bordersgunroom.co.uk/images/handbag%20hunting.png"))
    }

    private fun setUpAdapter() {
        val recyclerView = layout.findViewById<RecyclerView>(R.id.product_view)
        recyclerView.layoutManager = LinearLayoutManager(layout.context) as RecyclerView.LayoutManager?
        recyclerView.adapter = ProductAdapter(products, activity)
        recyclerView.visibility = View.VISIBLE // show recycler view
        refreshLayout.isRefreshing = false

        /*Handler().postDelayed({
            refreshLayout.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE // show recycler view
        }, 2000)*/

    }

    companion object {
        fun newInstance(category: String) : ProductFragment {
            val args = Bundle()
            args.putString("category", category)
            val fragment = ProductFragment()
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
