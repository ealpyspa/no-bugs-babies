package hw.homework1.advanced.task5;

import java.util.HashMap;
import java.util.HashSet;

public class MusicLibrary {
    private HashMap<String, HashSet<MusicTrack>> playlist;

    public MusicLibrary() {
        this.playlist = new HashMap<>();
    }

    public void addTrackToLibrary(MusicTrack track) {
        if(!playlist.containsKey(track.getGenre())){
            HashSet<MusicTrack> newGenreSet = new HashSet<>();
            playlist.put(track.getGenre(), newGenreSet);
        }
        HashSet<MusicTrack> genreSet = playlist.get(track.getGenre());
        genreSet.add(track);
    }

    public void removeTrackFromLibrary(MusicTrack track) {
        if (playlist.containsKey(track.getGenre())) {
            HashSet<MusicTrack> setByGenre = playlist.get(track.getGenre());
            setByGenre.remove(track);
        }
    }

    public void showAllTracksByGenre(String genre) {
        if(playlist.containsKey(genre)) {
            HashSet<MusicTrack> setByGenre = playlist.get(genre);
            setByGenre.forEach(System.out::println);
        }
    }
}
