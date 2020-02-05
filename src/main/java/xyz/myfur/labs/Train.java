package xyz.myfur.labs;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Train {
    private int id;
    private Date date;
    private TrainStation destination;

    private List<Place> places;

    public Train(int id,TrainStation destination, Date date, Place... places) {
        this.id = id;
        this.date = date;
        this.places = Arrays.asList(places);
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void addPlaces(Place... places) {
        this.places.addAll(Arrays.asList(places));
    }

    public int getPlatskartPlaces() {
        return places.stream().filter((x) -> x.getType().equals(PlaceType.PLATSKART)).toArray().length;
    }

    public int getLuxPlaces() {
        return places.stream().filter((x) -> x.getType().equals(PlaceType.LUKS)).toArray().length;
    }

    public int getKupePlaces() {
        return places.stream().filter((x) -> x.getType().equals(PlaceType.KUPE)).toArray().length;
    }

    public int getAllPlaces() {
        return places.size();
    }

    public TrainStation getDestination() {
        return destination;
    }

    public void setDestination(TrainStation destination) {
        this.destination = destination;
    }

    public boolean hasFreeSpaces() {
        return hasFreeSpaces(PlaceType.ALL);
    }

    public boolean hasFreeSpaces(PlaceType type) {
        if (PlaceType.ALL == type)
            return places.stream().anyMatch(Place::isFree);

        return places.stream().anyMatch(x -> x.isFree() && x.getType() == type);
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", date=" + date +
                ", destination=" + destination.getName() +
                ", places=" + places +
                '}';
    }
}
