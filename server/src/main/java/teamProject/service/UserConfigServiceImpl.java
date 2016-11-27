package teamProject.service;

import javax.transaction.Transactional;

import teamProject.dao.database.UserConfigDao;
import teamProject.entities.UserConfig;
import teamProject.service.interfaces.UserConfigService;

public class UserConfigServiceImpl implements UserConfigService {
	private UserConfigDao userConfigDao;

	public void setUserConfigDao(UserConfigDao userConfigDao) {
		this.userConfigDao = userConfigDao;
	}

	@Override
	@Transactional
	public boolean addUserConfig(UserConfig userConfig) {
		if (userConfigDao.add(userConfig))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean deleteUserConfig(UserConfig userConfig) {
		if (userConfigDao.delete(userConfig))
			return true;
		return false;
	}

	@Override
	@Transactional
	public boolean changeUserConfig(UserConfig userConfig) {
		if (userConfigDao.update(userConfig))
			return true;
		return false;
	}

	@Override
	@Transactional
	public UserConfig getUserConfig(int id_user) {
		return userConfigDao.getUserConfig(id_user);
	}
}
