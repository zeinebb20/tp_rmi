import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServeurNotes {
    public static void main(String[] args) {
        try {
           
            NotesImpl notesService = new NotesImpl();

            
            Registry registry = LocateRegistry.createRegistry(1099);

            
            registry.rebind("NotesService", notesService);

            System.out.println("Serveur de Notes RMI prêt ");
        } catch (Exception e) {
            System.err.println("Erreur Serveur : " + e.toString());
            e.printStackTrace();
        }
    }
}