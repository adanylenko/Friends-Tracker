package teamProject.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import teamProject.dao.database.UserConfigDao;
import teamProject.entities.UserConfig;
import teamProject.service.interfaces.UserConfigService;

public class UserConfigServiceImpl implements UserConfigService {
	private final static Logger LOG=LoggerFactory.getLogger(UserConfig.class);
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
			LOG.error("Error when try to add userconfig for user with id:{}"+userConfig.getId_user(),ex);
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
			LOG.error("Error when try to delete userconfig for user with id:{}"+userConfig.getId_user(),ex);
			return false;
		}
	}

	@Override
	@Transactional
	public boolean changeUserConfig(UserConfig userConfig) {
		try {
			userConfigDao.update(userConfig);
			return true;
		} catch (Exception ex) {
			LOG.error("Error when try to change userconfig for user with id:{}"+userConfig.getId_user(),ex);
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
			LOG.error("Error when try to get userconfig for user with id:{}"+id_user,ex);
			userConfig = null;
		}
		return userConfig;
	}
}
