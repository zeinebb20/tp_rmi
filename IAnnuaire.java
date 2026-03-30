import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IAnnuaire extends Remote {
    void ajouterContact(String nom, String numero) throws RemoteException;
    String rechercherNumero(String nom) throws RemoteException;
    List<String> listerContacts() throws RemoteException;
}
