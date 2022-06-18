package first.bodrug.sculptor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION +
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

       // actionBar?.hide()
        setContentView(R.layout.activity_main)
    }
}