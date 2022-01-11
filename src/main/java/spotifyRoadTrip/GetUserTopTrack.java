package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class GetUserTopTrack {
  private static final String accessToken = "insert accessToken here";
  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static String[] topSongs;
  private static String[] topSongsURIs;
  private static final GetUsersTopTracksRequest getUsersTopTracksRequest = spotifyApi.getUsersTopTracks()
          .limit(50)
//          .offset(0)
          .time_range("short_term")
    .build();

  public static String[] getUsersTopTracks_Sync() {
    try {
      final Paging<Track> trackPaging = getUsersTopTracksRequest.execute();

      System.out.println("Total: " + trackPaging.getTotal());
           
      String toPrint = "";
      String popularityVals = "";
      for(Track t: trackPaging.getItems()) {
    	  toPrint += t;
    	  popularityVals += t.getPopularity() + " ";
      }
      
      String[] popularityVal = popularityVals.split(" ");
      for(String b: popularityVal) {
    	  //System.out.println(b);
      }
     //System.out.println(toPrint);
      
     
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
      
      
      //gets all top songs in a String array
      topSongs = finalString.split("name=");
      topSongs = ArrayUtils.remove(topSongs, 0); //removes the extra  first space
     
      for(int h = 0; h < topSongs.length; h++) {
    	  topSongs[h] = topSongs[h] + "popularity: " + popularityVal[h];
      }
      
      for(String a: topSongs) {
    	  System.out.println(a);
      }

      
      String URIs = "";
      for(Track t: trackPaging.getItems()) {
    	  URIs += t.getUri();
      }
      //System.out.println(URIs);
      
      String[] tempSongsURI = URIs.split("spotify:track:");
      topSongsURIs = new String[tempSongsURI.length];
      
      for(String a: tempSongsURI) {
    	  a = "spotify:track:" + a;
    	  //System.out.println(a);
      }
      
      
      for(int j = 0; j < tempSongsURI.length; j++) {
    	  topSongsURIs[j] = "spotify:track:" + tempSongsURI[j];
      }
      topSongsURIs = ArrayUtils.remove(topSongsURIs, 0);
      
      
      for(String song: topSongsURIs) {
    	  System.out.println(song);
      }
      
      
      
      return topSongsURIs;
      
      //return topSongs;
             
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
	return null;
  }

  public static void main(String[] args) {
    getUsersTopTracks_Sync();
  }
}