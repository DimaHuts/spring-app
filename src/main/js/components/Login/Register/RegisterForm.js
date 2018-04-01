import React from 'react'
import Form from 'react-validation/build/form';
import Input from 'react-validation/build/input';
import Button from 'react-validation/build/button';
import * as validations from '../../../validations/index'
import * as api from '../../../api/login'
import * as loginActions from '../../../modules/login/actions';
import {connect} from 'react-redux';
import {bindActionCreators} from 'redux';
import InformationBlock from '../../InformationBlock';
import styles from '../../../styles/forms.sass'
import app from '../../../styles/app.sass'


class RegisterForm extends React.Component {

    constructor(props) {
        super(props)

        this.state = {
            user: {},
        }
    }

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

    onClickSave = (event) => {
        event.preventDefault();
        api.registerUser(JSON.stringify(this.state.user))
            .then(res => {
                this.props.loginActions.setLoginMessage(res.body.message);
            })
    }

    render () {
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
                        <Input type='email'
                               id='email'
                               validations={[validations.required, validations.email]}
                               onChange={ ::this.updateState }
                               placeholder='Email'/>
                    </div>

                    <div className={styles['form-group']}>
                        <Input type='password'
                               id='password'
                               name='password'
                               validations={[validations.required, validations.isEqual, validations.password]}
                               onChange={ ::this.updateState }
                               placeholder='Password'/>
                    </div>

                    <div className={styles['form-group']}>
                        <Input type='password'
                               id='confirmPassword'
                               name='confirm'
                               validations={[validations.required, validations.isEqual]}
                               onChange={ ::this.updateState }
                               placeholder='Confirm password'/>
                    </div>

                    <Button type='submit' onClick={ ::this.onClickSave }>
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

export default connect(mapStateToProps, mapDispatchToProps)(RegisterForm)