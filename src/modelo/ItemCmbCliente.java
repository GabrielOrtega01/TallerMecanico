package modelo;

public class ItemCmbCliente {

    private int idc;
    private String doc;
    private String nom;
    private String apelli;
    private String direcc;
    private String correo;

    public ItemCmbCliente() {
    }

    public ItemCmbCliente(int idc, String doc, String nom, String apelli, String direcc, String correo) {
        this.idc = idc;
        this.doc = doc;
        this.nom = nom;
        this.apelli = apelli;
        this.direcc = direcc;
        this.correo = correo;

    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApelli() {
        return apelli;
    }

    public void setApelli(String apelli) {
        this.apelli = apelli;
    }

    public String getDirecc() {
        return direcc;
    }

    public void setDirecc(String direcc) {
        this.direcc = direcc;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return doc;
    }

}
