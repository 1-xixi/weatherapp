package com.example.weather
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.weather.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnQuery.setOnClickListener {
            val city = binding.etCity.text.toString().trim()
            lifecycleScope.launch {
                try {
                    // 调用 Retrofit API
                    val response = RetrofitClient.apiService.getWeather(
                        city = city,
                        appid = RetrofitClient.APP_ID,
                        appsecret = RetrofitClient.APP_SECRET
                    )

                    if (response.isSuccessful) {
                        val data = response.body()
                        Log.i("WeatherTest", "网络成功返回: $data")
                        // 将天气信息显示在主页面布局中
                        if (data != null) {
                            binding.wea.text = data.wea
                            binding.date.text = data.date
                            binding.tem.text = data.tem
                            binding.winSpeed.text = data.winSpeed
                        }
                    } else {
                        Log.e("WeatherTest", "请求失败: ${response.code()}  ${response.message()}")
                    }
                } catch (e: Exception) {
                    Log.e("WeatherTest", "异常: ${e.message}", e)
                }

            }
        }
    }
}
//西安 成都