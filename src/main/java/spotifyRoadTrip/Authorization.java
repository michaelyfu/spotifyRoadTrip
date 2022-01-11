package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;

import java.net.URI;

public class Authorization { 
  private static final String clientId = "insert clientID here";
  private static final String clientSecret = "insert clientSecret here";
  private static final URI redirectUri = SpotifyHttpManager.makeUri("http://localhost");

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setClientId(clientId)
    .setClientSecret(clientSecret)
    .setRedirectUri(redirectUri)
    .build();
  private static final AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
//          .state("x4xkmn9pu3j6ukrs8n")

          .scope("user-top-read playlist-modify-public playlist-modify-private playlist-read-private user-library-read")
//          .show_dialog(true)
    .build();

  public static URI authorizationCodeUri_Sync() {
    final URI uri = authorizationCodeUriRequest.execute();
    //add scope to authorization request

    System.out.println("URI: " + uri.toString());
    return uri;
  }
  /*
  public static String getURI() {
	  String URI = uri.toString();
	  return URI;
  }
  */
/*
  public static void main(String[] args) {
    authorizationCodeUri_Sync();
  }
*/
}