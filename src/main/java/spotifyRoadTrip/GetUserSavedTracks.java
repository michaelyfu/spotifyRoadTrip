package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.SavedTrack;
import com.wrapper.spotify.requests.data.library.GetUsersSavedTracksRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class GetUserSavedTracks {
  private static final String accessToken = "insert accessToken";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static ArrayList<String> savedSongs = new ArrayList<String>();
  private static int totalSongs = 1200;
  private static GetUsersSavedTracksRequest getUsersSavedTracksRequest = spotifyApi.getUsersSavedTracks()
          .limit(50)
          .offset(0)
//          .market(CountryCode.SE)
    .build();

  public static ArrayList<String> getUsersSavedTracks_Sync() {
    try {   
    
      for(int j = 0; j < totalSongs; j+=50) {
      getUsersSavedTracksRequest = spotifyApi.getUsersSavedTracks().limit(50).offset(j).build();
    	
      Paging<SavedTrack> savedTrackPaging = getUsersSavedTracksRequest.execute();
      
      //System.out.println("Total: " + savedTrackPaging.getTotal());
      
      
      String toPrint = "";
      for(SavedTrack t: savedTrackPaging.getItems()) {
    	  toPrint += t;
      }
      //System.out.println(savedTrackPaging.toString());

     
      int i = 0;
      String secondString = "";
      while(i < toPrint.length()) {
    	  int start = toPrint.indexOf("Track(name=");
    	  int end = toPrint.indexOf(", artists=");
    	  i = end + 1;
    	  if(i <= 0) {
    		  break;
    	  }
    	  //System.out.println(start);
    	  //System.out.println(end);
    	  secondString += toPrint.substring(start, end) + " ";
    	  toPrint = toPrint.substring(i);
      }
      //System.out.println(secondString);
      
      String finalString = secondString.replace("Track(", "");
      //System.out.println(finalString); 
      
      
      String[] allSongs;
      //gets all songs in a String array
      allSongs = finalString.split("name=");
      allSongs = ArrayUtils.remove(allSongs, 0); //removes the extra first space

      for(String a: allSongs) {
    	  //System.out.println(a);
    	  savedSongs.add(a.trim());
      }  
      }
      
      for(String a: savedSongs) {
    	  //System.out.println(a);
      }
      
      return savedSongs;
      
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
      
      return null;
    }
  }

  public static void main(String[] args) {
    getUsersSavedTracks_Sync();
  }
}