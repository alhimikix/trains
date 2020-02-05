package xyz.myfur.labs;

public class Place {
    private PlaceType type;
    private boolean free;

    public Place(PlaceType type, boolean free) {
        this.type = type;
        this.free = free;
    }

    public PlaceType getType() {
        return type;
    }

    public void setType(PlaceType type) {
        this.type = type;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    @Override
    public String toString() {
        return "Place{" +
                "type=" + type +
                ", free=" + free +
                '}';
    }
}
