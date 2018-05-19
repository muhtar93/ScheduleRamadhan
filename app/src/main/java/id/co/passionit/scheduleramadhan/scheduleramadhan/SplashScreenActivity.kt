package id.co.passionit.scheduleramadhan.scheduleramadhan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {
    var handler: Handler? = null
    val SPLASH_DELAY: Long = 3000

    internal val runnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handler = Handler()

        handler!!.postDelayed(runnable, SPLASH_DELAY)
    }

    override fun onDestroy() {
        if (handler != null) {
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }

}
