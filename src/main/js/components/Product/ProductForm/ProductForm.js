import React from 'react'
import Form from 'react-validation/build/form';
import Input from 'react-validation/build/input';
import Button from 'react-validation/build/button';
import * as validations from '../../../validations/index'
import * as productApi from '../../../api/products'

export default class ProductForm extends React.Component {
    constructor(props) {
        super(props)

        this.state = {
            patient: {}
        }
    }

    updateState = (event) => {
        event.preventDefault();

        const key = event.target.id;
        const value = event.target.value;

        this.createPatient(key, value);
    };

    createPatient = (key, value) => {
        const patient = this.state.patient;

        patient[key] = value;

        this.setState({
            patient: patient
        })
    };

    sendPatient = (event) => {
        event.preventDefault();
        productApi.createPatient(this.state.patient)
            .then(res => {
                this.createPatient('id', res.body)
                this.props.addProduct(this.state.patient)
            })
    }

    render() {
        return (
            <Form>
                <Input  type='text'
                        id='name'
                        placeholder='name'
                        validations={[validations.required]}
                        onChange={ ::this.updateState }
                />

                <Input  type='number'
                        id='price'
                        placeholder='price'
                        validations={[validations.required]}
                        onChange={ ::this.updateState }
                />

                <Input  type='text'
                        id='description'
                        placeholder='description'
                        validations={[validations.required]}
                        onChange={ ::this.updateState }
                />

                <Button
                    onClick={this.sendPatient}
                >
                    Save
                </Button>
            </Form>
        )
    }
}