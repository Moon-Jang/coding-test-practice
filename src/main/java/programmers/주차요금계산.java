package programmers;

import java.util.HashMap;
import java.util.Map;

public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Fee fee = new Fee(fees[0], fees[1], fees[2], fees[3]);
        Map<String, Car> cars = new HashMap<>();

        for (String record : records) {
            String[] r = record.split(" ");

            if (r[2].equals("IN")) {
                if (cars.get(r[1]) != null) {
                    cars.get(r[1]).enter(r[0]);
                    continue;
                }

                Car car = new Car(r[1]);
                car.enter(r[0]);
                cars.put(r[1], car);
                continue;
            }

            if (r[2].equals("OUT")) {
                cars.get(r[1]).leave(fee, r[0]);
                continue;
            }
        }

        // 12시 까지 나가지 않은 차들 요금 정산
        cars.values().stream()
                .filter(car -> car.getLeaveTime() == 0)
                .forEach(car -> car.leave(fee, "23:59"));

        return cars.values()
                .stream()
                .sorted((a,b) -> Integer.valueOf(a.getCarNumber()) - Integer.valueOf(b.getCarNumber()))
                .map(car -> car.getParkingFee())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    class Fee {
        private final int basicTime;
        private final int basicRate;
        private final int unitTime;
        private final int unitRate;

        public Fee(int basicTime, int basicRate, int unitTime, int unitRate) {
            this.basicTime = basicTime;
            this.basicRate = basicRate;
            this.unitTime = unitTime;
            this.unitRate = unitRate;
        }

        public int settle(Car car) {
            if (car.getCumulativeTime() <= basicTime) {
                return basicRate;
            }

            int overTime = car.getCumulativeTime() - basicTime;
            int extra = overTime % unitTime == 0 ? 0 : 1;
            int overRate = (overTime / unitTime  + extra) * unitRate;

            return basicRate + overRate;
        }
    }

    class Car {
        private final String carNumber;
        private int enterTime;
        private int leaveTime;
        private int cumulativeTime;
        private int parkingFee;

        public Car(String carNumber) {
            this.carNumber = carNumber;
        }

        private int calculateTime(String str) {
            String[] s = str.split(":");
            final int hours = Integer.valueOf(s[0]) * 60;
            final int minutes = Integer.valueOf(s[1]);
            return hours + minutes;
        }

        public void enter(String enterTimeStr) {
            enterTime = calculateTime(enterTimeStr);
            leaveTime = 0;
        }
        public void leave(Fee fee, String leaveTimeStr) {
            leaveTime = calculateTime(leaveTimeStr);
            cumulativeTime += leaveTime - enterTime;
            parkingFee = fee.settle(this);
        }

        public int getParkingFee() {
            return parkingFee;
        }

        public int getLeaveTime() {
            return leaveTime;
        }

        public int getCumulativeTime() {
            return cumulativeTime;
        }

        public String getCarNumber() {
            return carNumber;
        }
    }
}
