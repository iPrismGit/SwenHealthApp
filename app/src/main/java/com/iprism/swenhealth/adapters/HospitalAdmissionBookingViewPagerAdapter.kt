import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iprism.swenhealth.fragments.HospitalAdmissionCompletedFragment
import com.iprism.swenhealth.fragments.HospitalAdmissionOnGoingFragment

class HospitalAdmissionBookingViewPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2 // Number of fragments (Home, Medicines, etc.)

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HospitalAdmissionOnGoingFragment()
            1 -> HospitalAdmissionCompletedFragment()
            else -> HospitalAdmissionOnGoingFragment()
        }
    }

}
