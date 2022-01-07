import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ViewModelTests {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: OrderViewModel

    @Before
    fun setup() {
        viewModel = OrderViewModel()
    }

    @Test
    fun quantity_twelve_cupcakes() {
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        viewModel.setQuantity(12)
        viewModel.price.observeForever {}
        assertEquals("₹ 27.00", viewModel.price.value)
    }
}