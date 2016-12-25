
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

export async function signup(login, password) {
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
