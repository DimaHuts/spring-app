import React from 'react'
import * as api from '../../../api/login'
import Form from 'react-validation/build/form';
import Input from 'react-validation/build/input';
import Button from 'react-validation/build/button';
import * as validations from '../../../validations/index'
import {connect} from 'react-redux';
import * as loginActions from '../../../modules/login/actions';
import {bindActionCreators} from 'redux';
import InformationBlock from '../../InformationBlock';
import styles from '../../../styles/forms.sass'
import app from '../../../styles/app.sass'

class LoginForm extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            user: {}
        }
    }

    componentDidMount = () => {
        if (this.props.match.params.hasOwnProperty('token')) {
            api.confirmEmail(this.props.match.params.token)
                .then(res => {
                    this.props.loginActions.setLoginMessage(JSON.parse(res.text).message)
                })
        }
    }

    onClickSave = (event) => {
        event.preventDefault();

        const actions = this.props.loginActions;
        api.login(JSON.stringify(this.state.user))
            .then(() => {
                actions.setAuthenticated(true)
                actions.setLoginMessage('')
            }, err => {
                actions.setLoginMessage(err.response.body.error)
            });
    };

    updateState = (event) => {
        event.preventDefault();

        const key = event.target.id;
        const value = event.target.value;

        this.createUser(key, value);
    };

    createUser = (key, value) => {
        const user = this.state.user;

        user[key] = value;

        this.setState({
            user: user
        })
    };

    render() {
        return (
            <div className={app['block-center']}>
                <Form className={styles.form}>

                    <InformationBlock message={this.props.user.message} />

                    <div className={styles['form-group']}>
                        <Input type='text'
                               id='username'
                               validations={[validations.required]}
                               onChange={ ::this.updateState }
                               placeholder='Username'/>
                    </div>

                    <div className={styles['form-group']}>
                        <Input type='password'
                               id='password'
                               validations={[validations.required]}
                               onChange={ ::this.updateState }
                               placeholder='Password'/>
                    </div>

                    <Button type='submit'
                            onClick={ ::this.onClickSave }>
                        Save
                    </Button>
                </Form>
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
        loginActions: bindActionCreators(loginActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(LoginForm)