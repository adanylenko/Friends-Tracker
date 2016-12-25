import { observable } from 'mobx'
import Friends from './Friends'
import Settings from './Settings'
import User from './User'
import Geo from './Geo'

import Storage from 'react-native-storage'
import { AsyncStorage } from 'react-native'

export default class State {
	constructor() {
		let storage = new Storage({
			storageBackend: AsyncStorage,
		})
		this.settings = new Settings()
		this.user = new User(storage)
		this.friends = new Friends(this.user)
		this.geo = new Geo(this.user, this.settings)
	}
}
