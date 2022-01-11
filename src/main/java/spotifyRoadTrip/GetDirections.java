package spotifyRoadTrip;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.json.*;




public class GetDirections {
	private static final String APIKey = "insert GoogleMaps API Key here";
	private static String origin = "966 West Paces Ferry Rd NW";
	private static String destination = "New York";
	private static HashMap<String, ArrayList<String>> totalCities;
	private static ArrayList<String> foundCities = new ArrayList<String>();
	public static HashSet<String> finalCities = new HashSet<String>();
	
	public static void setOrigin(String newOrigin) {
		origin = newOrigin;
	}
	
	public static String getOrigin() {
		return origin;
	}
	
	
	public GetDirections() {

	}
	
	public static void setMap() {
		totalCities = new HashMap<String, ArrayList<String>>();		
		ArrayList<String> AL = new ArrayList<String>();
		ArrayList<String> AK = new ArrayList<String>();
		ArrayList<String> AZ = new ArrayList<String>();
		ArrayList<String> AR = new ArrayList<String>();
		ArrayList<String> CA = new ArrayList<String>();
		ArrayList<String> CO = new ArrayList<String>();
		ArrayList<String> CT = new ArrayList<String>();
		ArrayList<String> DE = new ArrayList<String>();
		ArrayList<String> DC = new ArrayList<String>();
		ArrayList<String> FL = new ArrayList<String>();
		ArrayList<String> GA = new ArrayList<String>();
		ArrayList<String> HI = new ArrayList<String>();
		ArrayList<String> ID = new ArrayList<String>();
		ArrayList<String> IL = new ArrayList<String>();
		ArrayList<String> IN = new ArrayList<String>();
		ArrayList<String> IA = new ArrayList<String>();
		ArrayList<String> KS = new ArrayList<String>();
		ArrayList<String> KY = new ArrayList<String>();
		ArrayList<String> LA = new ArrayList<String>();
		ArrayList<String> ME = new ArrayList<String>();
		ArrayList<String> MD = new ArrayList<String>();
		ArrayList<String> MA = new ArrayList<String>();
		ArrayList<String> MI = new ArrayList<String>();
		ArrayList<String> MN = new ArrayList<String>();
		ArrayList<String> MS = new ArrayList<String>();
		ArrayList<String> MO = new ArrayList<String>();
		ArrayList<String> MT = new ArrayList<String>();
		ArrayList<String> NE = new ArrayList<String>();
		ArrayList<String> NV = new ArrayList<String>();
		ArrayList<String> NH = new ArrayList<String>();
		ArrayList<String> NJ = new ArrayList<String>();
		ArrayList<String> NM = new ArrayList<String>();
		ArrayList<String> NY = new ArrayList<String>();
		ArrayList<String> NC = new ArrayList<String>();
		ArrayList<String> ND = new ArrayList<String>();
		ArrayList<String> OH = new ArrayList<String>();
		ArrayList<String> OK = new ArrayList<String>();
		ArrayList<String> OR = new ArrayList<String>();
		ArrayList<String> PA = new ArrayList<String>();
		ArrayList<String> RI = new ArrayList<String>();
		ArrayList<String> SC = new ArrayList<String>();
		ArrayList<String> SD = new ArrayList<String>();
		ArrayList<String> TN = new ArrayList<String>();
		ArrayList<String> TX = new ArrayList<String>();
		ArrayList<String> UT = new ArrayList<String>();
		ArrayList<String> VT = new ArrayList<String>();
		ArrayList<String> VA = new ArrayList<String>();
		ArrayList<String> WA = new ArrayList<String>();
		ArrayList<String> WV = new ArrayList<String>();
		ArrayList<String> WI = new ArrayList<String>();
		ArrayList<String> WY = new ArrayList<String>();
		
		AL.add("Alabama");
		AL.add("Birmingham");
		AL.add("Huntsville");
		AL.add("Montgomery");
		AL.add("Mobile");
		AL.add("Tuscaloosa");
		totalCities.put("AL", AL);
		
		AK.add("Alaska");
	    totalCities.put("AK", AL);
	    
	    AZ.add("Arizona");
	    AZ.add("Phoenix");
	    AZ.add("Tucson");
	    AZ.add("Chandler");
	    AZ.add("Scottsdale");
	    totalCities.put("AZ", AZ);
	    
	    AR.add("Arkansas");
	    AR.add("Little Rock");
	    AR.add("Fayetteville");
	    AR.add("Springdale");
	    totalCities.put("AR", AR);
	    
	    CA.add("California");
	    CA.add("Los Angeles"); //might need to add LA
	    CA.add("San Diego");
	    CA.add("San Jose");
	    CA.add("San Francisco");
	    CA.add("Fresno");
	    CA.add("Sacramento");
	    totalCities.put("CA", CA);
	    
	    CO.add("Colorado");
	    CO.add("Denver");
	    CO.add("Colorado Springs");
	    CO.add("Aurora");	//might check this out
	    totalCities.put("CO", CO);
	    
	    CT.add("Conneticut");
	    CT.add("Bridegport");
	    CT.add("New Haven");
	    CT.add("Stamford");
	    CT.add("Hartford");
	    CT.add("Waterbury");
	    totalCities.put("CT", CT);
	    
	    DE.add("Delaware");
	    DE.add("Wilmington");
	    DE.add("Dover");
	    DE.add("Newark");
	    totalCities.put("DE", DE);
	    
	    DC.add("Washington, D.C.");
	    totalCities.put("DC", DC);
	    
	    FL.add("Florida");
	    FL.add("Jacksonville");
	    FL.add("Miami");
	    FL.add("Tampa");
	    FL.add("Orlando");
	    FL.add("St. Petersburg");
	    FL.add("Tallahassee");
	    totalCities.put("FL", FL);
	    
	    GA.add("Georgia");
	    GA.add("Atlanta");
	    GA.add("Augusta");
	    GA.add("Columbus");
	    GA.add("Macon");
	    GA.add("Savannah");
	    totalCities.put("GA", GA);
	    
	    HI.add("Hawaii");
	    HI.add("Honolulu");
	    HI.add("Kailua");
	    totalCities.put("HI", HI);
	    
	    ID.add("Idaho");
	    ID.add("Boise");
	    ID.add("Meridian");
	    ID.add("Nampa");
	    ID.add("Idaho Falls");
	    totalCities.put("ID", ID);
	    
	    IL.add("Illinois");
	    IL.add("Chicago");
	    IL.add("Aurora");
	    IL.add("Naperville");
	    IL.add("Rockford");
	    IL.add("Springfield");
	    totalCities.put("IL", IL);
	    
	    IN.add("Indiana");
	    IN.add("Indianapolis");
	    IN.add("Fort Wayne");
	    IN.add("Evansville");
	    IN.add("South Bend");
	    IN.add("Carmel");
	    totalCities.put("IN", IN);
	    
	    IA.add("Iowa");
	    IA.add("Des Moines");
	    IA.add("Cedar Rapids");
	    IA.add("Davenport");
	    IA.add("Sioux City");
	    totalCities.put("IA", IA);
	    
	    KS.add("Kansas");
	    KS.add("Wichita");
	    KS.add("Kansas City");
	    KS.add("Topeka");
	    totalCities.put("KS", KS);
	    
	    KY.add("Kentucky");
	    KY.add("Louisville");
	    KY.add("Lexington");
	    totalCities.put("KY", KY);
	    
	    LA.add("Louisiana");
	    LA.add("New Orleans");
	    LA.add("Baton Rouge");
	    LA.add("Lafayette");
	    totalCities.put("LA", LA);
	    
	    ME.add("Maine");
	    ME.add("Portland");
	    totalCities.put("ME", ME);
	    
	    MD.add("Maryland");
	    MD.add("Baltimore");
	    MD.add("Annapolis");
	    totalCities.put("MD", MD);
	    
	    MA.add("Massachusetts");
	    MA.add("Boston");
	    MA.add("Springfield");
	    MA.add("Cambridge"); //might cause other songs
	    totalCities.put("MA", MA);
	    
	    MI.add("Michigan");
	    MI.add("Detroit");
	    MI.add("Grand Rapids");
	    MI.add("Ann Arbor");
	    totalCities.put("MI", MI);
	    
	    MN.add("Minnesota");
	    MN.add("Minneapolis");
	    totalCities.put("MN", MN);
	    
	    MS.add("Mississippi");
	    MS.add("Jackson");
	    totalCities.put("MS", MS);
	    
	    MO.add("Missouri");
	    MO.add("Kansas City");
	    MO.add("Saint Louis");
	    MO.add("Springfield");
	    totalCities.put("MO", MO);
	    
	    MT.add("Montana");
	    MT.add("Billings");
	    totalCities.put("MT", MT);
	    
	    NE.add("Nebraska");
	    NE.add("Omaha");
	    NE.add("Lincoln");
	    totalCities.put("NE", NE);
	    
	    NV.add("Nevada");
	    NV.add("Las Vegas");
	    NV.add("Henderson");
	    NV.add("Reno");
	    totalCities.put("NV", NV);
	    
	    NH.add("New Hampshire");
	    NH.add("Manchester");
	    NH.add("Nashua");
	    NH.add("Concord");
	    NH.add("Dover");
	    totalCities.put("NH", NH);
	    
	    NJ.add("New Jersey");
	    NJ.add("Newark");
	    NJ.add("Jersey City");
	    NJ.add("Paterson");
	    NJ.add("Edison");
	    totalCities.put("NJ", NJ);
	    
	    NM.add("New Mexico");
	    NM.add("Albuquerque");
	    NM.add("Las Cruces");
	    NM.add("Rio Rancho");
	    NM.add("Santa Fe");
	    totalCities.put("NM", NM);
	    
	    NY.add("New York");
	    NY.add("New York City");
	    NY.add("Buffalo");
	    NY.add("Rochester");
	    NY.add("Syracuse");
	    NY.add("Albany");
	    NY.add("Manhattan");
	    totalCities.put("NY", NY);
	    
	    NC.add("North Carolina");
	    NC.add("Charlotte");
	    NC.add("Raleigh");
	    NC.add("Greensboro");
	    NC.add("Durham");
	    NC.add("Winston-Salem");
	    totalCities.put("NC", NC);
	    
	    ND.add("North Dakota");
	    ND.add("Fargo");
	    totalCities.put("ND", ND);
	    
	    OH.add("Ohio");
	    OH.add("Columbus");
	    OH.add("Cleveland");
	    OH.add("Cincinnati");
	    OH.add("Toledo");
	    OH.add("Akron");
	    totalCities.put("OH", OH);
	    
	    OK.add("Oklahoma");
	    OK.add("Oklahoma City");
	    OK.add("Tulsa");
	    totalCities.put("OK", OK);
	    
	    OR.add("Oregon");
	    OR.add("Portland");
	    OR.add("Hillsboro");
	    totalCities.put("OR", OR);
	    
	    PA.add("Pennsylvania");
	    PA.add("Philadelphia");
	    PA.add("Philly");
	    PA.add("Pittsburgh");
	    totalCities.put("PA", PA);
	    
	    RI.add("Rhode Island");
	    RI.add("Providence");
	    RI.add("Warwick");
	    totalCities.put("RI", RI);
	    
	    SC.add("South Carolina");
	    SC.add("Charleston");
	    SC.add("Columbia");
	    SC.add("Rock Hill");
	    totalCities.put("SC", SC);
	    
	    SD.add("South Dakota");
	    SD.add("Sioux Falls");
	    SD.add("Rapid City");
	    totalCities.put("SD", SD);
	    
	    TN.add("Tennessee");
	    TN.add("Nashville");
	    TN.add("Memphis");
	    TN.add("Knoxville");
	    TN.add("Chattanooga");
	    totalCities.put("TN", TN);
	    
	    TX.add("Texas");
	    TX.add("Houston");
	    TX.add("San Antonio");
	    TX.add("Dallas");
	    TX.add("Austin");
	    TX.add("Fort Worth");
	    totalCities.put("TX", TX);
	    
	    UT.add("Utah");
	    UT.add("Salt Lake City");
	    totalCities.put("UT", UT);
	    
	    VT.add("Vermont");
	    VT.add("Burlington");
	    totalCities.put("VT", VT);
	    
	    VA.add("Virginia");
	    VA.add("Virginia Beach");
	    VA.add("Norfolk");
	    VA.add("Chesapeake");
	    VA.add("Richmond");
	    totalCities.put("VA", VA);
	    
	    WA.add("Washington");
	    WA.add("Seattle");
	    totalCities.put("WA", WA);
	    
	    WV.add("West Virginia");
	    WV.add("Charleston");
	    totalCities.put("WV", WV);
	    
	    WI.add("Wisconsin");
	    WI.add("Milwaukee");
	    WI.add("Madison");
	    WI.add("Green Bay");
	    totalCities.put("WI", WI);
	    
	    WY.add("Wyoming");
	    WY.add("Cheyenne");
	    totalCities.put("WY", WY);
	    
	}
	
