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
        bindings.buttonMinus.isEnabled = false

        fun setBussInfo(count: Int) {
            bindings.counter.text = "$count"
            when (count) {
                ZERO -> {
                    bindings.buttonMinus.isEnabled = false
                    bindings.textInfo.setTextColor(Color.GREEN)
                    bindings.textInfo.text = START_MESSAGE
                    bindings.reset.visibility = View.INVISIBLE
                }
                in (1..FULL) -> {
                    bindings.buttonMinus.isEnabled = true
                    bindings.textInfo.setTextColor(Color.BLUE)
                    bindings.textInfo.text = free
                    bindings.reset.visibility = View.INVISIBLE
                }
                else -> {
                    bindings.reset.visibility = View.VISIBLE
                    bindings.textInfo.setTextColor(Color.RED)
                    bindings.textInfo.text = END_MESSAGE
                }
            }
        }

        bindings.buttonMinus.setOnClickListener {
            setBussInfo(--count)
        }

        bindings.buttonPlus.setOnClickListener {
            setBussInfo(++count)
        }

        bindings.reset.setOnClickListener {
            count = ZERO
            setBussInfo(count)
        }
    }

    companion object {
        const val ZERO = 0
        var count = ZERO
        val free: String
            get() = "Мест осталось ${FULL - count}"
        const val FULL = 50
        const val START_MESSAGE = "Все места свободны"
        const val END_MESSAGE = "Пассажиров слишком много!"
    }
}