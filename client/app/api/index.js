
const addr = "http://192.168.0.104:8080"



export async function login(login, password) {
	try {
		let response = await fetchJson(`${addr}/user/login`, 'POST', {
			login, password
		});
		let token = await response.text()
		console.log(token)
		return token;
	} catch(error) {
		console.log(error)
		return null
	}
}

export async function signup(login, password, phoneNumber) {
	try {
		let response = await fetchJson(`${addr}/user/register`, 'POST', {
			login, password, phoneNumber
		})
		let token = await response.text()
		return token;
	} catch(error) {
		console.log(error)
		return null
	}
}

export async function sendPoint(position, token) {
	let { latitude: lat, longitude: lng } = position.coords
	try {
		let response = await fetchJson(`${addr}/point/${token}`, 'PUT', {
			lat, lng
		})
		let ret = await response.text()
		return ret
	} catch(error) {
		console.log(error)
		return null
	}
}

export async function addFriend(login, token) {
	try {
		let response = await fetchJson(`${addr}/friend/${token}`, 'PUT', {
			login
		})
		let ret = await response.text()
		return ret
	} catch(error) {
		console.log(error)
		return null
	}
}

export async function getFriends(token) {
	try {
		let response = await fetch(`${addr}/friend/${token}`)
		let ret = await response.json()
		return ret
	} catch(error) {
		console.log(error)
		return null
	}
}

export async function getNearby(token) {
	try {
		let response = await fetch(`${addr}/friend/nearby/${token}`)
		let ret = await response.json()
		return ret
	} catch(error) {
		console.log(error)
		return null
	}
}

async function fetchJson(url, method, payload) {
	return fetch(url, {
		method: method,
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json',
			},
			body: JSON.stringify(payload)
	})
}
