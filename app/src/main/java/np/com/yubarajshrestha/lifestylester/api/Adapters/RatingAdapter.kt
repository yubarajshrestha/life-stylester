package np.com.yubarajshrestha.lifestylester.api.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.rating_list_item.view.*
import np.com.yubarajshrestha.lifestylester.R
import np.com.yubarajshrestha.lifestylester.api.Models.RatingModel

class RatingAdapter(private val ratings: ArrayList<RatingModel>): RecyclerView.Adapter<RatingAdapter.ViewHolder>() {

    private lateinit var context: Context
    private lateinit var options: RequestOptions

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        options = RequestOptions().fitCenter().placeholder(R.color.cardBackground).error(R.color.cardBackground)

        val view = LayoutInflater.from(context).inflate(R.layout.rating_list_item, parent, false)
        return ViewHolder(view, context)
    }

    override fun getItemCount() = ratings.size

    override fun onBindViewHolder(holder: RatingAdapter.ViewHolder, position: Int) {
        holder.bindItem(ratings[position], options)
    }

    class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
        private var userName = itemView.user_name
        private var userRating = itemView.user_rating
        private var userImage = itemView.user_image
        private var userView = itemView.user_view
        private var mContext = context

        init {
            //
        }

        fun bindItem(item: RatingModel, options: RequestOptions) {
            userName.text = item.user_name
            userRating.text = item.user_rating
            userView.text = item.user_view

            Glide.with(mContext).load(item.user_photo).apply(options).into(userImage)
        }
    }

}