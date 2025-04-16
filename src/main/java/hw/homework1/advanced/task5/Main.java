package hw.homework1.advanced.task5;

public class Main {
    public static void main(String[] args) {
        MusicTrack musicTrack1 = new MusicTrack("Runaway", "Aurora", "POP");
        MusicTrack musicTrack2 = new MusicTrack("Candy", "Doja Cat", "HIP-HOP");
        MusicTrack musicTrack3 = new MusicTrack("Fashion Killa", "ASAP Rocky", "RAP");
        MusicTrack musicTrack4 = new MusicTrack("California King Bed", "Rihanna", "POP");

        MusicLibrary musicLibrary = new MusicLibrary();

        musicLibrary.addTrackToLibrary(musicTrack1);
        musicLibrary.addTrackToLibrary(musicTrack2);
        musicLibrary.addTrackToLibrary(musicTrack3);
        musicLibrary.addTrackToLibrary(musicTrack4);

        musicLibrary.removeTrackFromLibrary(musicTrack3);

        musicLibrary.showAllTracksByGenre("POP");
    }
}
