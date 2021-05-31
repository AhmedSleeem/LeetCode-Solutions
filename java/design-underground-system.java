  class UndergroundSystem {
        class Pair implements Comparable<Pair>{
            String from,to;

            public Pair(String from, String to) {
                this.from = from;
                this.to = to;
            }

            @Override
            public int compareTo(Pair o) {
                if (from.equals(o.from)){
                    if (to.equals(o.to))return 0;
                    return to.compareTo(o.to);
                }
                return from.compareTo(o.from);
            }
        }

        class PairStringInt{
            String station;
            int time;

            public PairStringInt(String station, int time) {
                this.station = station;
                this.time = time;
            }
        }
        TreeMap<Pair,ArrayList<Integer>>map;
        HashMap<Integer,PairStringInt>IdStationMap;

        public UndergroundSystem() {
            map=new TreeMap<>();
            IdStationMap=new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            IdStationMap.put(id,new PairStringInt(stationName,t));

        }

        public void checkOut(int id, String stationName, int t) {
            PairStringInt pairStringInt = IdStationMap.get(id);
            Pair pair = new Pair(pairStringInt.station, stationName);
            ArrayList<Integer> list = map.getOrDefault(pair, new ArrayList<>());
            list.add(t-pairStringInt.time);
            map.put(pair,list);
            IdStationMap.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
                Pair pair=new Pair(startStation,endStation);
                if (!map.containsKey(pair))return 0.0;
            ArrayList<Integer> integers = map.get(pair);
            int ans=0;
            for (int i = 0; i < integers.size(); i++) {
                ans+=integers.get(i);
            }
            return (1.0*ans)/integers.size();
        }
    }


/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */