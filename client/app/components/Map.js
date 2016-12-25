import {
	StyleSheet,
	View,
} from 'react-native';
import React, {Component} from 'react'

import MapView from 'react-native-maps';

const styles = StyleSheet.create({
	map: {
		position: 'absolute',
		top: 0, left: 0, right: 0, bottom: 0,
	},
})

class MapV extends Component {
	constructor() {
		super();
	}

	render() {
		return (
			<View style={ styles.map }>
				<MapView
					style={ styles.map }
					initialRegion={{
						latitude: 37.78825,
						longitude: -122.4324,
						latitudeDelta: 0.0922,
						longitudeDelta: 0.0421,
					}}
				/>
			</View>
		)
	}
}

export default MapV
