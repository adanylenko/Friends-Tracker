import {
	View,
	StyleSheet,
	Text
} from 'react-native';
import React, {Component} from 'react'

import { observer, inject } from 'mobx-react/native'
import { Actions } from 'react-native-router-flux'



const styles = StyleSheet.create({
})


class Friends extends Component {
	render() {
		return (
			<View>
				<Text>Friends list</Text>
			</View>
		)
	}
}


export default Friends
