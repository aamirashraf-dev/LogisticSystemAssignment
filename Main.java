import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shipment> shipments = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("\n Logistiksystem");
            System.out.println("1. Lägg till Parcel");
            System.out.println("2. Lägg till Letter");
            System.out.println("3. Lägg till Pallet");
            System.out.println("4. Visa alla försändelser");
            System.out.println("5. Sortera försändelser efter vikt");
            System.out.println("6. Sök försändelse via ID");
            System.out.println("7. Sök försändelser via mottagare");
            System.out.println("8. Avsluta");
            System.out.print("Välj: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Parcel
                    System.out.print("ID: ");
                    String pid = scanner.nextLine();
                    System.out.print("Mottagare: ");
                    String prec = scanner.nextLine();
                    System.out.print("Vikt: ");
                    double pw = scanner.nextDouble();
                    scanner.nextLine();
                    shipments.add(new Parcel(pid, prec, pw));
                    break;
                case 2: //Letter
                    System.out.print("ID: ");
                    String lid = scanner.nextLine();
                    System.out.print("Mottagare: ");
                    String lrec = scanner.nextLine();
                    System.out.print("Vikt: ");
                    double lw = scanner.nextDouble();
                    scanner.nextLine();
                    shipments.add(new Letter(lid, lrec, lw));
                    break;
                case 3: // Pallet
                    System.out.print("ID: ");
                    String palid = scanner.nextLine();
                    System.out.print("Mottagare: ");
                    String palrec = scanner.nextLine();
                    System.out.print("Vikt: ");
                    double palw = scanner.nextDouble();
                    scanner.nextLine();
                    shipments.add(new Pallet(palid, palrec, palw));
                    break;
                case 4: // Visa alla
                    System.out.println("\nAlla försändelser:");
                    for (Shipment s : shipments) {
                        System.out.println(s.getInfo());
                    }
                    break;
                case 5: // Bubble sort
                    for (int i = 0; i < shipments.size() - 1; i++) {
                        for (int j = 0; j < shipments.size() - i - 1; j++) {
                            if (shipments.get(j).getWeight() > shipments.get(j + 1).getWeight()) {
                                Shipment temp = shipments.get(j);
                                shipments.set(j, shipments.get(j + 1));
                                shipments.set(j + 1, temp);
                            }
                        }
                    }
                    System.out.println("Försändelserna har sorterats efter vikt!");
                    break;
                case 6: // Sök via ID
                    System.out.print("Ange ID att söka: ");
                    String searchId = scanner.nextLine();
                    Shipment found = findShipmentById(shipments, searchId);
                    if (found != null) {
                        System.out.println("Hittad försändelse: " + found.getInfo());
                    } else {
                        System.out.println("Ingen försändelse med ID: " + searchId);
                    }
                    break;
                case 7: // Sök via mottagare
                    System.out.print("Ange mottagare: ");
                    String receiver = scanner.nextLine();
                    List<Shipment> results = findShipmentsByReceiver(shipments, receiver);
                    if (!results.isEmpty()) {
                        System.out.println("Försändelser till " + receiver + ":");
                        for (Shipment s : results) {
                            System.out.println(s.getInfo());
                        }
                    } else {
                        System.out.println("Inga försändelser hittades för mottagare: " + receiver);
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("Avslutar...");
                    break;
                default:
                    System.out.println("Fel val, försök igen.");
            }
        }

        scanner.close();
    }

    // Sök försändelse via ID
    public static Shipment findShipmentById(List<Shipment> shipments, String id) {
        for (Shipment s : shipments) {
            if (s.getId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Sök försändelser via mottagare
    public static List<Shipment> findShipmentsByReceiver(List<Shipment> shipments, String receiver) {
        List<Shipment> results = new ArrayList<>();
        for (Shipment s : shipments) {
            if (s.getReceiver().equalsIgnoreCase(receiver)) {
                results.add(s);
            }
        }
        return results;
    }
}
