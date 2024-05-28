 // Retrieve the session attribute value using JavaScript
    // Retrieve the session attribute value using JavaScript
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "getSessionName", true);

    xhr.onload = function() {
        if (xhr.status === 200) {
            var username = xhr.responseText;
            console.log(username);
            document.getElementById("usernameSpan").textContent = username;
        }
    };
    xhr.send();
 window.onload = function() {
  var userCity;
  var cty = new XMLHttpRequest();
  cty.open("GET", "getSessionCity", true);

  cty.onload = function() {
    if (cty.status === 200) {
      userCity = cty.responseText;
      console.log(userCity);
      document.getElementById("cityInput").value = userCity;
      checkWeather(userCity);
      forecastWeather(userCity);
    }
  };

  cty.send();
};
