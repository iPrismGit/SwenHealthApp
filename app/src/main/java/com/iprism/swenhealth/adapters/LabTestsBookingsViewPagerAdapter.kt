import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.LabTestsCompletedBookingsFragment
import com.iprism.swenhealth.fragments.LabTestsOnGoingBookingsFragment

class LabTestsBookingsViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {

        return when (position) {
            0 -> LabTestsOnGoingBookingsFragment()
            1 -> LabTestsCompletedBookingsFragment()
            else -> LabTestsOnGoingBookingsFragment()
        }
    }

}
