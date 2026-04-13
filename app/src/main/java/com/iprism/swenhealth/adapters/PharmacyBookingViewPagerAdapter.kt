import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.PharmacyCompletedBookingsFragment
import com.iprism.swenhealth.fragments.PharmacyOnGoingBookingsFragment

class PharmacyBookingViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PharmacyOnGoingBookingsFragment()
            1 -> PharmacyCompletedBookingsFragment()
            else -> PharmacyOnGoingBookingsFragment()
        }
    }
}
