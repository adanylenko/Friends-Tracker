import React, { Component } from 'react';
import { StyleSheet, View } from 'react-native';
import ActionButton from 'react-native-action-button';
import Icon from 'react-native-vector-icons/Ionicons';
import { Actions } from 'react-native-router-flux'
import { inject, observer } from 'mobx-react/native'

const styles = StyleSheet.create({
  actionButtonIcon: {
    fontSize: 20,
    height: 22,
    color: 'white',
  },
})

@inject('settings')
@observer
export default class MainButton extends Component {
  render() {
		let { settings } = this.props
    return (
        <ActionButton buttonColor="rgba(231,76,60,1)">
					<ActionButton.Item buttonColor='#9b59b6' title="Settings"
						onPress={() => Actions.settings() }>
            <Icon name="md-settings" style={styles.actionButtonIcon} />
          </ActionButton.Item>

					<ActionButton.Item
						buttonColor='#3498db'
						title="Disable tracking"
							title={settings.watch ? "Disable tracking" : "Enable tracking"}
						onPress={() => {
							settings.watch ? settings.disableWatching() : settings.enableWatching()
						}}>
						<Icon
							name={settings.watch ? "md-eye" : "md-eye-off"}
							style={styles.actionButtonIcon} />
          </ActionButton.Item>

					<ActionButton.Item buttonColor='#1abc9c' title={"Friends"}
						onPress={() => Actions.friends()}>
            <Icon name="md-person" style={styles.actionButtonIcon} />
          </ActionButton.Item>

        </ActionButton>
    );
  }
}

