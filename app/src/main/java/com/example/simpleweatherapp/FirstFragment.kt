package com.example.simpleweatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import coil.load
import com.example.simpleweatherapp.databinding.FragmentFirstBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    // IMPORTANT: Get your own API key at https://www.weatherapi.com/
    private val apiKey = "80f5bb6dadf140c0adf211928253001"

    private val weatherService: WeatherService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherService::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSearch.setOnClickListener {
            val city = binding.editTextCity.text.toString()
            if (city.isNotEmpty()) {
                fetchWeather(city)
            } else {
                Toast.makeText(context, "Please enter a city", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun fetchWeather(city: String) {
        if (apiKey == "YOUR_API_KEY_HERE") {
            Toast.makeText(context, "Please set your API Key in FirstFragment.kt", Toast.LENGTH_LONG).show()
            return
        }

        binding.progressBar.isVisible = true
        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = weatherService.getCurrentWeather(apiKey, city)
                binding.progressBar.isVisible = false
                if (response.isSuccessful && response.body() != null) {
                    updateUI(response.body()!!)
                } else {
                    Toast.makeText(context, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                binding.progressBar.isVisible = false
                Toast.makeText(context, "Failure: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateUI(weather: WeatherResponse) {
        binding.textViewCityName.text = getString(R.string.city_format, weather.location.name, weather.location.country)
        binding.textViewTemperature.text = getString(R.string.temp_format, weather.current.tempC)
        binding.textViewCondition.text = weather.current.condition.text
        binding.textViewHumidity.text = getString(R.string.humidity_format, weather.current.humidity)
        
        val iconUrl = "https:${weather.current.condition.icon}"
        binding.imageViewWeather.load(iconUrl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
