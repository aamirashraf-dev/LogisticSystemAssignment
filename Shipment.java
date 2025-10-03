public abstract class Shipment {
    private String id;
    private String receiver;
    private double weight;

    public Shipment(String id, String receiver, double weight) {
        this.id = id;
        this.receiver = receiver;
        this.weight = weight;
    }

    public String getId() { 
        return id; 
    }
    public String getReceiver() { 
        return receiver; 
    }
    public double getWeight() { 
        return weight; 
    }

    public abstract String getInfo();
}

