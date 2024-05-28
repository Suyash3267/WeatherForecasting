// Script for current Weather info ,daily forecast widgets & map

    const apiKey = "29bdd96da3f96aa4a9eafefa8afff0fb";
    const apiUrl = "https://api.openweathermap.org/data/2.5/weather?&units=metric&q=";
    const forecastApiUrl = "https://api.openweathermap.org/data/2.5/forecast?&units=metric&q=";

  const searchBox  = document.querySelector(".search input");
    const searchBtn = document.querySelector(".search button");
    const mapIframe = document.getElementById("mapIframe");
    const dailyForecast = document.querySelector(".dailyForecast");

    // Function to fetch current weather data and update the UI
    async function checkWeather(city) {
      try {
        const response = await fetch(apiUrl + city + `&appid=${apiKey}`);
        if (!response.ok) {
          throw new Error("Failed to fetch weather data.");
        }
        const data = await response.json();
        console.log(data);

        // Update the UI with weather data
        document.querySelector(".city").innerHTML = data.name;
        document.querySelector(".temp").innerHTML = Math.round(data.main.temp) + "°C";
        document.querySelector(".humidity").innerHTML = data.main.humidity + "%";
        document.querySelector(".wind").innerHTML = data.wind.speed + " km/h";
        document.querySelector(".pressure").innerHTML = data.main.pressure + " hPa";
        document.querySelector(".sunrise").innerHTML = getTimeString(data.sys.sunrise);
        document.querySelector(".sunset").innerHTML = getTimeString(data.sys.sunset);

        showMap(data.coord.lat, data.coord.lon);
        createPivotChartW(data);
      } catch (error) {
        handleError("An error occurred while fetching weather data.");
      }
    }

    // Function to fetch forecast weather data and update the UI
    async function forecastWeather(city) {
      try {
        const response = await fetch(forecastApiUrl + city + `&appid=${apiKey}`);
        if (!response.ok) {
          throw new Error("Failed to fetch forecast data.");
        }
        const data = await response.json();
        console.log(data);

        dailyForecast.innerHTML = ""; // Clear previous forecast

        // Display forecast data in the UI
        for (let i = 0; i < data.list.length; i += 8) {
          const forecast = data.list[i];

          const forecastDate = new Date(forecast.dt * 1000);
          const forecastTime = getTimeString(forecast.dt);
          const forecastIcon = forecast.weather[0].icon;
          const forecastTemp = Math.round(forecast.main.temp) + "°C";

          const forecastItem = document.createElement("div");
          forecastItem.classList.add("forecast-item");

          forecastItem.innerHTML = `
        <div>
          <p class="forecast-date">${forecastDate.toDateString()}</p>
          <p class="forecast-time">${forecastTime}</p>
          <img class="forecast-icon" src="https://openweathermap.org/img/wn/${forecastIcon}.png" alt="Forecast Icon">
          <p class="forecast-temp">${forecastTemp}</p>
          <br><br>
        </div>
      `;

          dailyForecast.appendChild(forecastItem);
        }
      } catch (error) {
        handleError("An error occurred while fetching forecast data.");
      }
    }

    // Function to convert timestamp to time string (HH:MM format)
    function getTimeString(timestamp) {
      const date = new Date(timestamp * 1000);
      const hours = date.getHours().toString().padStart(2, "0");
      const minutes = date.getMinutes().toString().padStart(2, "0");
      return `${hours}:${minutes}`;
    }

    // Function to show map using coordinates (latitude, longitude)
    function showMap(lat, lon) {
      const mapSrc = `https://maps.google.com/maps?q=${lat},${lon}&t=&z=10&ie=UTF8&iwloc=&output=embed&layer=weather`;
      mapIframe.src = mapSrc;
    }

    // Function to handle errors and display error messages
    function handleError(message) {
      // Clear previous error message
      document.querySelector(".error-message").innerHTML = "";

      // Create and display the error message
      const errorMessage = document.createElement("p");
      errorMessage.classList.add("error");
      errorMessage.innerHTML = message;

      document.querySelector(".error-message").appendChild(errorMessage);
    }

    // Event listener for search button
    searchBtn.addEventListener("click", () => {
      const city = searchBox.value;
      if (city) {
        checkWeather(city);
        forecastWeather(city);
      } else {
        handleError("Please enter a valid city name.");
      }
    });

    // Event listener for Enter key
    searchBox.addEventListener("keydown", (event) => {
      if (event.key === "Enter") {
        const city = searchBox.value;
        if (city) {
          checkWeather(city);
          forecastWeather(city);
        } else {
          handleError("Please enter a valid city name.");
        }
      }
    });

    