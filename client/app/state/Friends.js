import { addFriend, getFriends } from '../api'
import { observable } from 'mobx'

let user = null

export default class Friends {
	@observable list = []

	constructor(_user) {
		user = _user
	}

	async add(name) {
		await addFriend(name, user.token)
		this.update()
	}

	async update() {
		let friends =  await getFriends(user.token)
		if (friends != null) {
			this.list = friends
		}
	}

}

