package teamProject.service.interfaces;

import teamProject.entities.UserConfig;

public interface UserConfigService {
	boolean addUserConfig(UserConfig userConfig);

	boolean deleteUserConfig(UserConfig userConfig);

	boolean changeUserConfig(UserConfig userConfig);

	UserConfig getUserConfig(int id_user);
}
