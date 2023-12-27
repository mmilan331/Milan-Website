document.addEventListener('DOMContentLoaded', function(){
  const currentDate = new Date();
  const year = currentDate.getFullYear();
  const month = String(currentDate.getMonth() + 1).padStart(2, '0');
  const day = String(currentDate.getDate()).padStart(2, '0');
  const formattedDate = `${year}-${month}-${day}`;
  console.log(formattedDate);

  //Latitude and Longitude set to Chicago
  //Lat = 41.8781
  //Long = 87.6298
  fetch(`https://api.open-meteo.com/v1/gfs?latitude=41.8781&longitude=87.6298&current=temperature_2m&daily=temperature_2m_max,temperature_2m_min,precipitation_probability_max&temperature_unit=fahrenheit&timezone=America%2FChicago&start_date=${formattedDate}&end_date=${formattedDate}`)
    .then(response => response.json())
    .then(data => {
      console.log(data);
      const temperature = data.current.temperature_2m;
      const max = data.daily.temperature_2m_max[0];
      const min = data.daily.temperature_2m_min[0];
      const precipPercent = data.daily.precipitation_probability_max[0];
      document.getElementById("currentTemp").innerHTML = `<p>${temperature}°F</p>`;
      document.getElementById("weather").innerHTML = `<p>Max: ${max} °F <br> Min: ${min} °F <br> Precipitation: ${precipPercent}%</p>`;
  })
  .catch(error => {
      console.error('Error fetching weather data:', error);
  });
});

function updateTime() {
  const currentTimeString = new Date().toLocaleTimeString();
  document.getElementById("time").innerText = currentTimeString;
}
setInterval(updateTime, 1000);
updateTime();
