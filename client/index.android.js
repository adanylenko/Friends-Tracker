import React, { Component } from 'react';
import {
	AppRegistry,
} from 'react-native';


import App from './app/components/Root'

export default class Loco extends Component {
	render() {
		return (
			<App />
		)
	}
}

AppRegistry.registerComponent('Loco', () => Loco);
