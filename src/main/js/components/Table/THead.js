import React from 'react'
import THeadItem from './THeadItem'

export default class THead extends React.Component {
    render () {
        return (
            <thead>
                <tr>
                    {
                        this.props.fields.map( (field, index) => (
                            <THeadItem key={index} field={field}/>
                        ))
                    }
                </tr>
            </thead>
        )
    }
}