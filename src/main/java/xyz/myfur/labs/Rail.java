package xyz.myfur.labs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Rail {
    private List<TrainStation> stations;

    private List<Train> trains;

    public Rail(List<TrainStation> stations, List<Train> trains) {
        this.stations = stations;
        this.trains = trains;
    }

    public List<TrainStation> getStations() {
        return stations;
    }

    public void setStations(List<TrainStation> stations) {
        this.stations = stations;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<Train> inTravel(TrainStation trainStation) throws Exception {
        if (!stations.contains(trainStation)) throw new Exception("Wrong station!");

        return trains
                .stream()
                .filter(x -> x.getDestination().equals(trainStation) && x.getDate().getTime() > System.currentTimeMillis())
                .collect(Collectors.toList());
    }

    public List<Train> inTravelForDestination(TrainStation trainStation) throws Exception {
        if (!stations.contains(trainStation)) throw new Exception("Wrong station!");

        return trains
                .stream()
                .filter(x -> x.getDestination().equals(trainStation))
                .collect(Collectors.toList());
    }

    public List<Train> inTravelAndHasFreePlaces(TrainStation trainStation) throws Exception {
        if (!stations.contains(trainStation)) throw new Exception("Wrong station!");

        return trains
                .stream()
                .filter(x -> x.getDestination().equals(trainStation) && x.hasFreeSpaces())
                .collect(Collectors.toList());
    }


    public void addTrains(Train... trains) {
        this.trains.addAll(Arrays.asList(trains));
    }

    public void addStations(TrainStation... stations) {
        this.stations.addAll(Arrays.asList(stations));
    }

}
