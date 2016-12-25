import {
	View,
	TextInput,
	StyleSheet,
	Text
} from 'react-native';
import React, {Component} from 'react'

import { Actions } from 'react-native-router-flux'
import { observer, inject } from 'mobx-react/native'
import { FormLabel, FormInput, Button } from 'react-native-elements'

const styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
	},
})


@inject('user')
@observer
export default class Login extends Component {

	login() {
		let { user } = this.props
		user.setLogin()
	}

	render() {
		let { user } = this.props
		return (
			<View style={styles.container}>
				<View>
					<FormLabel>Name</FormLabel>
					<FormInput
						value={user.username}
						onChange={event => user.setUsername(event.nativeEvent.text)}
					/>
				</View>
				<View>
					<FormLabel>Password</FormLabel>
					<FormInput
						onChange={event => user.setPassword(event.nativeEvent.text)}
						value={user.password}
						secureTextEntry={true}
					/>
				</View>
				<View>
					<Button
						backgroundColor={"#50d3bb"}
						large
						title='Log In'
						onPress={this.login.bind(this)}
					/>
					<Button
						backgroundColor={"#eee"}
						color={"#444"}
						title='Sign Up'
						onPress={() => Actions.signup()}
					/>
				</View>
			</View>
		)
	}
}

