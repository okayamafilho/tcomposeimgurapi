import okhttp3.Interceptor
import okhttp3.Response


//18º Você cria a classe Interceptor
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        //19º igual que está no postamn em Headers
        val request = requestBuilder.addHeader(
            "Authorization", "Client-ID 2ad070f9295648f"
//            "Authorization", "Client-ID fe873980dfd40ee"
        ).build()
        return chain.proceed(request)
    }


}