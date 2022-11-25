package first.bodrug.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import first.bodrug.myapplication.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun buttonResultListener(view: View) {
        if (!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            binding.resultInfo.text = result
        }
    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "ВВЕДИТЕ ЗНАЧЕНИЕ"
            if (edB.text.isNullOrEmpty()) edB.error = "ВВЕДИТЕ ЗНАЧЕНИЕ"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        var a: Double
        var b: Double
        with(binding) {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
            return sqrt(a.pow(2) + b.pow(2)).toString()
        }
    }
}