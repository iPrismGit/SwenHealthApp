import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.DiagnosticTestsCompletedBookingsFragment
import com.iprism.swenhealth.fragments.DiagnosticTestsOnGoingBookingsFragment

class DiagnosticTestsBookingsViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DiagnosticTestsOnGoingBookingsFragment()
            1 -> DiagnosticTestsCompletedBookingsFragment()
            else -> DiagnosticTestsOnGoingBookingsFragment()
        }
    }

}
