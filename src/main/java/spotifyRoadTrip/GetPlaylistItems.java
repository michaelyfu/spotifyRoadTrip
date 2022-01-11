package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistTrack;
import com.wrapper.spotify.model_objects.specification.SavedTrack;
import com.wrapper.spotify.requests.data.playlists.GetPlaylistsItemsRequest;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.ArrayList;

public class GetPlaylistItems {
  private static final String accessToken = "insert accessToken";
  private static final String playlistId = "4OdWrZMsNXhDIgsRoZcRVT";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static ArrayList<String> playlistSongs = new ArrayList<String>();
  private static int totalSongs = 1200; 
  private static GetPlaylistsItemsRequest getPlaylistsItemsRequest = spotifyApi
    .getPlaylistsItems(playlistId)
//          .fields("description")
          .limit(100)
//          .offset(0)
//          .market(CountryCode.SE)
//          .additionalTypes("track,episode")
    .build();

  public static ArrayList<String> getPlaylistsItems_Sync() {
    try {
      final Paging<PlaylistTrack> playlistTrackPaging = getPlaylistsItemsRequest.execute();

      for(int j = 0; j < totalSongs; j+=50) {
          getPlaylistsItemsRequest = spotifyApi.getPlaylistsItems(playlistId).limit(50).offset(j).build();
        	
          Paging<PlaylistTrack> savedTrackPaging = getPlaylistsItemsRequest.execute();
          
          //System.out.println("Total: " + savedTrackPaging.getTotal());
          
          
          String toPrint = "";
          for(PlaylistTrack t: savedTrackPaging.getItems()) {
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
        	  playlistSongs.add(a.trim());
          }  
          }
          
          for(String a: playlistSongs) {
        	  //System.out.println(a);
          }
          
          return playlistSongs;
      
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
      
      return null; 
    }
  }


  public static void main(String[] args) {
    getPlaylistsItems_Sync();
  }
}