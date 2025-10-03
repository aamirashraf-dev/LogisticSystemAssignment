public class Pallet extends Shipment {
    public Pallet(String id, String receiver, double weight) {
        super(id, receiver, weight);
    }

    @Override
    public String getInfo() {
        return "Pallet [" + getId() + "] till " + getReceiver() + " | Vikt: " + getWeight() + " kg";
    }
}

