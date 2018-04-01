import React from 'react'
import * as api from '../../../api/login'

export default class LogoutButton extends React.Component {

    onLogout = (event) => {
        event.preventDefault();

        api.logout();
    }

    render () {
        return (
            <button onClick={ ::this.onLogout }>Logout</button>
        )
    }
}