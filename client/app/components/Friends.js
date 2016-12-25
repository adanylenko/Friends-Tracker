import {
	View,
	StyleSheet,
	Text
} from 'react-native';
import React, {Component} from 'react'

import { observer, inject } from 'mobx-react/native'
import { Actions } from 'react-native-router-flux'

import { FormLabel, FormInput, Button, List, ListItem} from 'react-native-elements'



const styles = StyleSheet.create({
	section: {
		marginTop: 10
	}
})



@inject('friends')
@observer
class Friends extends Component {
	constructor(props) {
		super(props)
		this.state = {
			friendField: 'name'
		}
	}

	componentWillMount() {
		this.props.friends.update()
	}

	addFriend() {
		this.props.friends.add(this.state.friendField)
		this.setState({friendField : ''})
	}

	renderFriends() {
		return this.props.friends.list.map(f => 
			<ListItem
				key={f.id}
				title={f.login}
			/>
		)
	}

	render() {
		return (
			<View>
				<View style={styles.section}>
						<FormLabel>Add new friend</FormLabel>
						<FormInput
							onChange={event => this.setState({friendField: event.nativeEvent.text})}
							value={this.state.friendField}
						/>
					<Button
						backgroundColor={"#50d3bb"}
						large
						title='Add'
						onPress={this.addFriend.bind(this)}
					/>
				</View>
				<View style={styles.section}>
					<FormLabel>Your friends</FormLabel>
					<List containerStyle={{marginBottom: 20}}>
					{ this.renderFriends() }
					</List>
				</View>
			</View>
		)
	}
}


export default Friends
