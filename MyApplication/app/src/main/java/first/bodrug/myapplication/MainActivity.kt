package first.bodrug.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import first.bodrug.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var count = 0
        binding.SkillBoxTextView.text = "0"

        binding.minus.setOnClickListener {
            count--
            binding.SkillBoxTextView.text = "$count"
            binding.SkillBoxTextView.textSize = count.toFloat()
        }
        binding.plus.setOnClickListener {
            count++
            binding.SkillBoxTextView.text = "$count"
            binding.SkillBoxTextView.textSize = count.toFloat()
        }


    }
}