import React from 'react'

export default class InformationBlock extends React.Component {
    render () {
        return (
            <div className='row'>
                <span className='text-info'>{this.props.message}</span>
            </div>
        )
    }
}