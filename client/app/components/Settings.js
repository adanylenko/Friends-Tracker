import {
	View,
	StyleSheet,
	Text
} from 'react-native';
import React, {Component} from 'react'

import { observer, inject } from 'mobx-react/native'
import { Actions } from 'react-native-router-flux'

import { FormLabel, FormInput, Button } from 'react-native-elements'



const styles = StyleSheet.create({
	section: {
		marginTop: 10
	}
})


@inject('user')
@observer
class Settings extends Component {
	logout() {
		this.props.user.logout()
	}


	render() {
		return (
			<View>
				<View style={styles.section}>
					<Button
						backgroundColor={"#f46e6e"}
						large
						title='Log Out'
						onPress={this.logout.bind(this)}
					/>
				</View>
			</View>
		)
	}
}


export default Settings
