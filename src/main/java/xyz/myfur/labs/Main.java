package xyz.myfur.labs;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        List<TrainStation> stations = new ArrayList<>();
        List<Train> trains = new ArrayList<>();

        readStations(stations);
        readTrains(stations,trains);

        Rail rail = new Rail(stations, trains);

        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine().trim();
        TrainStation ts = stations.stream().filter(x -> x.getName().equals(a)).findFirst().get();

        System.out.println();
        System.out.println(rail.inTravel(ts));
        System.out.println();
        System.out.println(rail.inTravelForDestination(ts));
        System.out.println();
        System.out.println(rail.inTravelAndHasFreePlaces(ts));


    }

    private static void readStations(List<TrainStation> stations) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String a = scanner.nextLine().trim();
            if (a.equals("/q")) break;
            if (stations.stream().anyMatch(x -> x.getName().equals(a))) {
                System.out.println("Такая станция уже есть!");
                continue;
            }

            TrainStation station = new TrainStation(a);

            stations.add(station);
        }
    }

    private static void readTrains(List<TrainStation> stations, List<Train> trains) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String a = scanner.nextLine().trim();
            String b = scanner.nextLine().trim();
            if (a.equals("/q")) break;
            TrainStation ts = stations.stream().filter(x -> x.getName().equals(b)).findFirst().orElse(null);
            if (ts == null) {
                System.out.println("Такой станции нет!");
                continue;
            }

            if (trains.stream().anyMatch(x -> x.getId() == Integer.parseInt(a))) {
                System.out.println("Такой поезд уже есть!");
                continue;
            }


            Train train = new Train(Integer.parseInt(a),ts, new Date(Long.parseLong(a)-(new Random()).nextInt(1000000000)-1000000000/2),new Place(PlaceType.PLATSKART,false),new Place(PlaceType.LUKS,true));

            trains.add(train);
        }
    }
}
