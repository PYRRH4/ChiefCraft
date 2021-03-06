package minecraft;

/**
 * Created with IntelliJ IDEA.
 * User: Gabriel
 * Date: 10.06.13
 * Time: 10:55
 * To change this template use File | Settings | File Templates.
 */
public class User {
    private String username;
    private String password;
    private String sessionId;
    private String uid;

	private User() {

	}

    private User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private User(String username, String password, String sessionId, String uid) {
        this.username = username;
        this.password = password;
        this.sessionId = sessionId;
        this.uid = uid;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

	private static User instance;
	public static User getUser(String username, String password) {
		if(instance == null) {
			instance = new User(username, password);
		}

		return instance;
	}

	public static User getUser() {
		if(instance == null) {
			instance = new User();
		}

		return instance;
	}
}
