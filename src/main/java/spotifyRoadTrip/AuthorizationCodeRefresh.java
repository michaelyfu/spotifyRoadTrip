package spotifyRoadTrip;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRefreshRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;

public class AuthorizationCodeRefresh {
  private static final String clientId = "insert clientID";
  private static final String clientSecret = "insert clientSecret";
  private static final String refreshToken = "AQC-RyQJ0CnSuMcd2jrqxWQuRQp_lPDvxi759gj1Pf2YJrY_i-ue4DAoDGAiKADekdgSxkzqTr82z6T1IzDkhxd9p1RljSxyXz9bsQ95md8g4A8jLhwYvsopNxeWk2GhJbA";

  private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
    .setClientId(clientId)
    .setClientSecret(clientSecret)
    .setRefreshToken(refreshToken)
    .build();
  private static final AuthorizationCodeRefreshRequest authorizationCodeRefreshRequest = spotifyApi.authorizationCodeRefresh()
    .build();

  public static void authorizationCodeRefresh_Sync() {
    try {
      final AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRefreshRequest.execute();

      // Set access and refresh token for further "spotifyApi" object usage
      spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
      
      System.out.println("Refresh Token: " + refreshToken);
      System.out.println("Access Token: " + authorizationCodeCredentials.getAccessToken());
      
      System.out.println("Expires in: " + authorizationCodeCredentials.getExpiresIn());
    } catch (IOException | SpotifyWebApiException | ParseException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    authorizationCodeRefresh_Sync();
  }
}