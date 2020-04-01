

public class PaisService {

	public static void create(PaisTO to) {
		PaisDAO.create(to);
	}
	
	public static PaisTO read(int id) {
		return PaisDAO.read(id);
	}
	
	public static void update(int id, PaisTO to) {
		PaisDAO.update(id, to);
	}
	
	public static void delete(int id) {
		PaisDAO.delete(id);
	}
	
	public static PaisTO maiorPopulacao() {
		return PaisDAO.maiorPopulacao();
	}
	
	public static PaisTO menorArea() {
		return PaisDAO.menorArea();
	}
	
	public static Pais[] tresPaises() {
		return PaisDAO.tresPaises();
	}
}
