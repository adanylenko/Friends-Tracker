package teamProject.dao.database;

import teamProject.entities.UserConfig;

public interface UserConfigDao {
	void addUserConfig(UserConfig config);
	void updateConfig(UserConfig config);
	void deleteConfig(UserConfig config);
	UserConfig getUserConfig(int id_user);
}
