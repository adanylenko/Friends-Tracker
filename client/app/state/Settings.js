import { observable, action } from 'mobx' 

export default class Settings {
	@observable watch = false

	constructor() {
		this.update_time = 10
		this.alert_zone = 50
	}

	@action disableWatching() {
		this.watch = false
	}

	@action enableWatching() {
		this.watch = true
	}

}
