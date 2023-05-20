import model.utilizatori.Cumparator;
import model.utilizatori.Vanzator;
import service.AuctionService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuctionService service = new AuctionService();
        service.AdaugaVanzator("Ion", 20, 100);
        service.AdaugaVanzator("Gheorghe", 30, 200);
        service.AdaugaVanzator("Vasile", 40, 300);
        service.AdaugaCumparator("Mihai", 20, 100);
        service.AdaugaCumparator("George", 30, 200);
        service.AdaugareArta(1, "Mona Lisa", 100, 1500, "Leonardo da Vinci");
        service.AdaugareAntichitate(1, "Vaza", 200, 1000, "Grecia");
        service.AdaugareCelebritate(1, "Tricou", 300, "Ronaldo");
        service.AdaugareCelebritate(4, "Chitara", 300, "Elvis Presley");
        service.AfisareAvere(1);
        service.StergedinColectie(1, 1);
        service.AfisareAvere(1);
        service.CreareOferta(2, 5, 300);
        service.AfisareOferte();
        service.AfisareVanzatori();
        service.AfisareCumparatori();
        service.CreareOferta(3, 4, 250);
        service.AfisareOferte(3);
        service.CreareOferta(3, 5, 350);
        service.ModificareOferta(3, 4, 400);
        //service.AcceptareOferta(3, 4);
        service.AfisareColectie(4);
        service.AfisareAvere(1);
        service.AfisareOferte();
        service.CeaMaiBunaOferta();
    }
}