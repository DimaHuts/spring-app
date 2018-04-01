import React from 'react';
import {connect} from 'react-redux';
import * as api from '../../../api/login'
import * as loginActions from '../../../modules/login/actions';
import {bindActionCreators} from 'redux';

const requireAuthentication = (Component) => {

    class AuthenticatedComponent extends React.Component {

        componentDidMount = () => {
            api.getUser()
                .then(res => {
                    const responseAuth = res.body.success;

                    this.props.setAuthenticated(responseAuth);
                    if (responseAuth === false) {
                        this.props.history.push('/login')
                    }
                })
        }

        render () {
            let template = <Component {...this.props}/>

            if (!this.props.isAuthenticated) {
                template = null;
            }

            return (
                <div>
                    {template}
                </div>
            )
        }
    }

    const mapStateToProps = (state) => ({
        isAuthenticated: state.loginReducer.isAuthenticated
    });

    const mapDispatchToProps = (dispatch) => ({
        setAuthenticated: bindActionCreators(loginActions.setAuthenticated, dispatch)
    })

    return connect(mapStateToProps, mapDispatchToProps)(AuthenticatedComponent);

}

export default requireAuthentication;