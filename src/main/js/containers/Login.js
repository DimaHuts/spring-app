import React from 'react'
import {connect} from 'react-redux';
import * as loginActions from '../modules/login/actions';
import {bindActionCreators} from 'redux';
import {Link} from 'react-router-dom';
import app from '../styles/app.sass'
import * as api from '../api/login'


class Login extends React.Component {

    componentDidMount = () => {
        const history  = this.props.history

        api.getUser()
            .then(res => {
                if (res.body.success) {
                    history.push('/')
                }
            })
    }

    componentWillUpdate = (nextProps) => {
        if (nextProps.user.isAuthenticated) {
            this.props.history.push('/')
        }
    }

    render () {

        return (
            <div className={app['block-center']}>
                <Link to='/register'>Register</Link>
                <Link to='/login'>Login</Link>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        user: state.loginReducer
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        loginActions: bindActionCreators(loginActions, dispatch),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Login)