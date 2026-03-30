import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurAnnuaire {
    public static void main(String[] args) {
        try {
            IAnnuaire annuaire = new AnnuaireImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Port différent pour éviter les conflits
            registry.rebind("AnnuaireService", annuaire);
            System.out.println("Serveur d'Annuaire prêt...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
