package entities;

public class User {
	private int dni;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String mail;
	private String phone;
	private Boolean isAdmin;
	
	public User(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
	public User(String n, String s, int dni, String p, String m, String us, String pw) {
		this.setDni(dni);
		this.setUsername(us);
		this.setPassword(pw);
		this.setName(n);
		this.setSurname(s);
		this.setPhone(p);
		this.setMail(m);
		this.setIsAdmin(false);
	}
	
	public User() {
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}