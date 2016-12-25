import {
	View,
	StyleSheet,
	Text
} from 'react-native';
import React, {Component} from 'react'

import MapView from 'react-native-maps';
import { Provider, observer, inject } from 'mobx-react/native'
import { Router, Scene } from 'react-native-router-flux'

import MainButton from './MainButton'
import MapV from './Map'
import Friends from './Friends'
import Settings from './Settings'
import Login from './Login'
import Signup from './Signup'


import State from '../state'
let state = new State()

const styles = StyleSheet.create({
	map: {
		position: 'absolute',
		top: 0, left: 0, right: 0, bottom: 0,
	},
})


@inject('user')
@observer
class Home extends Component {
	componentWillMount() {
		let { user } = this.props
		user.loadLogin()
	}

	render() {
		console.log('token ', this.props.user.token)
		if(this.props.user.token === '') {
				return <Router>
					<Scene key="logIn" hideNavBar={true}>
						<Scene key="login" component={Login} initial />
						<Scene key="signup" component={Signup} />
					</Scene>
				</Router>
		}

		return (
			<View style={ styles.map }>
				<Router>
					<Scene key="root" hideNavBar={true}>
						<Scene key="map" component={MapV} initial />
						<Scene key="settings" component={Settings} />
						<Scene key="friends" component={Friends} />
					</Scene>
				</Router>
				<MainButton />
			</View>
		)
	}
}

const App = () => {
	return (
		<Provider
			settings={state.settings}
			friends={state.friends}
			user={state.user}
		>
			<Home />
		</Provider>
	)
}

export default App
