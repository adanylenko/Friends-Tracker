package teamProject.entities;

/**
 * Created by adanu on 31.10.2016.
 */
public class UserConfig {
    private int id;
    private int id_user;
	private int updateTime;
    private int alertZone;
    
    public UserConfig() {
	}
    
    public UserConfig(int id_user, int updateTime, int alertZone) {
		super();
		this.id_user = id_user;
		this.updateTime = updateTime;
		this.alertZone = alertZone;
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

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAlertZone() {
        return alertZone;
    }

    public void setAlertZone(int alertZone) {
        this.alertZone = alertZone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserConfig that = (UserConfig) o;

        if (id != that.id) return false;
        if (updateTime != that.updateTime) return false;
        if (alertZone !=that.alertZone) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + updateTime;
        result = 31 * result + alertZone;
        return result;
    }
}
