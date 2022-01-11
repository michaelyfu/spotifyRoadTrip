package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.requests.data.library.CheckUsersSavedTracksRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class CheckUserSavedPlaylist {
  private static final String accessToken = "BQAV4c1N4K_yVcmqvvdHF7ycV5IRR83AO69C4LLvH8OjXmnS3NfVLt0fb8dD0tMJdULxBu8SeDYjYQ0auNQjHA-jvVkHoONPPxUTzY7qiMVNnsGKzlhYYP70coBjAHjmCQR96ZziQgp35wCjqVK9Nkvw1MuT5SwTETtornMJZioTLqCNIVor6_v7c66Em-z2WbyUn0SH8cONk4e4w6lCiwneUJED5a5GnTleep_teTA0HLxc6oU";

  private static final String[] ids = new String[]{"wqqhppfkkyfags6neiop3zawv"};

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setAccessToken(accessToken)
    .build();
  private static final CheckUsersSavedTracksRequest checkUsersSavedTracksRequest = spotifyApi.checkUsersSavedTracks(ids)
    .build();

  public static void checkUsersSavedTracks_Sync() {
    try {
      final Boolean[] booleans = checkUsersSavedTracksRequest.execute();

      System.out.println("Length: " + booleans.length);
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    checkUsersSavedTracks_Sync();
  }
}