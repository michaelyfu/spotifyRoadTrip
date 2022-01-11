package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Track;
import com.wrapper.spotify.requests.data.tracks.GetTrackRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class GetTrack {
  private static final String accessToken = "insert accessToken";
  private static final String id = "6IW6mD0OrfYXXkTgdLBQ83";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final GetTrackRequest getTrackRequest = spotifyApi.getTrack(id)
//          .market(CountryCode.SE)
    .build();

  public static void getTrack_Sync() {
    try {
      final Track track = getTrackRequest.execute();

      System.out.println("Name: " + track.getName());
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
  
  public static void main(String[] args) {
	    getTrack_Sync();
	  }
}