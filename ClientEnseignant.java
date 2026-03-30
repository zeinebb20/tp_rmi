import java.rmi.registry.LocateRegistry;
import java.util.Map;

public class ClientEnseignant {
    public static void main(String[] args) {
        try {
    
            INotes service = (INotes) LocateRegistry.getRegistry(1099).lookup("NotesService");

            System.out.println("Envoi des notes...");
            service.ajouterNote("Ahmed", 15.5);
            service.ajouterNote("bibares", 12.0);

           
            String etudiant = "Ahmed";
            double note = service.getNote(etudiant);
            if (note == -1.0) {
                System.out.println("Étudiant " + etudiant + " non trouvé.");
            } else {
                System.out.println("Note de " + etudiant + " : " + note);
            }

          
            System.out.println("\nListe complète des notes :");
            Map<String, Double> toutes = service.getToutesLesNotes();
            if (toutes.isEmpty()) {
                System.out.println("Aucune note enregistrée.");
            } else {
                toutes.forEach((nom, val) -> System.out.println("- " + nom + " : " + val));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}