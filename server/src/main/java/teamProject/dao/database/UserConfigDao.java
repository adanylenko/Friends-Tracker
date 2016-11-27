package teamProject.dao.database;

import java.util.List;

import teamProject.entities.UserConfig;

public interface UserConfigDao {
	boolean add(UserConfig userConfig);

	boolean update(UserConfig userConfig);

	boolean delete(UserConfig userConfig);

	UserConfig getbyId(int id);

	List<UserConfig> getAll();

	UserConfig getUserConfig(int id_user);
}
