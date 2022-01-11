package spotifyRoadTrip;

import java.util.HashSet;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.search.simplified.SearchTracksRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.hc.core5.http.ParseException;
import org.json.JSONException;

import java.io.IOException;

public class SearchTracks {
  private static final String accessToken = "insert accessToken here";
  private static String song = "peaches";
  //private static String songURI = "";
  private static String[] songResults;
  private static String[] songURIs;
  
  public static void setSong(String newSong) {
	    song = newSong;
	}



  public static String[] searchTracks_Sync() {
    try {

	  final SpotifyApi spotifyApi = new SpotifyApi.Builder()
	    .setAccessToken(accessToken)
	    .build();
	  final SearchTracksRequest searchTracksRequest = spotifyApi.searchTracks(song)
//    	  .market(CountryCode.SE)
      .limit(5)
//    	  .offset(0)
//    	  .includeExternal("audio")
	  .build();
	  
      final Paging<Track> trackPaging = searchTracksRequest.execute();

      System.out.println("Total: " + trackPaging.getTotal());
      
      //finds first song on playlist and finds the URI
      /*
      String first = trackPaging.getItems()[0] + "";  
      songURI = first.substring(first.lastIndexOf("uri=spotify:track:") + 18);      
      //System.out.println(songURI);
      //finds songURI of a track
       */
      
      String tempSearches = "";
      
      for(int j = 0; j < trackPaging.getItems().length; j++) {
    	  tempSearches += trackPaging.getItems()[j];
      }
      //System.out.println(tempSearches);
      
      int i = 0;
      String secondString = "";
      while(i < tempSearches.length()) {
    	  int start = tempSearches.indexOf("Track(name=");
    	  int end = tempSearches.indexOf(", artists=");
    	  i = end + 1;
    	  if(i <= 0) {
    		  break;
    	  }
    	  //System.out.println(start);
    	  //System.out.println(end);
    	  secondString += tempSearches.substring(start, end) + " ";
    	  tempSearches = tempSearches.substring(i);
      }
      //System.out.println(secondString);
      
      String finalString = secondString.replace("Track(", "");
      //System.out.println(finalString);
      
      songResults = finalString.split("name=");
      songResults = ArrayUtils.remove(songResults, 0); //removes the extra  first space
      
      for(String a: songResults) {
    	  System.out.println(a);
      }
      
      String URIs = "";
      
      for(Track t: trackPaging.getItems()) {
    	  URIs += t.getUri();
      }

      String[] tempSongsURI = URIs.split("spotify:track:");
      songURIs = new String[tempSongsURI.length];
      
      for(String a: tempSongsURI) {
    	  a = "spotify:track:" + a;
    	  //System.out.println(a);
      }
      
      
      for(int j = 0; j < tempSongsURI.length; j++) {
    	  songURIs[j] = "spotify:track:" + tempSongsURI[j];
      }
      songURIs = ArrayUtils.remove(songURIs, 0);
      
      
      for(String song: songURIs) {
    	  System.out.println(song);
      }     
      
      
      return songURIs;
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }
  

  public static void main(String[] args) throws JSONException, IOException {

    searchTracks_Sync();

  }
}