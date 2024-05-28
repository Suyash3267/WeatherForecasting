  // Script for hourly forecast widgets & chart

    function getWeatherD() {
      const city = searchBox.value;
      const apiKey = "9ec2c4fe7e47be1c21c1bdf04bd252ae";
      const weatherUrl = `https://api.openweathermap.org/data/2.5/forecast?q=${city}&units=metric&appid=${apiKey}`;

      axios
        .get(weatherUrl)
        .then(response => {
          const weatherData = response.data;
          displayWeatherD(weatherData);
          createPivotChartW(weatherData);
        })
        .catch(error => {
          console.log(error);
        });
    }

    function displayWeatherD(data) {
      const forecastList2 = data.list;

      let forecastWeather2 = "";
      for (let i = 0; i < 17; i++) {
        const forecast = forecastList2[i];
        const forecastTime = getTimeString2(forecast.dt);
        const forecastTemp = forecast.main.temp;
        const forecastIcon = forecast.weather[0].icon;

        forecastWeather2 += `
      <div style="float: left; height:30px">
        <p style="font-size: 25px;">${forecastTime}
          <img src="http://openweathermap.org/img/w/${forecastIcon}.png" alt="Weather Icon">
          ${forecastTemp}°C</p>
      </div>
    `;
      }

      const weatherForecast_Per3hr = document.getElementById("weatherForecast_Per3hr");
      weatherForecast_Per3hr.innerHTML = forecastWeather2;
    }

    function getTimeString2(timestamp) {
      const date = new Date(timestamp * 1000);
      const hours = date.getHours();
      const minutes = date.getMinutes();
      const ampm = hours >= 12 ? "PM" : "AM";
      return `${hours}:${minutes.toString().padStart(2, "0")} ${ampm}`;
    }

    function createPivotChartW(data) {
      const forecastList = data.list;

      const timeData = [];
      const tempData = [];
      const humidityData = [];
      const windSpeedData = [];
      forecastList.forEach(forecast => {
        const timestamp = forecast.dt;
        const timeString = getTimeString2(timestamp);
        const temperature = forecast.main.temp;
        const humidity = forecast.main.humidity;
        const windSpeed = forecast.wind.speed;
        timeData.push(timeString);
        tempData.push(temperature);
        humidityData.push(humidity);
        windSpeedData.push(windSpeed);
      });

      const pivotChart = document.getElementById("pivotChart").getContext("2d");
      const chart = new Chart(pivotChart, {
        type: "line",
        data: {
          labels: timeData,
          datasets: [
            {
              label: "Temperature (°C)",
              data: tempData,
              backgroundColor: "rgba(127, 170, 170, 0.2)",
              borderColor: "rgba(75, 192, 192, 1)",
              borderWidth: 1,
              fill: true,
            },
            {
              label: "Humidity (%)",
              data: humidityData,
              backgroundColor: "rgba(170, 170, 127, 0.2)",
              borderColor: "rgba(192, 192, 75, 1)",
              borderWidth: 1,
              fill: true,
            },
            {
              label: "Wind Speed (m/s)",
              data: windSpeedData,
              backgroundColor: "rgba(170, 127, 170, 0.2)",
              borderColor: "rgba(192, 75, 192, 1)",
              borderWidth: 1,
              fill: true,
            },
          ],
        },
        options: {
          responsive: true,
          maintainAspectRatio: false,
          scales: {
            x: {
              display: true,
              title: {
                display: true,
                text: "Time",
              },
            },
            y: {
              display: true,
              title: {
                display: true,
                text: "Value",
              },
            },
          },
          plugins: {
            tooltip: {
              enabled: true,
              intersect: false,
              backgroundColor: "rgba(0, 0, 0, 0.8)",
              titleFont: {
                size: 14,
                weight: "bold",
              },
              bodyFont: {
                size: 12,
              },
              callbacks: {
                label: function (context) {
                  const label = context.dataset.label;
                  const value = context.raw.toFixed(2);
                  const unit = context.dataset.label === "Temperature (°C)" ? "°C" : context.dataset.label === "Humidity (%)" ? "%" : "m/s";
                  return `${label}: ${value}${unit}`;
                },
              },
            },
          },
          interaction: {
            mode: "index",
            intersect: false,
          },
        },
      });

      // Additional Chart Customizations
      chart.options.plugins.legend = {
        display: true,
        position: "top",
        labels: {
          font: {
            size: 14,
          },
        },
      };

      chart.update();
    }

