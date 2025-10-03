public class Letter extends Shipment {
    public Letter(String id, String receiver, double weight) {
        super(id, receiver, weight);
    }

    @Override
    public String getInfo() {
        return "Letter [" + getId() + "] till " + getReceiver() + " | Vikt: " + getWeight() + " kg";
    }
}