	/**
	 * Calculate distance between two points in latitude and longitude taking
	 * into account height difference. If you are not interested in height
	 * difference pass 0.0. Uses Haversine method as its base.
	 * 
	 * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
	 * el2 End altitude in meters
	 * @returns Distance in Meters
	 */
	public static double distance(double lat1, double lat2, double long1,
	        double long2) {

	    final int R = 6371; // Radius of the earth

	    double latDistance = Math.toRadians(lat2 - lat1);
	    double lonDistance = Math.toRadians(long2 - long1);
	    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
	            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
	            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = R * c * 1000; // convert to meters

	    distance = Math.pow(distance, 2);

	    return Math.sqrt(distance);
	}
	
	public static double midPointLat(double lat1,double lat2,double long1,double long2){

	    double dLong = Math.toRadians(long2 - long1);

	    //convert to radians
	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	    long1 = Math.toRadians(long1);

	    double Bx = Math.cos(lat2) * Math.cos(dLong);
	    double By = Math.cos(lat2) * Math.sin(dLong);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double long3 = long1 + Math.atan2(By, Math.cos(lat1) + Bx);

	    //print out in degrees
	    //System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(long3));
	    return Math.toDegrees(lat3);
	}
	
	public static double midPointLong(double lat1,double lat2,double long1,double long2){

	    double dLong = Math.toRadians(long2 - long1);

	    //convert to radians
	    lat1 = Math.toRadians(lat1);
	    lat2 = Math.toRadians(lat2);
	    long1 = Math.toRadians(long1);

	    double Bx = Math.cos(lat2) * Math.cos(dLong);
	    double By = Math.cos(lat2) * Math.sin(dLong);
	    double lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
	    double long3 = long1 + Math.atan2(By, Math.cos(lat1) + Bx);

	    //print out in degrees
	    //System.out.println(Math.toDegrees(lat3) + " " + Math.toDegrees(long3));
	    return Math.toDegrees(long3);
	}
	
