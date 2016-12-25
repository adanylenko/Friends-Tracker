import {
	StyleSheet,
	View,
} from 'react-native';
import React, {Component} from 'react'

import { observer, inject } from 'mobx-react/native'

import MapView from 'react-native-maps';

const styles = StyleSheet.create({
	map: {
		position: 'absolute',
		top: 0, left: 0, right: 0, bottom: 0,
	},
})

@inject('friends')
@observer
class MapV extends Component {
	constructor(props) {
		super(props)
		this.state = {
			region: {
				latitude: 51.50188,
				longitude: 31.31613,
				latitudeDelta: 0.0922,
				longitudeDelta: 0.0421,
			},
		}
	}

	onRegionChange(region) {
		this.setState({ region })
	}



	render() {
		return (
			<View style={ styles.map }>
				<MapView
					style={ styles.map }
					region={this.state.region}
				>
				</MapView>
			</View>
		)
	}
}

export default MapV
