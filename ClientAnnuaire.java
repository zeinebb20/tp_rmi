import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClientAnnuaire {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IAnnuaire annuaire = (IAnnuaire) registry.lookup("AnnuaireService");
            Scanner sc = new Scanner(System.in);
            int choix;

            do {
                System.out.println("\n1. Ajouter\n2. Rechercher\n3. Lister\n4. Quitter");
                choix = sc.nextInt();
                sc.nextLine(); // Nettoyage buffer

                if (choix == 1) {
                    System.out.print("Nom : "); String n = sc.nextLine();
                    System.out.print("Numéro : "); String p = sc.nextLine();
                    annuaire.ajouterContact(n, p);
                } else if (choix == 2) {
                    System.out.print("Nom à chercher : ");
                    System.out.println("Résultat : " + annuaire.rechercherNumero(sc.nextLine()));
                } else if (choix == 3) {
                    System.out.println("Contacts : " + annuaire.listerContacts());
                }
            } while (choix != 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

