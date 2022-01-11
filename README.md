# spotifyRoadTrip
 
@author Michael Fu
@version 1.0, Updated 28 April 2021

The Spotify Road Trip generator takes in an origin point and a destination and generates a playlist of songs about the cities you travel through. For example, if you're travelling from Georgia to New York, the playlist will have songs such as "Welcome to New York" by Taylor Swift, "Atlanta Girls" by Trash Panda, "Snow in Newark" by Ryan Hemsworth, "Philadelphia Shore" by Mind Explorer, and more. The Spotify Road Trip generator can also create playlists of your top songs of the past month, 6 months, and all time based on how many songs you've been playing the most.

To initially connect the Spotify API to your Spotify Account:
1) Run the Tester and copy the code created in the URL 
2) Copy that code and paste it into the AuthorizationRequest class inside the instane variable "code". Then, run that class to recieve the access token
3) Copy the access token and paste it into the String instance variable "accessToken" for every class you use/run

To generate playlist based on locations:
	you will need:
		-CreatePlaylist
		-SearchTracks
		-GetDirections
		-AddSongToPlaylist
1) In CreatePlaylist: 
	1) setUserId to user's spotify username
	2) set playlist Name in instance variable "name"
	3) change description of the playlist in .description()
	4) set collaborative to true/false
	5) set public to true/false
2) In SearchTracks:
	1) set limit of songs per search query in .limit()
3) In GetDirections:
	1) input origin and destination into their respective instance variables
4) In AddSongToPlaylist:
	1) run main method

To generate playlist of user's top songs:
	you will need:
		-CreatePlaylist
		-GetUserTopTracks
		-AddSongToPlaylist
		
1) In CreatePlaylist:
	1) setUserId to user's spotify username
	2) set playlist Name in instance variable "name"
	3) change description of the playlist in .description()
	4) set collaborative to true/false
	5) set public to true/false
2) In GetUserTopTracks:
	1) set limit to number of songs in .limit()
	2) set time range to short_term, medium_term, or long_term for search with .time_range()
3) In AddSongToPlaylist:
	1) run main method


Classes:
1) Tester—The tester class creates a clientCredentialRequest URL to ask user to login and grab the code for the AuthorizationRequest.
2) Authorization—The Authorization class sets the scopes of the user in the clientCredentialRequest.
3) AuthorizationRequest—With the generated code from the Tester, the AuthorizationRequest class generates an accessToken for the user.
4) AuthorizationCodeRefresh—The AuthorizationCodeRefresh creates a RefreshToken for the user.
5) AddSongToPlaylist—AddsongToPlaylist allows users to add a song to a playlist through a song's URI.
6) CheckUserSavedPlaylist—CheckUserSavedPlaylist checks if a playlist exists based on its playlist URI.
7) GetDirections—GetDirections takes in an origin, destination, and outputs the valid cities along the route from an origin to a destination.
8) GetTrack—GetTrack returns the name of a song based on a song id.
9) GetUserTopArtist—GetUserTopArtist returns a list of the user's top artists.
10) GetUserTopTrack—GetUserTopTrack returns a list of the user's top tracks.
11) SearchTracks—Searches a query on Spotify and returns those URIs.
