import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class NotesImpl extends UnicastRemoteObject implements INotes {

    private Map<String, Double> notes;

    protected NotesImpl() throws RemoteException {
        super();
        this.notes = new HashMap<>();
    }

    @Override
    public synchronized void ajouterNote(String etudiant, double note) throws RemoteException {
        notes.put(etudiant, note);
        
        System.out.println("[SERVEUR] Note ajoutée : " + etudiant + " -> " + note);
    }

    @Override
    public synchronized double getNote(String etudiant) throws RemoteException {
        
        return notes.getOrDefault(etudiant, -1.0);
    }

    @Override
    public synchronized Map<String, Double> getToutesLesNotes() throws RemoteException {
        return new HashMap<>(notes);
    }
}