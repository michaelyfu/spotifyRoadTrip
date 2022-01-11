package spotifyRoadTrip;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		try {
			SpotifyApi spotifyApi = new SpotifyApi.Builder()
					  .setClientId("insert ClientId")
					  .setClientSecret("insert ClientSecret")
					  .setRedirectUri(new URI("http://localhost"))
					  
					  //.setAccessToken("BQBG251hfK75nJvED7Z0J7J4nL1VORDA94vusWfZ6eEVUTCHGv6vsZ2PSTsV8lH9aDcPu7yp-sWFwtzz41Dcny9Rgx5yTBwsbmintK2xtKZBidN0xI6sanpMNUGHjeUO1y4kSSZXDiSGdYNks_Dav2SYFvBUyRB7GSizWw")
					  //.setRefreshToken("AQDZu4lGHFHWiLNJ5abZwGSXDd69fARxq18jcqWpVVCr-YnKbSxFDwxGf5xVjJovYktRjnHWr7VL3PHKD-CGjHiNTLG0e31GNMa69jD-E9DuombxvMluizQAezpdmMaQ43M")
					  //.build();

					  
					  //SET ACCESS TOKEN AND SET REFRESH TOKEN DON'T WORK YET
					  //.setAccessToken("BQBz4aYQakSX7WstBNRDml3DbEVr8ltIOdwdr3uCEmmHBrKNgkkFtsnYlA2pA1HU1mO_Wo5-fLX3eHRcj7JJamfDE-XTaX3qL3RWYuTZ0sYXk-wETu6fN9IsACMHVwUjOzhZCjzCXu4nUn1pDZGSK29t5w3fdTGHA3HTqg");
					  // .setRefreshToken("AQCtngyLbRukzml-BN8DC18r856FGGOeC8drRryv3CJ_i3r7ThdRw_nwbfPLhvqGq38W5zJ1tc30VuTD3w455SjbmtuM3j5X4UyCiclFiHrc4aLf_tV54CYkrjp3fn22gXM");
					  .build();
			System.out.println(spotifyApi);
			
			
			ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials()
					.build();
			
			System.out.println(clientCredentialsRequest);			
			 
			 
			clientCredentials_Sync(spotifyApi, clientCredentialsRequest);
			//GetTrack.getTrack_Sync();
			Authorization.authorizationCodeUri_Sync();
			//AuthorizationRequest.authorizationCode_Sync();
			
			
			Desktop desktop = java.awt.Desktop.getDesktop();
			
			try {
				desktop.browse(Authorization.authorizationCodeUri_Sync());
				System.out.println("Code: " + Authorization.authorizationCodeUri_Sync().getUserInfo());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clientCredentials_Sync(SpotifyApi spotifyApi, ClientCredentialsRequest clientCredentialsRequest) {
		try {
		   ClientCredentials clientCredentials = clientCredentialsRequest.execute();

		  // Set access token for further "spotifyApi" object usage
		  spotifyApi.setAccessToken(clientCredentials.getAccessToken());

		  System.out.println("Expires in: " + clientCredentials.getExpiresIn());
		} catch (Exception e) {
		  System.out.println("Error: " + e.getMessage());
		}
	}
}




