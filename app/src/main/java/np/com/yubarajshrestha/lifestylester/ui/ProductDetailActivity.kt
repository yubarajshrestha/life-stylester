package np.com.yubarajshrestha.lifestylester.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_product_detail.*
import np.com.yubarajshrestha.lifestylester.R
import np.com.yubarajshrestha.lifestylester.api.Adapters.RatingAdapter
import np.com.yubarajshrestha.lifestylester.api.Models.RatingModel

class ProductDetailActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar
    lateinit var ratings: ArrayList<RatingModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        if(supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val productId = intent.getIntExtra("product_id", 0)
        val productTitle = intent.getStringExtra("product_title")
        val productPrice = intent.getStringExtra("product_price")
        val productImage = intent.getStringExtra("product_image")

        supportActionBar?.title = productTitle
        Glide.with(applicationContext).load(productImage).into(product_image)

        setUpRatings()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> supportFinishAfterTransition()
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setUpRatings() {
        ratings = ArrayList<RatingModel>()
        ratings.add(RatingModel("Gabriel Valdivia", "https://media.creativemornings.com/uploads/user/avatar/2365/profile-square-small.jpg", "4/5", "That proves you are unusual,\" returned the Scarecrow; \"and I am convinced that the only people worthy of consideration in this world are the unusual ones. For the common folks are like the leaves of a tree, and live and die unnoticed."))
        ratings.add(RatingModel("Amanda Nienaber", "https://media.creativemornings.com/uploads/user/avatar/58109/AmandaNienaberProfile-square.jpg", "5/5", "You are the shuckiest shuck faced shuck in the world!"))
        ratings.add(RatingModel("Katie Sherwin", "https://media.nngroup.com/media/people/photos/Katie_Sherwin_square400x400_warm.jpg.400x400_q95_autocrop_crop_upscale.jpg", "5/5", "Insane means fewer cameras!"))
        ratings.add(RatingModel("Kim Flaherty", "https://media.nngroup.com/media/people/photos/Kim-Flaherty-Headshot.png.400x400_q95_autocrop_crop_upscale.png", "3/5", "A musician must make music, an artist must paint, a poet must write, if he is to be ultimately at peace with himself. What a man can be, he must be!"))
        val adapter = RatingAdapter(ratings)
        val ratings = ratings_view
        ratings.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager
        ratings.adapter = adapter
    }

}
