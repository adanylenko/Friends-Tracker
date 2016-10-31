package teamProject.entities;

/**
 * Created by adanu on 31.10.2016.
 */
public class Friend {
	private int id;
    private int privilege;
    private int id_friend;
    private int id_user;
    
    public Friend() {
	}
    
    public Friend(int id_user, int id_friend, int privilege) {
		super();
		this.privilege = privilege;
		this.id_friend = id_friend;
		this.id_user = id_user;
	}

	public int getId_friend() {
		return id_friend;
	}

	public void setId_friend(int id_friend) {
		this.id_friend = id_friend;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend that = (Friend) o;

        if (id != that.id) return false;
        if (privilege !=that.privilege) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + privilege;
        return result;
    }
}
