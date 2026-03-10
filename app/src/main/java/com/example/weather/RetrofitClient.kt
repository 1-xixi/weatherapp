package com.example.weather
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClient {
    // Gson 实例，可自定义配置
    const val BASE_URL = "http://v1.yiketianqi.com/"
    const val APP_ID = "11371844"
    const val APP_SECRET = "WSrnlO1C"
    private val gsonConverter = GsonConverterFactory.create()
    // 2. 创建 Retrofit 对象
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverter)
            .build()
    }
    //Retrofit 会根据这个接口帮你生成实际调用的实现类
    val apiService: ApiService = retrofit.create(ApiService::class.java)
}