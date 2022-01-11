package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Playlist;
import com.wrapper.spotify.requests.data.playlists.CreatePlaylistRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class CreatePlaylist {
  private static final String accessToken = "insert accessToken here";
  private static final String userId = "insert userID here";
  private static final String name = "Top Songs June 2021";
  private static String URI = "";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final CreatePlaylistRequest createPlaylistRequest = spotifyApi.createPlaylist(userId, name)
          .collaborative(false)
          .public_(false)
          .description("Top songs")
    .build();

  public static String createPlaylist_Sync() {
    try {
      final Playlist playlist = createPlaylistRequest.execute();

      System.out.println("Name: " + playlist.getName());
      String fullURI = playlist.getUri();
      URI = fullURI.substring(17);
      System.out.println("URI: " + URI);
      
      return URI;
      
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
      
      return null;
    }
  }

  public static void main(String[] args) {
    createPlaylist_Sync();
  }
}