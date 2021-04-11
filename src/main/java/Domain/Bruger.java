package Domain;

public class Bruger {
    private String navn;
    private String password;

    public Bruger(String navn, String password) {
        this.navn = navn;
        this.password = password;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
