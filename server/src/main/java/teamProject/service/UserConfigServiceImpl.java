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
		try {
			userConfigDao.add(userConfig);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean deleteUserConfig(UserConfig userConfig) {
		try {
			userConfigDao.delete(userConfig);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	@Transactional
	public boolean changeUserConfig(UserConfig userConfig) {
		try {
			userConfigDao.update(userConfig);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public UserConfig getUserConfig(int id_user) {
		UserConfig userConfig = null;
		try {
			userConfig = userConfigDao.getUserConfig(id_user);
		} catch (Exception ex) {
			userConfig = null;
		}
		return userConfig;
	}
}
