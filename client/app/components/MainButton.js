import React, { Component } from 'react';
import { StyleSheet, View } from 'react-native';
import ActionButton from 'react-native-action-button';
import Icon from 'react-native-vector-icons/Ionicons';
import { Actions } from 'react-native-router-flux'

const styles = StyleSheet.create({
  actionButtonIcon: {
    fontSize: 20,
    height: 22,
    color: 'white',
  },
})

export default class MainButton extends Component {
  render() {
    return (
        <ActionButton buttonColor="rgba(231,76,60,1)">

					<ActionButton.Item buttonColor='#9b59b6' title="Settings"
						onPress={() => Actions.settings() }>
            <Icon name="md-settings" style={styles.actionButtonIcon} />
          </ActionButton.Item>

					<ActionButton.Item buttonColor='#3498db' title="Disable tracking"
						onPress={() => {}}>
            <Icon name="md-eye-off" style={styles.actionButtonIcon} />
          </ActionButton.Item>

					<ActionButton.Item buttonColor='#1abc9c' title={"Friends"}
						onPress={() => Actions.friends()}>
            <Icon name="md-person" style={styles.actionButtonIcon} />
          </ActionButton.Item>

        </ActionButton>
    );
  }
}

