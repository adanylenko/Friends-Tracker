import { observable } from 'mobx'
import Friends from './Friends'
import Settings from './Settings'
import User from './User'

import Storage from 'react-native-storage'
import { AsyncStorage } from 'react-native'

export default class State {
	constructor() {
		let storage = new Storage({
			storageBackend: AsyncStorage,
		})
		this.friends = new Friends()
		this.settings = new Settings()
		this.user = new User(storage)
	}
}
