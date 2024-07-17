package cairomonorail;
public class LoginSession{
    String username;
    String password;
    public LoginSession(String username, String password) {
        this.username = username;
        this.password = password;
    }
    //the function matches the username and password with person from the DB
    //if there is no match it throws an "InvalidLoginException" object
    public void login() throws InvalidLoginException {
        Person user = Database.getPersonByUsername(username);
        if (user != null && user.getPassword().equals(password) && !user.isBanned()){
            Person.setActivePerson(user);
            user.displayFunctionalities();
        }
        else throw new InvalidLoginException("The username doesn't exist or the password is wrong");
    }
}