	public static String Geocoding() {
		//System.out.println("Geocoding URL: https://maps.googleapis.com/maps/api/geocode/json?address="+origin+"&key="+APIKey);
		origin = origin.replaceAll(" ", "%20");
		String toReturn = "https://maps.googleapis.com/maps/api/geocode/json?address="+origin+"&key="+APIKey;
		return toReturn;
		//https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyBXbpr8p43aRmHBbu7WzRCzSLgLuoGJe4c
	}
	
	public static String Routes() {
		destination = destination.replaceAll(" ", "%20");
		origin = origin.replaceAll(" ", "%20");
		String toReturn = "https://maps.googleapis.com/maps/api/directions/json?origin="+origin+"&destination="+destination+"&key="+APIKey;
		//https://maps.googleapis.com/maps/api/directions/json?origin=Toronto&destination=Montreal&key=AIzaSyBXbpr8p43aRmHBbu7WzRCzSLgLuoGJe4c
		return toReturn;
	}
	
	public static String searchPlaces() {
		origin = origin.replaceAll(" ", "%20");
		String toReturn = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+origin+"&radius=50000&type=city+hall&key="+APIKey;
		//https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=41.3377564,-75.72378209999999&radius=500000&type=city+hall&key=AIzaSyBXbpr8p43aRmHBbu7WzRCzSLgLuoGJe4c
		return toReturn;
	}
	
