public class Parcel extends Shipment {
    public Parcel(String id, String receiver, double weight) {
        super(id, receiver, weight);
    }

    @Override
    public String getInfo() {
        return "Parcel [" + getId() + "] till " + getReceiver() + " | Vikt: " + getWeight() + " kg";
    }
}

