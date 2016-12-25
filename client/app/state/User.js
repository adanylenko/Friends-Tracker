import { action, observable } from 'mobx'
import { login, signup } from '../api'

let storage = null

export default class User {
	@observable username = '';
	@observable password = '';
	@observable token = '';

	constructor(_storage) {
		storage = _storage
	}

	@action setUsername(value) {
		this.username = value
	}

	@action setPassword(value) {
		this.password = value
	}

	@action logout() {
		let { username, password } = this
		storage.save({
			key: 'loginState',
			rawData: {
				login: username,
				password: password,
				token: '',
			}
		})
		this.token = ''
	}

	@action	async setLogin() {
		let { username, password } = this
		if(username === '' || password === '') return

		try {
			let token = await login(username, password)
			this.token = token
		} catch(err) {
			return
		}
		storage.save({
			key: 'loginState',
			rawData: {
				login: username,
				password: password,
				token: this.token,
			}
		})
	}

	@action async signUp() {
		let { username, password } = this
		if(username === '' || password === '') return

		try {
			let token = await signup(username, password)
			await this.setLogin()
		} catch(err) {
			console.log(err)
			return
		}
	}

	@action loadLogin() {
		storage.load({key: 'loginState'}).then( ret => {
			this.username = ret.login
			this.password = ret.password
			this.token = ret.token
		}).catch( err => {
			//TODO
			console.log('Not found login state')
		})
	}
}

