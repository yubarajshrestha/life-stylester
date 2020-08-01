package np.com.yubarajshrestha.lifestylester.ui


import android.graphics.Color
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.fragment_home.view.*

import np.com.yubarajshrestha.lifestylester.R


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    //lateinit var products: ArrayList<ProductModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_home, container, false)

        (activity as AppCompatActivity).supportActionBar!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        (activity as AppCompatActivity).supportActionBar!!.title = ""

        val image = layout.findViewById(R.id.mid_image) as ImageView
        setBW(image)
        /*setUpProducts()
        setUpAdapter(layout)*/

        layout.women_view.setOnClickListener {
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().setCustomAnimations(R.animator.fade_in, R.animator.fade_out, R.animator.fade_in, R.animator.fade_out).addToBackStack(null).replace(R.id.main_content, TabsFragment()).commit()
        }
        return layout
    }

    private fun setBW(imageView: ImageView) {
        val matrix = ColorMatrix()
        matrix.setSaturation(0F)
        val filter = ColorMatrixColorFilter(matrix)
        imageView.colorFilter = filter
    }

}// Required empty public constructor
