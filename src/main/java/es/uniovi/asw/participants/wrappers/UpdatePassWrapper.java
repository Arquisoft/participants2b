package es.uniovi.asw.participants.wrappers;

public class UpdatePassWrapper {
    private String login;
    private String password;
    private String newPassword;

    public UpdatePassWrapper() {
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getNewPassword() {
	return newPassword;
    }

    public void setNewPassword(String newPassword) {
	this.newPassword = newPassword;
    }

    @Override
    public String toString() {
	return "UpdatePassWrapper [login=" + login + ", password=" + password
		+ ", newPassword=" + newPassword + "]";
    }

}
