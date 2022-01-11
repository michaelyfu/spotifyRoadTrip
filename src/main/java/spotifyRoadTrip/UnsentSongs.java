package spotifyRoadTrip;

import java.util.ArrayList;

public class UnsentSongs {
	private static ArrayList<String> savedSongs = GetUserSavedTracks.getUsersSavedTracks_Sync();
	private static ArrayList<String> playlistSongs = GetPlaylistItems.getPlaylistsItems_Sync();
	private static ArrayList<String> unsentSongs = new ArrayList<String>();

	public static void main(String[] args) {
		for(int i = 0; i < (int) Math.min(playlistSongs.size(), savedSongs.size());i++) {
			if(playlistSongs.contains(savedSongs.get(i)) == false){
				unsentSongs.add(savedSongs.get(i));
			}
		}
		
		for(String a: unsentSongs) {
			System.out.println(a);
		}
		
		System.out.println(playlistSongs.contains("Eastside"));
	}
}
