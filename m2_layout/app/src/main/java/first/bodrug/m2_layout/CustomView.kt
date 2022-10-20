package first.bodrug.m2_layout

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import first.bodrug.m2_layout.databinding.MyCustomViewBinding

class CustomView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    devStyleAttr: Int = 0
) : LinearLayout(context, attrs, devStyleAttr) {
    private val binding = MyCustomViewBinding.inflate(LayoutInflater.from(context))
    init {
        addView(binding.root)
        binding.textUp.text = "верхняя строчка, настроенная из кода"
        binding.textDown.text = "нижняя строчка, настроенная из кода"
    }
}
