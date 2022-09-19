package first.bodrug.m1_hello_world

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import first.bodrug.m1_hello_world.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.textInfo.text = START_MESSAGE
        bindings.textInfo.setTextColor(Color.GREEN)
        bindings.buttonMinus.isEnabled= false
        bindings.buttonMinus.setOnClickListener {
            if (count > ZERO) {
                count--
                bindings.counter.text = "$count"
                if (count <= FULL) {
                    bindings.textInfo.setTextColor(Color.BLUE)
                    bindings.textInfo.text = free
                    bindings.reset.visibility = View.INVISIBLE
                }
                if (count == ZERO) {
                    bindings.textInfo.text = START_MESSAGE
                    bindings.textInfo.setTextColor(Color.GREEN)
                    bindings.buttonMinus.isEnabled = false
                }
            }
        }

        bindings.buttonPlus.setOnClickListener {
            count++
            bindings.buttonMinus.isEnabled = true
            bindings.counter.text = "$count"
            bindings.textInfo.text = free
            bindings.textInfo.setTextColor(Color.BLUE)
            if (count > FULL) {
                bindings.reset.visibility = View.VISIBLE
                bindings.textInfo.setTextColor(Color.RED)
                bindings.textInfo.text = END_MESSAGE
            }
        }

        bindings.reset.setOnClickListener {
            count = ZERO
            bindings.buttonMinus.isEnabled = false
            bindings.textInfo.setTextColor(Color.GREEN)
            bindings.counter.text = "$count"
            bindings.textInfo.text = START_MESSAGE
            bindings.reset.visibility = View.INVISIBLE
        }
    }

    companion object {
        const val ZERO = 0
        var count = ZERO
        val free: String
            get() = "Мест осалось ${FULL - count}"
        const val FULL = 50
        const val START_MESSAGE = "Все места свободны"
        const val END_MESSAGE = "Пассажиров слишком много!"
    }
}