	  private static String readAll(Reader rd) throws IOException {
		    StringBuilder sb = new StringBuilder();
		    int cp;
		    while ((cp = rd.read()) != -1) {
		      sb.append((char) cp);
		    }
		    return sb.toString();
		  }
	
		  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }
  	
	public static void readJSON() throws JSONException, IOException {
	    JSONObject json = readJsonFromURL(Routes());
	    //System.out.println(json.toString());
	   // System.out.println(json.getJSONObject("routes").getJSONObject("legs").getJSONObject("steps"));
	    JSONArray routes = json.getJSONArray("routes");
	    JSONObject test = (JSONObject) routes.get(0);	    
	    //System.out.println(legs.length());
	    JSONArray legs = test.getJSONArray("legs");
	    JSONObject test2 = (JSONObject) legs.get(0);
	    //System.out.println(test2);
	    JSONArray steps = test2.getJSONArray("steps");
	    JSONObject test3 = (JSONObject) steps.get(0);
	    //System.out.println(test3);
	    //System.out.println(steps.length());
	    //System.out.println(steps.getClass());
	    	    
	    ArrayList<String> diffSteps = new ArrayList<String>();     
	    JSONArray jsonArray = (JSONArray)steps; 
	    if (jsonArray != null) { 
	       int len = jsonArray.length();
	       for (int i=0;i<len;i++){ 
	        diffSteps.add(jsonArray.get(i).toString());
	       } 
	    } 
	    /*
	     * have all the steps so far and need to get the distance, startLat, startLong, stopLat, stopLong for every step
	     *
	     */
	    
	    int distance = 30; // 30 miles
	    
	    //cuts down based on distance—if feet, removes from arrayList
	    for(int i = 0; i < diffSteps.size(); i++) {
	    	String a = diffSteps.get(i);
	  
	    	int distanceUnit = a.indexOf("ft\",\"value");
	    	if(distanceUnit >= 0) {
	    		diffSteps.remove(i); //how to remove a string with an arraylist while iterating
	    		i--;
	    	}
	    }
	    
	    //ArrayList<Stat> data = new ArrayList<Stat>(diffSteps.size()); //r = each step, c = various stats
	    
	    ArrayList<Stat> midpointVals = new ArrayList<Stat>();

	   
	    
	    for(int i = 0; i < diffSteps.size(); i++) {
	    	String a = diffSteps.get(i);
	    	//System.out.println(a);
	    	int distanceStartIndex = a.lastIndexOf("\"distance\":{\"text\":\"") + 20;
	    	int distanceStopIndex = a.lastIndexOf("\",\"value") - 2;
	    	
	    	int startLat = a.indexOf("lat\":") + 5;
	    	int startLat2 = a.indexOf("},\"distance");
	    	double Lat1 = Double.parseDouble(a.substring(startLat,startLat2).trim());
	    	
	    	int startLong = a.indexOf("lng\":") + 5;
	    	int startLong2 = a.indexOf(",\"lat");
	    	double Long1 = Double.parseDouble(a.substring(startLong,startLong2).trim());
	    	
	    	int stopLat = a.lastIndexOf("lat\":") + 5;
	    	int stopLat2 = a.lastIndexOf("},");
	    	double Lat2 = Double.parseDouble(a.substring(stopLat,stopLat2).trim());
	    	//System.out.println("},\"maneuver");
	    	
	    	//System.out.println(stopLat);
	    	//System.out.println(stopLat2);
	    	
	    	int stopLong = a.lastIndexOf("lng\":") + 5;
	    	int stopLong2 = a.lastIndexOf(",\"lat");
	    	double Long2 = Double.parseDouble(a.substring(stopLong,stopLong2).trim());
	    		    	
	    	double tempDistance = Double.parseDouble(a.substring(distanceStartIndex,distanceStopIndex).trim());
	    	//System.out.println(tempDistance);
			
	    	if(tempDistance > distance) {
	    		int newSteps = ((int) (tempDistance / distance)) + 1;
	    		
	    		double[][] pythag = new double[newSteps][2];
	    		
	    		for(int k = 0; k < pythag.length - 1; k++) {
	    			double x = Lat1 + ((Lat2 - Lat1) / pythag.length) * (k + 1);
	    			double y = Long1 + ((Long2 - Long1) / pythag.length) * (k + 1);
	    			pythag[k][0] = x;
	    			pythag[k][1] = y;
	    		}
	    		
	    		for(int l = 0; l < pythag.length; l++) {
    				midpointVals.add(new Stat(pythag[l][0], pythag[l][1]));
	    		}
	    	}
	    	
	    	
	    	double midPointLat = midPointLat(Lat1,Lat2,Long1,Long2);
	    	double midPointLong = midPointLong(Lat1,Lat2,Long1,Long2);
	    	midpointVals.add(new Stat(midPointLat,midPointLong));

	    	//System.out.println(a.substring(distanceStartIndex,distanceStopIndex));  
	    	//System.out.println(a.substring(startLat, startLat2));
	    	//System.out.println(a.substring(startLong, startLong2));
	    	//System.out.println(a.substring(stopLat, stopLat2));
	    	//System.out.println(a.substring(stopLong, stopLong2));
	    }	
	    
	    for(Stat a: midpointVals) {
	    	setOrigin(a.midpointLat+","+a.midpointLong);
	    	json = readJsonFromURL(searchPlaces());
	    	String text = json.toString();
		    /*
		    JSONArray results = json.getJSONArray("results");
		    JSONObject stage1 = (JSONObject) routes.get(0);	 
		    JSONArray name = json.getJSONArray("name");
		    JSONObject stage2 = (JSONObject) routes.get(0);
		    */
		    int startIndex = text.indexOf("name\":\"");
		    //System.out.println(startIndex);
		    int stopIndex;
		    
		    while(startIndex >= 0) {
		    	startIndex += 7;
		    	stopIndex = text.indexOf(",", startIndex) - 1;
		    	//System.out.println("stop" + stopIndex);
		    	String city = text.substring(startIndex, stopIndex);
		    	//System.out.println(city);
		    	text.replace("name\":\"", " ");
		    	startIndex = text.indexOf("name\":\"", stopIndex);
		    	foundCities.add(city);
		    }
	    	
		    
	    }
	    
	    
	  
	    
	    //int distance, int startlat, int startLong, int stopLat, int stopLong
	    //Stat[] data = new Stat[diffSteps.size()]; //r = each step, c = various stats
	    //1d array where every step is a column and you cxan access the values through the instance variables attatched to the class
	    
	    
	    /*
	    JSONArray distance = test3.getJSONArray("distance");
	    JSONObject test4 = (JSONObject) distance.get(0);
	    System.out.println(test4);	    
	    */
	    
	    //return json.toString();
	}
	
	
	
	public static HashSet<String> getFinalCities(){
		for(String city: foundCities) {
			for(ArrayList<String> cityList: totalCities.values()) {
				if(cityList.contains(city) == true) {
					finalCities.add(city);
				}
			}
		}
		
		for(String a: finalCities) {
			System.out.println(a);
		}
		
		return finalCities;
	}
	
	
	  public static JSONObject readJsonFromURL(String url) throws IOException, JSONException {
		    InputStream is = new URL(url).openStream();
		    try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readAll(rd);
		      JSONObject json = new JSONObject(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
		  }

	
	public static void main(String[] args) throws JSONException, IOException {
		setMap();
		System.out.println("Geocoding: " + Geocoding());
		System.out.println("Routes: " + Routes());
		
		System.out.println(totalCities.values());
		
		/*
		for(String s: totalCities.keySet()) {
			System.out.println(s + ": " + totalCities.get(s));
		}
		*/
				
	    //System.out.println(json.get("id"));
		readJSON();
		getFinalCities();
		//System.out.println(readJSON());
	}
	
	static class Stat{
		int distance;
		int startLat;
		int startLong; 
		int stopLat;
		int stopLong;
		double midpointLat;
		double midpointLong;

		public Stat(int distance, int startlat, int startLong, int stopLat, int stopLong){
			distance = 0;
			startLat = 0;
			startLong = 0;
			stopLat = 0;
			stopLong = 0;
		}
		
		public Stat(double midLat, double midLong) {
			midpointLat = midLat;
			midpointLong = midLong;
		}

		public String toString(){
			return "midpointLat: " + midpointLat + " " + "midpointLong: " + midpointLong;
		}
	}
	
}
