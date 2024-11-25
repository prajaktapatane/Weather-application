
package com.s1;
import java.net.URL;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class next extends HttpServlet {

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
           
	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	PrintWriter pw=response.getWriter();
		
	String city=request.getParameter("city");
                    	
	String apikey="9af508416a747c173c67eb7ff4fe4358";
		 
	String apiurl="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid="+apikey;
	try
	{
	//API integration
	URL url= new URL(apiurl);
	HttpURLConnection connection=(HttpURLConnection) url.openConnection();
	connection.setRequestMethod("GET");
	//reading the data from network
	InputStream inputstream=connection.getInputStream();
	InputStreamReader reader=new InputStreamReader(inputstream);
		
	//want to store in string
	StringBuilder responseContent=new StringBuilder();
		
	Scanner scanner=new Scanner(reader);
		
	while(scanner.hasNext())
                     {
	responseContent.append(scanner.nextLine());
			
	}
		
            Gson gson=new Gson();
            JsonObject jsonobject=gson.fromJson(responseContent.toString(), JsonObject.class);
		
//date and time
 //Date & Time
        long dateTimestamp = jsonobject.get("dt").getAsLong() * 1000;
        String date = new Date(dateTimestamp).toString();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        //Temperature
        double temperatureKelvin = jsonobject.getAsJsonObject("main").get("temp").getAsDouble();
        int temperatureCelsius = (int) (temperatureKelvin - 273.15);
       
        //Humidity
        int humidity = jsonobject.getAsJsonObject("main").get("humidity").getAsInt();
        
        //Wind Speed
        double windSpeed = jsonobject.getAsJsonObject("wind").get("speed").getAsDouble();
        
        //Weather Condition
        String weatherCondition = jsonobject.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        request.setAttribute("date", date);
        request.setAttribute("time",formattedDate);
        request.setAttribute("city", city);
        request.setAttribute("temperature", temperatureCelsius);
        request.setAttribute("weatherCondition", weatherCondition); 
        request.setAttribute("humidity", humidity);    
        request.setAttribute("windSpeed", windSpeed);
        request.setAttribute("weatherData", responseContent.toString());
        connection.disconnect();
}
catch(Exception e)
{	
    pw.println(e);
}
request.getRequestDispatcher("newjsp.jsp").forward(request, response);
}



 }
    

   
  

