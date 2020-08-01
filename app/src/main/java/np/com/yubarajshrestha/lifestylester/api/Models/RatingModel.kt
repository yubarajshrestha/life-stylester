package np.com.yubarajshrestha.lifestylester.api.Models

import android.os.Parcel
import android.os.Parcelable

data class RatingModel(val user_name: String, val user_photo: String, val user_rating: String, val user_view: String): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user_name)
        parcel.writeString(user_photo)
        parcel.writeString(user_rating)
        parcel.writeString(user_view)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RatingModel> {
        override fun createFromParcel(parcel: Parcel): RatingModel {
            return RatingModel(parcel)
        }

        override fun newArray(size: Int): Array<RatingModel?> {
            return arrayOfNulls(size)
        }
    }
}