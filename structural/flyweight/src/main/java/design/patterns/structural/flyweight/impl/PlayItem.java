package design.patterns.structural.flyweight.impl;

public class PlayItem {
    
    private Long id;
    
    private String songName;
    
    private byte[] song = new byte[1000000];

    public PlayItem() {
    }
    public PlayItem(Long id, String songName) {
        this.id = id;
        this.songName = songName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    @Override
    public String toString() {
        return "PlayItem{" + "id=" + id + ", songName=" + songName + '}';
    }
    
    
}
