package teamProject.dao.database;

import java.util.List;

import teamProject.entities.UserConfig;

public interface UserConfigDao {
	UserConfig add(UserConfig userConfig) throws Exception;

	UserConfig update(UserConfig userConfig) throws Exception;

	UserConfig delete(UserConfig userConfig) throws Exception;

	UserConfig getbyId(int id) throws Exception;

	List<UserConfig> getAll() throws Exception;

	UserConfig getUserConfig(int id_user) throws Exception;
}
