package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import org.apache.hc.core5.http.ParseException;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class GetUserTopArtist {
  private static final String accessToken = "insert accessToken here";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists()
          .limit(10)
//          .offset(0)
          .time_range("long_term")
    .build();

  public static void getUsersTopArtists_Sync() {
    try {
      final Paging<Artist> artistPaging = getUsersTopArtistsRequest.execute();

      System.out.println("Total: " + artistPaging.getTotal());
      
      String toPrint = "";
      for(Artist a: artistPaging.getItems()) {
    	  toPrint += a;
      }
      //System.out.println(toPrint);
      
      /*
      JSONObject o = new JSONObject(toPrint);
      String n = o.getString("name");
      System.out.println(n);
      */
      
      //cleans output into new="artist", format
      int i = 0;
      String finalString = "";
      while(i < toPrint.length()) {
    	  int start = toPrint.indexOf("name=");
    	  int end = toPrint.indexOf(", externalUrls");
    	  finalString += toPrint.substring(start, end) + ", ";
    	  i = end + 1;
    	  toPrint = toPrint.substring(i);
      }
      System.out.println(finalString);
      
      
      
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    getUsersTopArtists_Sync();
  }
}