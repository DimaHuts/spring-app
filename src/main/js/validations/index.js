import React from 'react';
import validator from 'validator';

export const required = (value, props) => {
    if (!value.toString().trim().length && !props.checked) {
        return (
            <div className='row'>
                <span className='text-danger'>is required</span>
            </div>
        )
    }
};

export const email = (value) => {
    if (!validator.isEmail(value)) {
        return (
            <div className='row'>
                <span className='text-danger'>is not a valid email</span>
            </div>
        )
    }
};

export const isEqual = (value, props, components) => {
    const bothUsed = components.password[0].isUsed && components.confirm[0].isUsed;
    const bothChanged = components.password[0].isChanged && components.confirm[0].isChanged;

    if (bothChanged && bothUsed && components.password[0].value !== components.confirm[0].value) {
        return (
            <div className='row'>
                <span className='text-danger'>Passwords are not equal</span>
            </div>
        )
    }
};

export const password = (value) => {
    const regExp = (/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d\W]{8,}$/);

    if (!regExp.test(value)) {
        return (
            <div className='row'>
                <span className='text-danger'>Password must be at least 8 characters and contain one uppercase, one lowercase, one of special symbols and one number</span>
            </div>
        )

    }
};