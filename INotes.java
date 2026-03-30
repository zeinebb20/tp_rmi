
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface INotes extends Remote {
    void ajouterNote(String etudiant, double note) throws RemoteException;
    double getNote(String etudiant) throws RemoteException;
    Map<String, Double> getToutesLesNotes() throws RemoteException;
}