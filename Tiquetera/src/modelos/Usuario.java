package modelos;


public class Usuario {
	private int id;
    private String user;
    private String email;
    private String pass;
    private int type; //0 administrador, 1 vendedor, 2 comprador

    public Usuario() {
    }

    public Usuario(int id, String user, String email, String pass, int type) {
        this.id = id;
    	this.user = user;
        this.pass = pass;
        this.email = email;
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", type='" + type + '\'' +
                '}';
        
    }

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
