public class TrafficTicket {
    private String driverName;
    private int speed;
    private int speedLimit;
    private boolean paid;

    public static int totalFinesIssued = 0;

    public TrafficTicket(String driverName, int speed, int speedLimit) {
        this.driverName = driverName;
        this.speed = speed;
        this.speedLimit = speedLimit;
        this.paid = false;

        totalFinesIssued++;
    }

    public int calculateFine() {
        int overspeed = speed - speedLimit;
        if (overspeed <= 0) return 0;
        if (overspeed < 20) return 500;
        if (overspeed < 40) return 1500;
        return 3000;
    }

    public void pay() { paid = true; }
    public boolean isPaid() { return paid; }
}