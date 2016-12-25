import { action, observable, computed } from 'mobx'
import { sendPoint } from '../api'

let user = null
let settings = null

export default class Geo {
	constructor(_user, _settings) {
		user = _user
		settings = _settings
		this.interval = null
		this.setGeoTimeout()
	}

	setGeoTimeout() {
		if(this.interval === null) {
			setInterval(() => {

				if(!user.loggedIn) {
					console.log('not logged in')
					return
				}

				if(!settings.watch) {
					console.log('tracking disabled')
					return
				}

				navigator.geolocation.getCurrentPosition(
					(position) => {
						sendPoint(position, user.token)
					},
					(error) => console.log(JSON.stringify(error))
				)
			}, 5000)
		}
	}
}

