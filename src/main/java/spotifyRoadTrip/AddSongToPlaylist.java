package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.special.SnapshotResult;
import com.wrapper.spotify.requests.data.playlists.AddItemsToPlaylistRequest;
import org.apache.hc.core5.http.ParseException;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashSet;

public class AddSongToPlaylist {
  private static final String accessToken = "insert accessToken here";
  private static final String playlistId = CreatePlaylist.createPlaylist_Sync();
  //private static String[] uris = SearchTracks.searchTracks_Sync();
  
  public static void setURIs(String[] newURIs) {	//sets newURI based on new song
	    uris = newURIs;
	}
  
  public static String getPlaylistURI() {
	  return playlistId;
  }

  
  private static String[] uris = GetUserTopTrack.getUsersTopTracks_Sync();


  public static void addItemsToPlaylist_Sync() {
    try {
    	
    final SpotifyApi spotifyApi = new SpotifyApi.Builder()
	.setAccessToken(accessToken)
	.build();
	final AddItemsToPlaylistRequest addItemsToPlaylistRequest = spotifyApi
	.addItemsToPlaylist(playlistId, uris)
//    			          .position(0)
    .build(); 
		  
		  
      final SnapshotResult snapshotResult = addItemsToPlaylistRequest.execute();

      System.out.println("Snapshot ID: " + snapshotResult.getSnapshotId());
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  
  

  public static void main(String[] args) throws JSONException, IOException {
	
	/*
	GetDirections a = new GetDirections();
	a.setMap();
	a.readJSON();
	a.getFinalCities();
	
	for(String city: a.finalCities) {
		SearchTracks.setSong(city);
		addItemsToPlaylist_Sync();
		setURIs(SearchTracks.searchTracks_Sync());
	}
	
	System.out.println(a.finalCities.size());
	*/
	
	
	//addItemsToPlaylist_sync(); //DO THIS IF SERACHING FOR TOP SONGS
	
	/*
    for(int i = 0; i < 2; i++) {	//loops through to set new songs each time
      addItemsToPlaylist_Sync();
	  SearchTracks.setSong("Hello");
	  setURIs(SearchTracks.searchTracks_Sync());
	  
    }
    */
	 addItemsToPlaylist_Sync();
  }  
}